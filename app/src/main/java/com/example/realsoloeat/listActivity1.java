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

public class listActivity1 extends AppCompatActivity implements View.OnClickListener{
    //String rest = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("지역별");
        setContentView(R.layout.activity_list1);

        ListView listView = findViewById(R.id.listView1);
        Intent intent = getIntent();
        String loc1 = intent.getExtras().getString("loc1");
        String loc2 = intent.getExtras().getString("loc2");
        String loc3 = intent.getExtras().getString("loc3");

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_drive where address LIKE '%상도동%'", null);

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

/*
    public void onListBtnClick(int position, int resourceid){
        DriveVO selected = (DriveVO) kidsList.get(position);

        switch(resourceid){
            case R.id.custom_item_cluster :
                Intent intent = new Intent(this, ClusterActivity.class);
                startActivity(intent);
            case R.id.custom_item_join :
                Intent intent1 = new Intent(this, JoinActivity.class);
                startActivity(intent1);
        }
    }
*/
    /*
    joinButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(this, JoinActivity.class);
            startActivity(intent);
        }
    });
     */
}