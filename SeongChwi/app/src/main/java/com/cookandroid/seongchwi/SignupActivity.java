package com.cookandroid.seongchwi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends BaseActivity{
    EditText signup_id, signup_password, password_check, signup_email;
    ImageView signup_img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup_id = (EditText)findViewById(R.id.signup_id);
        signup_password = (EditText)findViewById(R.id.signup_password);
        password_check = (EditText)findViewById(R.id.password_check);
        signup_email = (EditText)findViewById(R.id.email);
        signup_img = (ImageView)findViewById(R.id.signup_img);

        signup_id.requestFocus();

        signup_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = signup_id.getText().toString();
                String pwd = signup_password.getText().toString();
                String pwdCheck = password_check.getText().toString();
                String email = signup_email.getText().toString();

                // 아이디, 비밀번호, 비밀번호 확인, 이메일이 적혔는지 확인
                if(id.length() == 0){
                    Toast.makeText(SignupActivity.this, "아이디를 입력하세요", Toast.LENGTH_LONG).show();
                    signup_id.requestFocus();
                    return;
                }
                if(pwd.length() == 0){
                    Toast.makeText(SignupActivity.this, "비밀번호를 입력하세요", Toast.LENGTH_LONG).show();
                    signup_password.requestFocus();
                    return;
                }
                if(pwdCheck.length() == 0){
                    Toast.makeText(SignupActivity.this, "비밀번호 확인을 입력하세요", Toast.LENGTH_LONG).show();
                    password_check.requestFocus();
                    return;
                }
                if(email.length() == 0){
                    Toast.makeText(SignupActivity.this, "이메일을 입력하세요", Toast.LENGTH_LONG).show();
                    signup_email.requestFocus();
                    return;
                }

                // 아이디가 DB에 이미 있는지 확인

                // 비밀번호와 비밀번호 확인이 같은지 확인
                if(!pwd.equals(pwdCheck)){
                    Toast.makeText(getApplicationContext(), "비밀번호가 다릅니다", Toast.LENGTH_LONG).show();
                    signup_password.requestFocus();
                    return;
                }

                // 비밀번호가 8자리 이상인지 확인
                if(pwd.length() < 8){
                    Toast.makeText(getApplicationContext(), "비밀번호는 8자리 이상 입력해주세요", Toast.LENGTH_LONG).show();
                    signup_password.setText("");
                    password_check.setText("");
                    signup_password.requestFocus();
                    return;
                }

                // 비밀번호에 숫자가 포함되어 있는지 확인
                if(!numCheck(pwd)){
                    Toast.makeText(SignupActivity.this, "비밀번호는 숫자를 포함하여 입력해주세요", Toast.LENGTH_LONG).show();
                    signup_password.setText("");
                    password_check.setText("");
                    signup_password.requestFocus();
                    return;
                }

                // 비밀번호에 문자가 포함되어 있는지 확인
                if(!letterCheck(pwd)){
                    Toast.makeText(SignupActivity.this, "비밀번호는 문자를 포함하여 입력해주세요", Toast.LENGTH_LONG).show();
                    signup_password.setText("");
                    password_check.setText("");
                    signup_password.requestFocus();
                    return;
                }

                // 이메일이 DB에 이미 있는지 확인


                // 이메일 형식으로 입력되었는지 확인
//                Pattern p = Pattern.compile("^[a-zA-X0-9]@[a-zA-Z0-9].[a-zA-Z0-9]");
//                Matcher m = p.matcher(signup_email.getText().toString());

                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    Toast.makeText(SignupActivity.this,"이메일 형식이 아닙니다",Toast.LENGTH_SHORT).show();
                    signup_email.requestFocus();
                    return;
                }


                // DB에 아이디와 비밀번호, 이메일 저장


                // 로그인 액티비티로 넘어가면서 액티비티 정보와 아이디를 전달
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                intent.putExtra("Activity", "signup");
                intent.putExtra("id", id);
                startActivity(intent);
                finish();
            }
        });
    }

    // 문자열에 숫자가 들어있는지 확인
    public static boolean numCheck(String string){
       for(int i = 0; i < string.length(); i++){
            if (Character.isDigit(string.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean letterCheck(String string){
        for(int i = 0; i < string.length(); i++){
            if (Character.isLetter(string.charAt(i))){
                return true;
            }
        }
        return false;
    }
}
