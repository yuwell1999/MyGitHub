package com.example.mygithub.utils;

import com.example.mygithub.constants.Constants;
import com.example.mygithub.service.GitHubService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubServiceUtils {
    private static GitHubService gitHubService = null;
    private static GitHubService gitHubApiService = null;

    public static GitHubService getGitHubService() {
        if (gitHubService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.GITHUB_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            gitHubService = retrofit.create(GitHubService.class);
        }
        return gitHubService;
    }

    public static GitHubService getGitHubApiService() {
        if (gitHubApiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.GITHUB_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            gitHubApiService = retrofit.create(GitHubService.class);
        }
        return gitHubApiService;
    }
}
