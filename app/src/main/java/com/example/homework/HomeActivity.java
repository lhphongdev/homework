package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class HomeActivity extends AppCompatActivity {

    TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ToggleButton toggle =  findViewById(R.id.btnImage);
        ImageView avatar = findViewById(R.id.imgAvatar);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    avatar.setVisibility(View.VISIBLE);
                } else {
                    avatar.setVisibility(View.GONE);
                }
            }
        });

        displayText = findViewById(R.id.userInfo);
        displayText.setText(getIntent().getStringExtra("userInfo"));

    }
}