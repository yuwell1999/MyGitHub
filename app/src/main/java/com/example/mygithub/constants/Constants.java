package com.example.mygithub.constants;

import android.Manifest;

public class Constants {
    public static final String AUTHOR_URL = "https://github.com/login/oauth/authorize";
    public static final String CLIENT_ID = "74c29ed1c122fa9547d1";
    public static final String CLIENT_SECRET = "671f67129c2d67417bac90200a1ee2f0ad66fb62";
    public static final String CALLBACK_URI = "androidgithub://callback";
    public static final String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
    public static final int WRITE_EXTERNAL_STORAGE_CODE = 100;
    public static String GITHUB_URL = "https://github.com/";
    public static String GITHUB_API_URL = "https://api.github.com/";
    public static int RESPONSE_COUNT_PER_PAGE = 30;
}
