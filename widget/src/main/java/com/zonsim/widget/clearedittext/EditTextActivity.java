package com.zonsim.widget.clearedittext;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.zonsim.widget.R;

/**
 * ^-^
 * Created by tang-jw on 2017/7/4.
 */

public class EditTextActivity extends AppCompatActivity {
    
    private EditText mEditText;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);
        
        mEditText = (EditText) findViewById(R.id.et_text);
        
    }
}
