package com.example.realsoloeat;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import com.example.soloeat.R;

public class ReadDbActivityEditinfo extends AppCompatActivity {
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_db_editinfo);
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