package com.example.mygithub.service;

import com.example.mygithub.model.AccessToken;
import com.example.mygithub.model.CommitInfo;
import com.example.mygithub.model.FileContent;
import com.example.mygithub.model.Release;
import com.example.mygithub.model.Repo;
import com.example.mygithub.model.SearchResult;
import com.example.mygithub.model.UserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubService {
    @Headers("Accept: application/json")
    @POST("login/oauth/access_token")
    @FormUrlEncoded
    Call<AccessToken> getAccessToken(@Field("client_id") String clientID,
                                     @Field("client_secret") String clientSecret,
                                     @Field("code") String code
    );


    @GET("{user_name}/{repo_type}")
    Call<List<Repo>> getRepos(@Path(value = "user_name", encoded = true) String userName,
                              @Path(value = "repo_type", encoded = true) String type,
                              @Header("Authorization") String accessToken
    );

    @GET("repos/{repo_name}/contents{file_path}")
    Call<List<FileContent>> getContentsOfRepo(@Path(value = "repo_name", encoded = true) String repoName,
                                              @Path(value = "file_path", encoded = true) String filePath,
                                              @Header("Authorization") String accessToken
    );


    @GET("repos/{repo_name}/commits")
    Call<List<CommitInfo>> getCommitsInfo(@Path(value = "repo_name", encoded = true) String repoName,
                                          @Header("Authorization") String accessToken,
                                          @Query("page") int page
    );

    @GET("repos/{repo_name}/contributors")
    Call<List<UserInfo>> getContributors(@Path(value = "repo_name", encoded = true) String repoName,
                                         @Header("Authorization") String accessToken
    );

    @GET("repos/{repo_name}/releases")
    Call<List<Release>> getReleases(@Path(value = "repo_name", encoded = true) String repoName,
                                    @Header("Authorization") String accessToken
    );

    @GET("{user_name}")
    Call<UserInfo> getInfo(@Path(value = "user_name", encoded = true) String userName,
                           @Header("Authorization") String accessToken
    );

    @GET("{user_name}/{user_type}")
    Call<List<UserInfo>> getUsers(@Path(value = "user_name", encoded = true) String userName,
                                  @Path(value = "user_type", encoded = true) String userType,
                                  @Header("Authorization") String accessToken
    );

    @GET("search/repositories")
    Call<SearchResult<Repo>> getSearchRepos(@Query("q") String name,
                                            @Header("Authorization") String accessToken,
                                            @Query("page") int page
    );

    @GET("search/users")
    Call<SearchResult<UserInfo>> getSearchUsers(@Query("q") String name,
                                                @Header("Authorization") String accessToken,
                                                @Query("page") int page
    );
}
