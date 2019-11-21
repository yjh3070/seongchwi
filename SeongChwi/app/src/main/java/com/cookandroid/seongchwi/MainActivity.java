package com.cookandroid.seongchwi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity{

    TextView idTv, pwdTv;

    TextView name;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextView)findViewById(R.id.name);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        Toast.makeText(getApplicationContext(), " " + id + "님 로그인 성취", Toast.LENGTH_LONG).show();
        name.setText(id+" 님");
    }
}
