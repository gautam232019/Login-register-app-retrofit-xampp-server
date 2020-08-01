package com.example.loginretrofit2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    /////REGISTER/////

    @GET("register.php")
    Call<Users> performRegister(
            @Query("name") String name,
            @Query("email") String email,
            @Query("password") String password
    );

    /////LOGIN/////

    @GET("login.php")
    Call<Users> performLogin(
            @Query("email") String email,
            @Query("password") String password
    );
}
