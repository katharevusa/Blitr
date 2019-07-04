package com.example.orbitalproject;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class FourColumn_ListAdapter extends ArrayAdapter<User> {

    private LayoutInflater mInflater;
    private ArrayList<User> users;
    private int mViewResourceId;

    public FourColumn_ListAdapter(Context context, int textViewResourceId, ArrayList<User> users) {
        super(context, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        User user = users.get(position);

        if (user != null) {
            TextView id = (TextView) convertView.findViewById(R.id.textID);
            TextView name = (TextView) convertView.findViewById(R.id.textName);
            TextView date = (TextView) convertView.findViewById(R.id.textDate);
            TextView amount = (TextView) convertView.findViewById(R.id.textAmount);
            if(id != null){
                id.setText(user.getID());
            }
            if (name != null) {
                name.setText(user.getName());
            }
            if (date != null) {
                date.setText(user.getDate());
            }
            if (amount != null) {
                amount.setText(user.getAmount());
            }
        }

        return convertView;
    }
}