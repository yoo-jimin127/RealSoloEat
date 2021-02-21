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

public class listActivity3 extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("인원별");
        setContentView(R.layout.activity_list3);
        ListView listView = findViewById(R.id.listView3);
        Intent intent = new Intent(this.getIntent());
        //String many1 = intent.getStringExtra("many1");
        String many1 = intent.getExtras().getString("many1","3");
        Integer peo1 = Integer.parseInt(many1);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_drive where total_num LIKE 3", null);

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