package com.example.loginretrofit2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    public static ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.login_email);
        password = (EditText) findViewById(R.id.login_password);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
    }

    public void goToRegister(View view) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void Login(View view) {

        String email = this.email.getText().toString().trim();
        String password = this.password.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
        } else {
            SignInNow();
        }
    }

    private void SignInNow() {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Please Wait.......");
        dialog.show();

        Call<Users> call = apiInterface.performLogin(email.getText().toString(), password.getText().toString());
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                Toast.makeText(LoginActivity.this, "Logged in Successfully with" + response.body().getId(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = new Intent(LoginActivity.this, data.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Something went wrong, Please try again!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = new Intent(LoginActivity.this, data.class);
                startActivity(intent);
            }
        });
    }


}