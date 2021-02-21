package com.example.realsoloeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.soloeat.R;

import java.util.ArrayList;

public class listActivity4 extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("시간별");
        setContentView(R.layout.activity_list4);

        ListView listView = findViewById(R.id.listView4);
        Intent intent = getIntent();
        String timer1 = intent.getExtras().getString("timer1");
        String timer2 = intent.getExtras().getString("timer2");
        String timer3 = intent.getExtras().getString("timer3");

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_drive where time_month LIKE '12' and (time_day LIKE '3' and time_hour LIKE '12')", null);

        ArrayList<DriveVO> data = new ArrayList<>();
        while(cursor.moveToNext()) {
            DriveVO vo = new DriveVO();
            vo.rest_name = cursor.getString(1);
            data.add(vo);
        }
        db.close();

        //DriveAdapter adapter = new DriveAdapter(this, R.layout.custom_item, data, (DriveAdapter.ListBtnClickListener) this);
        DriveAdapter adapter = new DriveAdapter(this, R.layout.custom_item, data);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

        //Log.d("MainActivity OnClick 테스트", "text: vid:" + v.getId() + "tag :" + v.getTag());

        switch(v.getId()) {
            case R.id.custom_item_cluster :
                Intent i = new Intent(this, ClusterActivity.class);
                //i.putExtra("rest",rest);
                startActivity(i);
                break;
            case R.id.custom_item_join :
                Intent i1 = new Intent(this, JoinActivity.class);
                //i.putExtra("rest",rest);
                startActivity(i1);
        }
    }

}