package com.example.realsoloeat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.soloeat.R;

import java.io.BufferedReader;

public class ReadDbActivityRegister extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_db_register);
        TextView idView = findViewById(R.id.read_title);
        TextView passView = findViewById(R.id.read_content);
        TextView nameView = findViewById(R.id.read_name);
        TextView ageView = findViewById(R.id.read_age);
        DBHelperRegister helper = new DBHelperRegister(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select title, content, name, age from tb_memo order by _id desc limit 1", null);
        while (cursor.moveToNext()) {
            idView.setText(cursor.getString(0));
            passView.setText(cursor.getString(1));
            nameView.setText(cursor.getString(2));
            ageView.setText(cursor.getString(3));
        }
        db.close();
    }
}

//    @Override
//    public void onClick(View v) {
//        Button move_login_btn = findViewById(R.id.move_login_btn);
//        move_login_btn.setOnClickListener((View.OnClickListener) this);
//
//        Intent intent = new Intent(this, LoginActivity.class);
//        startActivity(intent);

//        Intent intent1 = new Intent();
//        ComponentName componentName = new ComponentName("com.example.realsoloeat", "com.example.realsoloeat.LoginActivity");
//
//        intent1.setComponent(componentName);
//        startActivity(intent1);
