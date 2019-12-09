package com.cookandroid.seongchwi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.WindowManager;

public class CompanyActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_company);
    }
}
