package com.example.mygithub.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.mygithub.constants.Constants;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtils {
    public static boolean isPermissionReady(Context context, String[] permissions) {
        if (permissions == null || Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }

        for (String permission : Constants.permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }

        return true;
    }

    public static void requestPermissions(Activity activity, String[] permissions, int requestCode) {
        if (permissions == null || Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }

        List<String> mPermissionList = new ArrayList<>();

        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                // 添加未授予的权限
                mPermissionList.add(permission);
            }
        }

        // 有权限没通过，需要申请
        if (mPermissionList.size() > 0) {
            ActivityCompat.requestPermissions(activity, permissions, requestCode);
        }
    }
}
