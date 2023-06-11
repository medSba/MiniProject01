package com.example.miniproject01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnquit,btnusers;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnquit=findViewById(R.id.btnquit);
        btnusers=findViewById(R.id.btnusers);

        btnusers.setOnClickListener(this);
        btnquit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnusers){
            InputStream inputStream=getResources().openRawResource(R.raw.users);
            try {
                Toast.makeText(this, Character.toString((char)inputStream.read()), Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else if (v.getId()==R.id.btnquit){
            finish();
        }
    }
}