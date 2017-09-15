package com.matib05.android.justsignup.view;

import com.matib05.android.justsignup.model.GithubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by matib05 on 9/13/2017.
 */

public interface GithubClient {

    @GET("/users/{username}/repos")
    Call<List<GithubRepo>> reposForUser(@Path("username") String user);
}
