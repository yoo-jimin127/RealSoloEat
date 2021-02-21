package com.example.realsoloeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.soloeat.R;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("참여하기");

        setContentView(R.layout.activity_join);

        TextView j_rest = findViewById(R.id.output1);
        TextView j_time_m = findViewById(R.id.output2_1);
        TextView j_time_d = findViewById(R.id.output2_2);
        TextView j_time_h = findViewById(R.id.output2_3);
        TextView j_total_num = findViewById(R.id.output3);
        TextView j_num = findViewById(R.id.output4);

        TextView j_per0 = findViewById(R.id.output5_1);
        TextView j_sex0 = findViewById(R.id.output5_2);
        TextView j_old0 = findViewById(R.id.output5_3);
        TextView j_lev0 = findViewById(R.id.output5_4);

        TextView j_per1 = findViewById(R.id.output6_1);
        TextView j_sex1 = findViewById(R.id.output6_2);
        TextView j_old1 = findViewById(R.id.output6_3);
        TextView j_lev1 = findViewById(R.id.output6_4);

        TextView j_per2 = findViewById(R.id.output7_1);
        TextView j_sex2 = findViewById(R.id.output7_2);
        TextView j_old2 = findViewById(R.id.output7_3);
        TextView j_lev2 = findViewById(R.id.output7_4);

        TextView j_detail = findViewById(R.id.detailshow);
        Button joincommit = findViewById(R.id.joingroup);
        Button joincancel = findViewById(R.id.joincancel);

        joincommit.setOnClickListener(this);
        joincancel.setOnClickListener(this);


        DBHelper helper2 = new DBHelper(this);
        SQLiteDatabase db = helper2.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_drive order by _id desc", null);
        while (cursor.moveToNext()) {
            j_rest.setText(cursor.getString(1));
            j_time_m.setText(cursor.getString(18));
            j_time_d.setText(cursor.getString(19));
            j_time_h.setText(cursor.getString(20));
            j_total_num.setText(cursor.getString(6));
            j_num.setText(cursor.getString(7));
            j_per0.setText(cursor.getString(2));
            j_sex0.setText(cursor.getString(3));
            j_old0.setText(cursor.getString(4));
            j_lev0.setText(cursor.getString(5));
            j_per1.setText(cursor.getString(8));
            j_sex1.setText(cursor.getString(9));
            j_old1.setText(cursor.getString(10));
            j_lev1.setText(cursor.getString(11));
            j_per2.setText(cursor.getString(12));
            j_sex2.setText(cursor.getString(13));
            j_old2.setText(cursor.getString(14));
            j_lev2.setText(cursor.getString(15));
            j_detail.setText(cursor.getString(21));
        }
        db.close();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.joingroup:
                Intent i10 = new Intent(this, MainActivity.class);
                startActivity(i10);
            case R.id.joincancel:
                Intent i11 = new Intent(this, MainActivity.class);
                startActivity(i11);
        }

    }


}