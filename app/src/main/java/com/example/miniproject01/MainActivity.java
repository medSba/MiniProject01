package com.example.miniproject01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
            try {
                InputStream inputStream=getAssets().open("users.json");
                int code;
                StringBuilder sb=new StringBuilder();
                String jsonString;
                code=inputStream.read();
                while (code!=-1){
                    sb.append((char)code);
                    code=inputStream.read();
                }
                jsonString=sb.toString();
                JSONObject jsonObject=new JSONObject(jsonString);
                JSONArray jsonArray=jsonObject.getJSONArray("users");
                StringBuilder sbfname=new StringBuilder();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject user=jsonArray.getJSONObject(i);
                    JSONObject userName=user.getJSONObject("name");
                    String fullname=String.format("%s $s\n",userName.get("first"),userName.get("last"));
                    sbfname.append(fullname);
                }
                Toast.makeText(this, sbfname, Toast.LENGTH_SHORT).show();
            } catch (IOException |JSONException e) {
                throw new RuntimeException(e);
            }
        }else if (v.getId()==R.id.btnquit){
            finish();
        }
    }
}