package com.aavidsoft.secondapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {

    private TextView txt;
    private EditText edt;
    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        txt = findViewById(R.id.txt);
        edt = findViewById(R.id.edt);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new BtnClickListener());

    }

    private class BtnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            txt.setText(edt.getText().toString());
        }
    }
}
