package com.example.girlsshopping.data;

import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;


import androidx.fragment.app.FragmentActivity;

import com.example.girlsshopping.R;
import com.example.girlsshopping.products.AddProductActivity;
import com.facebook.*;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class FacebookLogin extends FragmentActivity
{
    private TextView tvfirst_name, tvlast_namee, tvfull_name, tvEmail;
    private CallbackManager callbackManager;
    LoginButton loginButton;
    String email,name,first_name,last_name;
    AccessTokenTracker accessTokenTracker;
    AccessToken accessToken;
        private static final String EMAIL = "email";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_facebook_login);

        callbackManager = CallbackManager.Factory.create();


        tvfirst_name=findViewById(R.id.full_name);
        tvEmail=findViewById(R.id.email);


        loginButton = (LoginButton) findViewById(R.id.login_button);
        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                Intent intent = new Intent(getApplicationContext(), AddProductActivity.class);
                startActivity(intent);
            }
        });





        ////////////////////////////////////////





    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}