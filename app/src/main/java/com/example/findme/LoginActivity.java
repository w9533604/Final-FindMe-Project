package com.example.findme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText et_username, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setTitle("FindME | Login");

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

    }

    public void login(View view) {
        String username = et_username.getText().toString().trim();
        String password = et_password.getText().toString().trim();

        MyDatabase myDb = new MyDatabase(this);
        SQLiteDatabase db = myDb.getReadableDatabase();

        String[] columns = {"name", "password"};
        String[] cValues = {et_username.getText().toString(), et_password.getText().toString()};

        Cursor cursor = db.query("User", columns, "name=? AND password=?", cValues, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
//                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                String strName = et_username.getText().toString();
                intent.putExtra("Username", strName);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "wrong login details", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void btn_login(View view) {
        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
        finish();
    }
}