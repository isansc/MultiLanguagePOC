package com.isansc.multilanguagepoc.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.isansc.multilanguagepoc.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(R.string.main_title);

        View txtLabel = findViewById(R.id.txt_main_label);
        txtLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.main_message, Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton btnNext = findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Internal1Activity.class);
                startActivity(intent);
            }
        });
    }
}
