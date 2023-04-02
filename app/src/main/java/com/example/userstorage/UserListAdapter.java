package com.example.userstorage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private Context context;
    private ArrayList<User> users = new ArrayList<>();

    public UserListAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.user_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.txtUserName.setText(users.get(position).getFirstName() +" "+ users.get(position).getLastName());
        holder.txtEmail.setText(users.get(position).getEmail());
        holder.txtDegreeProgram.setText(users.get(position).getDegreeProgram());
        if(users.get(position).getCompletedPrograms().size() != 0) {
            String txtCompletedPrograms = "Suoritetut tutkinnot:\n";
            for (int i = 0; i < users.get(position).getCompletedPrograms().size(); i++) {
                txtCompletedPrograms = txtCompletedPrograms.concat(users.get(position).getCompletedPrograms().get(i) + "\n");
            }
            holder.txtCompletedProgramsList.setText(txtCompletedPrograms);
        } else {
            holder.txtCompletedProgramsList.setText("Ei vielä suoritettuja tutkintoja");
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
