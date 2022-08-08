package com.pr.java_note_app_mvvm_room_database_.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;

import com.pr.java_note_app_mvvm_room_database_.R;

public class MainActivity3Launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_launcher);


        getWindow().setStatusBarColor(Color.parseColor("#0064bc"));
        Handler handler=new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(MainActivity3Launcher.this,MainActivity.class));
            finish();
        },2000);
    }
}