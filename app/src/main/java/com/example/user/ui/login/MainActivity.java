package com.example.user.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.R;
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = getIntent();
        UserModel userModel = (UserModel)i.getSerializableExtra("userModel");
        TextView textView=findViewById(R.id.fullname);
        String resultName=userModel.userFirstName+" "+userModel.userSecondName;
        Runnable runnable = () -> textView.setText(resultName);
        new Thread(runnable).start();
    }

}