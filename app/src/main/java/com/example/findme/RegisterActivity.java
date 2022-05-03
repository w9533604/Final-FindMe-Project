package com.example.findme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText et_name, et_email, et_password, et_confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle("FindME | Register");

        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        et_confirmPassword = findViewById(R.id.et_confirmPassword);

    }

    public void register(View view) {

        String name = et_name.getText().toString();
        String email = et_email.getText().toString();
        String password = et_password.getText().toString();
        String confirmPassword = et_confirmPassword.getText().toString();

        MyDatabase myDb = new MyDatabase(this);
        SQLiteDatabase db = myDb.getWritableDatabase();


        if(TextUtils.isEmpty(name)){
            Toast.makeText(this, "Please Enter Name", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(confirmPassword)){
            Toast.makeText(this, "Please Enter Confirm Password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(password.length()<6){
            Toast.makeText(this, "Password too short", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!password.equals(confirmPassword)){
            Toast.makeText(this, "Password not match", Toast.LENGTH_SHORT).show();
            return;
        }

        if(password.equals(confirmPassword)){

            ContentValues values=new ContentValues();
            values.put("name",name);
            values.put("email",email);
            values.put("password",password);

            db.insert("User",null,values);
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
            Toast.makeText(this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public void btn_register(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }
}