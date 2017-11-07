package com.example.user.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Practical2 extends AppCompatActivity {

    public static final int REQUEST_PROFILE_UPDATE = 1;
    public static final String PROFILE_NAME = "my.edu.tarc.practical2.name";
    public static final String PROFILE_EMAIL = "my.edu.tarc.practical2.email";

    private TextView textViewName, textViewEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical2);


    }

    public void updateProfile(View view)
    {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivityForResult(intent, REQUEST_PROFILE_UPDATE);
        textViewName = (TextView)findViewById(R.id.textViewName);
        textViewEmail = (TextView)findViewById(R.id.textViewEmail);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Req code p a unique codet to indentify an intent
        //result code is result of an intent call; either ok or cancel
        // data is the actual data returned bu an intent

        if(requestCode == REQUEST_PROFILE_UPDATE)
        {
            String name, email;
            name = data.getStringExtra(PROFILE_NAME);
            email = data.getStringExtra(PROFILE_EMAIL);
            textViewName.setText(getString(R.string.name) + name);
            textViewEmail.setText(getString(R.string.email) + email);
        }
    }


    public void showMain(View v)
    {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        startActivity(intent);
    }

    public void showDail(View v)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri.parse("tel:"+ "0174281069");
        startActivity(intent);
    }

    public void showSwndTo(View v)
    {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + "seekt@tarc.edu.my"));

        startActivity(intent);

    }

    public void visitTARUC(View v)
    {
        String uri= "http://www.taruc.edu.my";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));

        startActivity(intent);

    }
}
