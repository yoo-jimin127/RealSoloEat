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

public class SpinnerActivity3 extends AppCompatActivity {

    ArrayAdapter<CharSequence> adpeo; //어댑터를 선언했습니다.
    String choice_num = "";

    //검색시 선택된 매세지를 띄우기 위한 선언하였습니다. 그냥 선언안하고 인자로 넘기셔도 됩니다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner3);

        setTitle("인원별");
        final Spinner spin20 = (Spinner) findViewById(R.id.spinner20);
        final Button btn_refresh20 = (Button) findViewById(R.id.result20);
//xml과 class에 변수들을 연결해줍니다. final를 사용한 이유는 spin2가 함수안에서 사용되기 때문에 코딩전체로 선언한 것입니다.
        adpeo = ArrayAdapter.createFromResource(this, R.array.how_many, android.R.layout.simple_spinner_dropdown_item);
//처번째 어댑터에 값을 넣습니다. this=는 현재class를 의미합니다. R.array.spinner_do는 이곳에 도시를 다 쓸 경우 코딩이 길어지기 때문에 value->string.xml에 따로 String값들을 선언해두었습니다.
//R.layout.simple_~~~는 안드로이드에서 기본제공하는 spinner 모양입니다. 다른것도 있는데 비슷합니다.
        adpeo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//이부분이 정확히 말로 설명을 못하겠습니다. 아무튼 필요합니다. 헤헤 고수분들 도와주세요.
        spin20.setAdapter(adpeo);
//어댑터에 값들을 spinner에 넣습니다. 여기까지 하시면 첫번째 spinner에 값들이 들어갈 것입니다.
        spin20.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //첫번째 spinner 클릭시 이벤트 발생입니다. setO 정도까지 치시면 자동완성됩니다. 뒤에도 마찬가지입니다.
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                choice_num = adpeo.getItem(i).toString();
//선택된 값을 choice_num에 넣습니다.
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btn_refresh20.setOnClickListener(new View.OnClickListener() {
            //버튼 클릭시 이벤트입니다.
            @Override
            public void onClick(View view) {
                Toast.makeText(SpinnerActivity3.this, choice_num + "명", Toast.LENGTH_SHORT).show();
                //선택된 도 와 시를 Toast로 화면에 보여줍니다.
                Intent intent = new Intent(getApplicationContext(), listActivity3.class);
                intent.putExtra("many1", choice_num);

                startActivity(intent);
                finish();
            }
        });
    }
}