package com.fe.customeralert.customeralert.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.fe.customeralert.customeralert.R;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="myApp";
    private Button buttonLogout;
    private Button buttonOkay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOkay = findViewById(R.id.okay);
        buttonOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myToken= FirebaseInstanceId.getInstance().getToken();
                Log.d(TAG,"Token: " +myToken);
                Toast.makeText(MainActivity.this,"Token: "+myToken,Toast.LENGTH_LONG);
            }
        });

        buttonLogout = findViewById(R.id.logout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                Intent intent=new Intent(MainActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });
    }
}
