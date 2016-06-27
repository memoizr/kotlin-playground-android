package com.memoizlabs.kotlin_playground;

import com.memoizlabs.kotlin_playground.com.kotlin_playground.R;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_hello);
    }
}
