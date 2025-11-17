package com.aavidsoft.secondapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    private TextView txt;
    private EditText edt;
    private Button btn;
    private ImageView img;
    private Button btnAddView;
    private LinearLayout mainContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        txt = findViewById(R.id.txt);
        edt = findViewById(R.id.edt);
        btn = findViewById(R.id.btn);
        img = findViewById(R.id.img);
        btnAddView = findViewById(R.id.btnAddView);
        mainContainer = findViewById(R.id.mainContainer);

        btnAddView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btnNew = new Button(MainActivity.this);
                btnNew.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                btnNew.setText("New");
                mainContainer.addView(btnNew);
            }
        });

        /*btn.setOnClickListener(new BtnClickListener());
        txt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txt.setText("");
                    }
                }
        );*/

        MyViewOnClickListener myViewOnClickListener =
                new MyViewOnClickListener();
        btn.setOnClickListener(myViewOnClickListener);
        txt.setOnClickListener(myViewOnClickListener);

        img.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        img.setImageResource(R.drawable.bitcode);
                    }
                }
        );
    }

    private class MyViewOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(view == btn) {
                txt.setText(edt.getText());
            }
            if(view == txt) {
                txt.setText("");
            }
        }
    }

    private class BtnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            txt.setText(edt.getText().toString());
        }
    }
}
