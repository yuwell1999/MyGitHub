package com.example.mygithub.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mygithub.R;
import com.example.mygithub.constants.Constants;
import com.example.mygithub.model.AccessToken;
import com.example.mygithub.utils.GithubServiceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Button mLoginButton;
    private SharedPreferences mSharedPreferences;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

        mLoginButton = findViewById(R.id.loginButton);

        Log.d("LoginActivity", "<----------onCreate------------->");

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(Constants.AUTHOR_URL +
                                "?client_id=" + Constants.CLIENT_ID +
                                "&scope=repo&redirect_url=" + Constants.CALLBACK_URI));
                startActivity(intent);
                LoginActivity.this.finish();
            }
        });

        mSharedPreferences = getSharedPreferences("loginStat", Context.MODE_PRIVATE);
        boolean alreadyLogin = mSharedPreferences.getBoolean("login", false);
        if (alreadyLogin) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("LoginActivity", "<----------onResume------------->");

        Uri uri = getIntent().getData();
        if (uri != null && uri.toString().startsWith(Constants.CALLBACK_URI)) {
            mLoginButton.setEnabled(false);
            String code = uri.getQueryParameter("code");

            Call<AccessToken> call = GithubServiceUtils.getGitHubService().getAccessToken(
                    Constants.CLIENT_ID,
                    Constants.CLIENT_SECRET,
                    code);

            call.enqueue(new Callback<AccessToken>() {
                @Override
                public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                    if (response.body() != null && response.isSuccessful()) {
                        mSharedPreferences.edit()
                                .putBoolean("login", true)
                                .putString("accessToken", "token" + response.body().getAccessToken())
                                .apply();

                        Log.d("LoginActivity", "token=" + response.body().getAccessToken());

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        LoginActivity.this.finish();
                    }
                }

                @Override
                public void onFailure(Call<AccessToken> call, Throwable t) {
                    Log.d("LoginActivity", "Failed");
                    mLoginButton.setEnabled(true);
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}