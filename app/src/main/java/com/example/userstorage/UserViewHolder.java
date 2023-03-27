package com.example.userstorage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView txtUserName, txtEmail, txtDegreeProgram;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        txtUserName = itemView.findViewById(R.id.txtUserName);
        txtEmail = itemView.findViewById(R.id.txtEmail);
        txtDegreeProgram = itemView.findViewById(R.id.txtDegreeProgram);
    }
}
