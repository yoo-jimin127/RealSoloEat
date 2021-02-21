package com.example.realsoloeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.realsoloeat.DBHelper;
import com.example.soloeat.R;

public class ClusterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText inputUserNameView;
    EditText inputSexView;
    EditText inputAgeView;
    EditText inputLevView;
    EditText restNameView;
    EditText monthView;
    EditText dayView;
    EditText hourView;
    EditText peopleView;
    EditText detailView;
    Button commitBtn;
    Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("모집하기");
        setContentView(R.layout.activity_cluster);

        inputUserNameView = findViewById(R.id.inputusername);
        inputSexView = findViewById(R.id.inputsex);
        inputAgeView = findViewById(R.id.inputage);
        inputLevView = findViewById(R.id.inputlev);

        restNameView = findViewById(R.id.new_rest);
        monthView = findViewById(R.id.month);
        dayView = findViewById(R.id.day);
        hourView = findViewById(R.id.hour);
        peopleView = findViewById(R.id.manypeople);
        detailView = findViewById(R.id.detailex);

        commitBtn = findViewById(R.id.commit);
        cancelBtn = findViewById(R.id.cancel);

        commitBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == commitBtn){
            String user_name = inputUserNameView.getText().toString();
            String sex = inputSexView.getText().toString();
            String age = inputAgeView.getText().toString();
            String lev = inputLevView.getText().toString();
            String rest_name = restNameView.getText().toString();
            String month = monthView.getText().toString();
            String day = dayView.getText().toString();
            String hour = hourView.getText().toString();
            Integer people = Integer.parseInt(peopleView.getText().toString());
            String detail = detailView.getText().toString();

            DBHelper helper1 = new DBHelper(this);
            SQLiteDatabase db = helper1.getWritableDatabase();
            //주소는 모두 상도동이라는 전제 하에 진행.
            db.execSQL("insert into tb_drive (rest_name, person, sex, old, lev, total_num, num, person1, sex1, old1, lev1, " +
                    "person2, sex2, old2, lev2, address, cate, time_month, time_day, time_hour, detail)" +
                    "values ('" + rest_name + "', '"+ user_name +"', '"+sex+"','"+age+"','"+lev+"','"+people+"', 1, null, null, null, null," +
                    "null, null, null, null, '"+"상도동"+"',null, '"+month+"','"+day+"','"+hour+"','"+detail+"';");

            db.close();

            Intent intent00 = new Intent(this, MainActivity.class);
            startActivity(intent00);
        }
        else if (v == cancelBtn){
            Intent intent01 = new Intent(this, MainActivity.class);
            startActivity(intent01);
        }
    }
}