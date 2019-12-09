package com.cookandroid.seongchwi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
    EditText login_id;
    EditText login_password;
    ImageView login_img;
    TextView signup_text;

    String Id = "seongchwi";
    String Password = "1111";

    String id, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        login_id = (EditText)findViewById(R.id.id);
        login_password = (EditText)findViewById(R.id.password);
        login_img = (ImageView)findViewById(R.id.login_img);
        signup_text = (TextView)findViewById(R.id.signup_btn);

        // 아이디 입력 란으로 Focus
        login_id.requestFocus();


        // 인텐트를 받아와서 Acitivity가 signup일 경우 회원가입 성취 Toast 띄움
        Intent intent = getIntent();
        String activity = intent.getStringExtra("Activity");
        if(activity.equals("signup")){
            String signup_id = intent.getStringExtra("id");
            Toast.makeText(LoginActivity.this, signup_id + "님 회원가입 성취", Toast.LENGTH_LONG).show();
        }

        // 로그인 버튼(사진) 눌렀을 시
        login_img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                id = login_id.getText().toString();
                pwd = login_password.getText().toString();

                // 아이디와 비밀번호 란이 빈칸인지 확인
                if(id.length() == 0){
                    Toast.makeText(LoginActivity.this, "아이디를 입력하세요", Toast.LENGTH_LONG).show();
                    login_id.requestFocus();
                    return;
                }
                if(pwd.length() == 0){
                    Toast.makeText(LoginActivity.this, "비밀번호를 입력하세요", Toast.LENGTH_LONG).show();
                    login_password.requestFocus();
                    return;
                }

                // id랑 password 데이터베이스 확인
                // 임시로 String Id = "seongchwi" 와 String Password = "1111"로 확인
                if(id.equals(Id) && pwd.equals(Password)){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                    finish();
                }
                else{
                    login_id.setText("");
                    login_password.setText("");
                    Toast.makeText(getApplicationContext(), "회원정보가 없습니다.", Toast.LENGTH_LONG).show();
                }
            }
        });

        // 회원가입 텍스트뷰 눌렀을 시
        signup_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                finish();
            }
        });
    }
}
