package com.example.loginretrofit2;

import com.google.gson.annotations.SerializedName;

public class Post {
    //private String name;
    //@SerializedName("description")
    private int userId;
    private int id;
    private String title;
    @SerializedName("body")
    private String text;
    //private String website_link;
    //private String icowatchlist_url;
    //private String start_time;
    //private String end_time;
    //private String timezone;

//    public String getName() {
////        return name;
////    }
//
//    public String getText() {
//        return text;
//    }
//
//    public String getWebsite_link() {
//        return website_link;
//    }
//
//    public String getIcowatchlist_url() {
//        return icowatchlist_url;
//    }
//
//    public String getStart_time() {
//        return start_time;
//    }
//
//    public String getEnd_time() {
//        return end_time;
//    }
//
//    public String getTimezone() {
//        return timezone;
//    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }


}
