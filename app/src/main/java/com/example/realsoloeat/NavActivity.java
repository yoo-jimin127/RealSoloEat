package com.example.realsoloeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.soloeat.R;

public class NavActivity extends AppCompatActivity {

    LinearLayout menuClose;

    TextView mypages;
    TextView todayEat;
    TextView region;
    TextView food;
    TextView popularity;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav2);

        mypages = findViewById(R.id.mypages);
        todayEat = findViewById(R.id.todayEat);
        region = findViewById(R.id.region);
        food = findViewById(R.id.food);
        popularity = findViewById(R.id.popularity);
        time = findViewById(R.id.time);

        mypages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavActivity.this, mypageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        todayEat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavActivity.this, TodayeatActivity.class);
                startActivity(intent);
                finish();
            }
        });

        region.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavActivity.this, SpinnerActivity1.class);
                startActivity(intent);
                finish();
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavActivity.this, SpinnerActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        popularity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavActivity.this, SpinnerActivity3.class);
                startActivity(intent);
                finish();
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavActivity.this, SpinnerActivity4.class);
                startActivity(intent);
                finish();
            }
        });

        menuClose = findViewById(R.id.menuClose);
        menuClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}