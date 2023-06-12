package com.example.miniproject01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private ArrayList<Users> user;
    LayoutInflater inflater;

    public UserAdapter( Context context,ArrayList<Users> user) {
        this.user = user;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return user.size();
    }

    @Override
    public Object getItem(int position) {
        return user.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.item_user,null);
        return convertView;
    }
}
