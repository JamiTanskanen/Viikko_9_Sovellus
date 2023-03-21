package com.example.viikko_9;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ListUsersActivity extends AppCompatActivity {

    private TextView textViewUsersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        textViewUsersList = findViewById(R.id.textViewUsersList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUsersList();
    }

    private void updateUsersList() {
        ArrayList<User> users = UserStorage.getInstance().getUsers();
        StringBuilder usersList = new StringBuilder();

        for (User user : users) {
            usersList.append(user.getFirstName())
                    .append(" ")
                    .append(user.getLastName())
                    .append(" - ")
                    .append(user.getEmail())
                    .append(" - ")
                    .append(user.getDegreeProgram())
                    .append("\n\n");
        }

        textViewUsersList.setText(usersList.toString());
    }
}
