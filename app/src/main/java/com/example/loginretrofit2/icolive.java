package com.example.loginretrofit2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class icolive extends Fragment {
    TextView textViewResult;
    private View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_icolive, container, false);
        textViewResult = (TextView) rootview.findViewById(R.id.text_view_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IcoLiveApi icoLiveApi = retrofit.create(IcoLiveApi.class);

        Call<List<Post>> call = icoLiveApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
            if(!response.isSuccessful()){
                textViewResult.setText("Code:"+response.code());
                return;
            }
            List<Post> posts = response.body();
                assert posts != null;
                for(Post post : posts){
                String content ="";
                content += "ID :" +post.getId() +"\n";
                content += "USER ID :" +post.getUserId() +"\n";
                content += "TITLE :" +post.getTitle() +"\n";
                content += "TEXT :" +post.getText() +"\n";
                textViewResult.append(content);
            }

            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
             textViewResult.setText(t.getMessage());
            }
        });
        return rootview;
    }
}