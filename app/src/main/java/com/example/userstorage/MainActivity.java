package com.example.userstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText firstNameInput;
    private EditText lastNameInput;
    private EditText emailInput;
    private RadioGroup degreeProgramInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameInput = findViewById(R.id.firstNameInput);
        lastNameInput = findViewById(R.id.lastNameInput);
        emailInput = findViewById(R.id.emailInput);
        degreeProgramInput = findViewById(R.id.degreeProgramInput);
    }

    public void addUser(View view) {
        if(TextUtils.isEmpty(firstNameInput.getText().toString().trim())) {
            System.out.println("Täytä kaikki kentät");
        } else if(TextUtils.isEmpty(lastNameInput.getText().toString().trim())) {
            System.out.println("Täytä kaikki kentät");
        } else if(TextUtils.isEmpty(emailInput.getText().toString().trim())) {
            System.out.println("Täytä kaikki kentät");
        } else {
            String firstName = firstNameInput.getText().toString();
            String lastName = lastNameInput.getText().toString();
            String email = emailInput.getText().toString();
            String degreeProgram;
            switch (degreeProgramInput.getCheckedRadioButtonId()) {
                case R.id.radioButtonTite:
                    degreeProgram = "Tietotekniikka";
                    UserStorage.getInstance().addUser(new User(firstName, lastName, email, degreeProgram));
                    break;
                case R.id.radioButtonTuta:
                    degreeProgram = "Tuotantotalous";
                    UserStorage.getInstance().addUser(new User(firstName, lastName, email, degreeProgram));
                    break;
                case R.id.radioButtonLate:
                    degreeProgram = "Laskennallinen tekniikka";
                    UserStorage.getInstance().addUser(new User(firstName, lastName, email, degreeProgram));
                    break;
                case R.id.radioButtonSate:
                    degreeProgram = "Sähkötekniikka";
                    UserStorage.getInstance().addUser(new User(firstName, lastName, email, degreeProgram));
                    break;
            }
        }
    }

    public void switchToUserListActivity(View view) {
        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);
    }

}