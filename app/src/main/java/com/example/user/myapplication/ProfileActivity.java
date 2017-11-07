package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    private EditText editTextName  , editTextEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
    }

    public void saveProfile(View view)
    {
        Intent intent = getIntent();
        String name, email;

        name = editTextName.getText().toString();
        email = editTextEmail.getText().toString();

        intent.putExtra(Practical2.PROFILE_NAME, name);
        intent.putExtra(Practical2.PROFILE_EMAIL, email);

        //return result to the main activity
        setResult(Practical2.REQUEST_PROFILE_UPDATE, intent);
        finish();
    }
}
