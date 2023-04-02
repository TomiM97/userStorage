package com.example.userstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText firstNameInput;
    private EditText lastNameInput;
    private EditText emailInput;
    private RadioGroup degreeProgramInput;
    private CheckBox cbKandi;
    private CheckBox cbDippa;
    private CheckBox cbTohtori;
    private CheckBox cbUimamaisteri;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameInput = findViewById(R.id.firstNameInput);
        lastNameInput = findViewById(R.id.lastNameInput);
        emailInput = findViewById(R.id.emailInput);
        degreeProgramInput = findViewById(R.id.degreeProgramInput);
        cbKandi = findViewById(R.id.cbKandi);
        cbDippa = findViewById(R.id.cbDippa);
        cbTohtori = findViewById(R.id.cbTohtori);
        cbUimamaisteri = findViewById(R.id.cbUimamaisteri);

        context = MainActivity.this;

        UserStorage.getInstance().loadUser(getApplicationContext());
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
            ArrayList<String> completedPrograms = checkCompletedPrograms();
            switch (degreeProgramInput.getCheckedRadioButtonId()) {
                case R.id.radioButtonTite:
                    degreeProgram = "Tietotekniikka";
                    UserStorage.getInstance().addUser(new User(firstName, lastName, email, degreeProgram, completedPrograms));
                    break;
                case R.id.radioButtonTuta:
                    degreeProgram = "Tuotantotalous";
                    UserStorage.getInstance().addUser(new User(firstName, lastName, email, degreeProgram, completedPrograms));
                    break;
                case R.id.radioButtonLate:
                    degreeProgram = "Laskennallinen tekniikka";
                    UserStorage.getInstance().addUser(new User(firstName, lastName, email, degreeProgram, completedPrograms));
                    break;
                case R.id.radioButtonSate:
                    degreeProgram = "Sähkötekniikka";
                    UserStorage.getInstance().addUser(new User(firstName, lastName, email, degreeProgram, completedPrograms));
                    break;
            }
        }
        UserStorage.getInstance().saveUser(context);
    }

    public ArrayList<String> checkCompletedPrograms() {
        ArrayList<String> completedPrograms = new ArrayList<>();
        if(cbKandi.isChecked()){
            completedPrograms.add("kandidaatin tutkinto");
        }
        if(cbDippa.isChecked()){
            completedPrograms.add("diplomi-insinöörin tutkinto");
        }
        if(cbTohtori.isChecked()){
            completedPrograms.add("tekniikan tohtorin tutkinto");
        }
        if(cbUimamaisteri.isChecked()){
            completedPrograms.add("uimamaisterin tutkinto");
        }
        return completedPrograms;
    }

    public void switchToUserListActivity(View view) {
        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);
    }

}