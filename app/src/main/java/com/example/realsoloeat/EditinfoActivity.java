package com.example.realsoloeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.soloeat.R;

public class EditinfoActivity extends AppCompatActivity implements View.OnClickListener{
    EditText idView;
    EditText passView;
    EditText nameView;
    EditText ageView;
    Button addBtn;
    Button move_login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editinfo);

        idView = findViewById(R.id.add_id);
        passView = findViewById(R.id.add_pass);
        nameView = findViewById(R.id.add_name);
        ageView = findViewById(R.id.add_age);

        addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(this);

        move_login_btn = findViewById(R.id.move_login_btn);
        addBtn.setOnClickListener(this);

//        move_login_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        String title = idView.getText().toString();
        String content = passView.getText().toString();
        String name = nameView.getText().toString();
        String age = ageView.getText().toString();

        DBHelperEditinfo helper = new DBHelperEditinfo(this);
        SQLiteDatabase db = helper.getWritableDatabase(); //데이터 베이스 여는 작업
    db.execSQL("insert into tb_memo (title, content, name, age) values (?, ?, ?, ?)", new String[]{title, content, name, age});
    db.close();

    Intent intent = new Intent(this, ReadDbActivityEditinfo.class);
    startActivity(intent);
    }
}