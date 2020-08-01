package com.example.loginretrofit2;

import com.google.gson.annotations.SerializedName;

public class Users {

    @SerializedName("id")
    private String Id;

    @SerializedName("response")
    private String Response;

    public String getId() {
        return Id;
    }

    public String getResponse() {
        return Response;
    }
}
