package com.example.loginretrofit2;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IcoLiveApi {
    @GET("posts")
    Call<List<Post>> getPosts();
}
