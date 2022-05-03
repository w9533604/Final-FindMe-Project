package com.example.findme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    Button btn_location, btn_logout;
    TextView tv_getName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setTitle("Home Page");

        tv_getName = findViewById(R.id.tv_getName);
        btn_location = findViewById(R.id.btn_location);
        btn_logout = findViewById(R.id.btn_logout);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String j =(String) bundle.get("Username");
        tv_getName.setText(j);

        btn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


}