package com.example.realsoloeat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.soloeat.R;

public class mypageActivity extends AppCompatActivity {

    TextView val_name;
    TextView val_id;
    TextView val_age;
    TextView val_nick;
    TextView val_level;
    Button bookmark_btn;
    Button edit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        val_name = findViewById(R.id.val_name);
        val_id = findViewById(R.id.val_id);
        val_age = findViewById(R.id.val_age);
        val_nick = findViewById(R.id.nick_text);
        val_level = findViewById(R.id.level_text);
        bookmark_btn = findViewById(R.id.bookmark_btn);
        edit_btn = findViewById(R.id.btn_edit);

        bookmark_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mypageActivity.this, BookmarkActivity.class);
                startActivity(intent);
            }
        });

        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mypageActivity.this, EditinfoActivity.class);
                startActivity(intent);
            }
        });

//        Intent intent = getIntent();
//        String userNick = intent.getStringExtra("userID");
//        String userName = intent.getStringExtra("userName");
//        String userID = intent.getStringExtra("userID");
//        String userAge = intent.getStringExtra("userAge");
//
//        val_nick.setText(userID);
//        val_name.setText(userName);
//        val_id.setText(userID);
//        val_age.setText(userAge);
    }
}