package com.isansc.multilanguagepoc.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.isansc.multilanguagepoc.R;

public class Internal1Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal1);

        setTitle(R.string.internal1_title);

        ImageButton btnNext = findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Internal1Activity.this, Internal2Activity.class);
                startActivity(intent);
            }
        });
    }
}
