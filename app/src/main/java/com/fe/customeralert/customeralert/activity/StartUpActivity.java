package com.fe.customeralert.customeralert.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.fe.customeralert.customeralert.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StartUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_start_up);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                StartLogInActivity();
            }
        },2000);
    }

    public void StartLogInActivity()
    {
        Intent MainIntent=new Intent(this, LogInActivity.class);
        startActivity(MainIntent);
        finish();
    }

//    public void printHashKey(Context pContext) {
//        try {
//            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                String hashKey = new String(Base64.encode(md.digest(), 0));
//                Log.i("khantey", "printHashKey() Hash Key: " + hashKey);
//            }
//        } catch (NoSuchAlgorithmException e) {
//            Log.e("khantey", "printHashKey()", e);
//        } catch (Exception e) {
//            Log.e("khantey", "printHashKey()", e);
//        }
//    }
}
