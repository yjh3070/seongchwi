package com.cookandroid.seongchwi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;


public class HireActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_hire);

        Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
        String[] items = new String[]{
                "인천",
                "대구",
                "대전",
                "세종",
                "경남",
                "경기",
                "부산",
                "광주",
                "울산",
                "강원",
                "경북"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);


        Spinner dropdown2 = (Spinner)findViewById(R.id.spinner2);
        String[] items2 = new String[]{
                "웹개발",
                "응용프로그램개발",
                "시스템개발",
                "서버·네트워크·보안",
                "ERP·시스템분석·설계",
                "데이터베이스·DBA",
                "퍼블리싱·UI개발",
                "웹디자인",
                "하드웨어·소프트웨어",
                "통신·모바일",
                "웹기획·PM"
        };
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown2.setAdapter(adapter2);

        ArrayAdapter myAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items);
    }
}
