package com.example.miniproject01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnusers;
    ListView lvUsers;
    TextView tvquit;

    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvquit=findViewById(R.id.tvquit);
        btnusers=findViewById(R.id.btnusers);
        lvUsers=findViewById(R.id.lvUsers);

        btnusers.setOnClickListener(this);
        tvquit.setOnClickListener(this);

        tvquit.setOnTouchListener(new onSwipeTouch(this) {
            @Override
            protected void swipeLeft() {
                finish();
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnusers){
            UserAdapter adapter=new UserAdapter(this,getUsers());
            lvUsers.setAdapter(adapter);
        }
    }

    private ArrayList<Users> getUsers() {
        ArrayList<Users> Users=new ArrayList<>();
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

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject user=jsonArray.getJSONObject(i);
                JSONObject userName=user.getJSONObject("name");
//                String fullname=String.format("%s %s\n",userName.get("first"),userName.get("last"));
                Users.add(new Users(
                        userName.getString("first"),
                        userName.getString("last"),
                        user.getString("gender"),
                        user.getString("city"))
                );
            }
        } catch (IOException |JSONException e) {
            throw new RuntimeException(e);
        }
        return Users;
    }
}