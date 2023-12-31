package com.example.miniproject01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    final int DOUBLE_CLICK=250;
    Context context;
    private ArrayList<Users> user;
    LayoutInflater inflater;
    TextView tvfname,tvcity,tvgender;

    public UserAdapter( Context context,ArrayList<Users> user) {
        this.context=context;
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
        Users users=user.get(position);
        convertView=inflater.inflate(R.layout.item_user,null);
        tvfname=convertView.findViewById(R.id.tvitemFullname);
        tvcity=convertView.findViewById(R.id.tvitemCity);
        ImageView ivcheck=convertView.findViewById(R.id.imgvchecked);

        tvfname.setText(users.fullName());
        tvcity.setText(users.getCity());
//       convertView.setOnLongClickListener(new View.OnLongClickListener() {
//           @Override
//           public boolean onLongClick(View v) {
//               AlertDialog.Builder builder=new AlertDialog.Builder(context);
//               builder.setTitle("Details of user "+(position+1));
//               builder.setMessage(users.toString()).show();
//               return false;
//           }
//       });
       convertView.setOnTouchListener(new View.OnTouchListener() {
           long lastclick=0;
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               switch (event.getAction()){
//                   case MotionEvent.ACTION_DOWN:
//                       Toast.makeText(context, "Down", Toast.LENGTH_SHORT).show();
//                       break;
                   case MotionEvent.ACTION_UP:
                       long clicktime=System.currentTimeMillis();
                       if ((clicktime-lastclick) <= DOUBLE_CLICK){
                           ivcheck.setVisibility(ivcheck.getVisibility()==View.INVISIBLE ? View.VISIBLE: View.INVISIBLE);
                       }
                       else {
                           lastclick=clicktime;
                       }
                       break;
               }

               return true;
           }
       });


        return convertView;
    }
}
