package com.cookandroid.seongchwi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity{

    TextView name;

    ImageView conference, company, hire, employ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        name = (TextView)findViewById(R.id.name);
        conference = (ImageView)findViewById(R.id.conference);
        company = (ImageView)findViewById(R.id.company);
        hire = (ImageView)findViewById(R.id.hire);
        employ = (ImageView)findViewById(R.id.employ);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        Toast.makeText(getApplicationContext(), " " + id + "님 로그인 성취", Toast.LENGTH_LONG).show();
        name.setText(id+" 님");

        conference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ConferenceActivity.class);
                startActivity(intent);
            }
        });

        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CompanyActivity.class);
                startActivity(intent);
            }
        });

        hire.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HireActivity.class);
                startActivity(intent);
            }
        });

        employ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EmployActivity.class);
                startActivity(intent);
            }
        });
    }


}
