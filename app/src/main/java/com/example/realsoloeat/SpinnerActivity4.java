package com.example.realsoloeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.soloeat.R;

public class SpinnerActivity4 extends AppCompatActivity {

    ArrayAdapter<CharSequence> adtime1, adtime2, adtime3; //어댑터를 선언했습니다.
    String choice_m = "";
    String choice_d= "";
    String choice_h = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("시간별");
        setContentView(R.layout.activity_spinner4);
        final Spinner spin30 = (Spinner) findViewById(R.id.spinner30);
        final Spinner spin31 = (Spinner) findViewById(R.id.spinner31);
        final Spinner spin32 = (Spinner) findViewById(R.id.spinner32);
        final Button btn_refresh30 = (Button) findViewById(R.id.result30);

        adtime1 = ArrayAdapter.createFromResource(this, R.array.time1, android.R.layout.simple_spinner_dropdown_item);
        adtime1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin30.setAdapter(adtime1);
//어댑터에 값들을 spinner에 넣습니다. 여기까지 하시면 첫번째 spinner에 값들이 들어갈 것입니다.
        spin30.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adtime1.getItem(i).equals("12")) {
                    adtime2 = ArrayAdapter.createFromResource(SpinnerActivity4.this, R.array.time2, android.R.layout.simple_spinner_dropdown_item);
                    adtime2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin31.setAdapter(adtime2);
//두번째 어댑터값을 두번째 spinner에 넣었습니다.
                    spin31.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        //저희는 두번째 선택된 값도 필요하니 이안에 두번째 spinner 선택 이벤트를 정의합니다.
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (adtime2.getItem(i).equals("3")) {
//spinner에 값을 가져와서 i 보이시나요 제가 클릭 한것이 서울인지 확인합니다.
                                choice_d = "3";//버튼 클릭시 출력을 위해 값을 넣었습니다.
                                adtime3 = ArrayAdapter.createFromResource(SpinnerActivity4.this, R.array.time3, android.R.layout.simple_spinner_dropdown_item);
                                adtime3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                spin32.setAdapter(adtime3);
//두번째 어댑터값을 두번째 spinner에 넣었습니다.
                                spin32.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    //저희는 두번째 선택된 값도 필요하니 이안에 두번째 spinner 선택 이벤트를 정의합니다.
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        choice_h = adtime3.getItem(i).toString();
//두번째 선택된 값을 choice_se에 넣습니다.
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {
//아무것도 선택안될시 부분입니다. 자동완성됩니다.
                                    }
                                });
                            }
//두번째 선택된 값을 choice_se에 넣습니다.
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
//아무것도 선택안될시 부분입니다. 자동완성됩니다.
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btn_refresh30.setOnClickListener(new View.OnClickListener() {
            //버튼 클릭시 이벤트입니다.
            @Override
            public void onClick(View view) {
                Toast.makeText(SpinnerActivity4.this, ""+choice_m + "월 " + choice_d + "일 " + choice_h+"시", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), listActivity4.class);

                intent.putExtra("timer1", choice_m);
                intent.putExtra("timer2", choice_d);
                intent.putExtra("timer3", choice_h);

                startActivity(intent);

            }
        });
    }
}