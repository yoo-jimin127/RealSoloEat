package com.example.realsoloeat;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.soloeat.R;

public class SpinnerActivity1 extends AppCompatActivity {

    ArrayAdapter<CharSequence> adspin1, adspin2, adspin3; //어댑터를 선언했습니다. adspint1(서울,인천..) adspin2(강남구,강서구..)
    String choice_do = "";
    String choice_se = "";
    String choice_dong = "";

    //검색시 선택된 매세지를 띄우기 위한 선언하였습니다. 그냥 선언안하고 인자로 넘기셔도 됩니다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner1);
        setTitle("지역별");
        final Spinner spin1 = (Spinner) findViewById(R.id.spinner);
        final Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
        final Spinner spin3 = (Spinner) findViewById(R.id.spinner3);
        final Button btn_refresh = (Button) findViewById(R.id.result);
//xml과 class에 변수들을 연결해줍니다. final를 사용한 이유는 spin2가 함수안에서 사용되기 때문에 코딩전체로 선언한 것입니다.
        adspin1 = ArrayAdapter.createFromResource(this, R.array.location1, android.R.layout.simple_spinner_dropdown_item);
//처번째 어댑터에 값을 넣습니다. this=는 현재class를 의미합니다. R.array.spinner_do는 이곳에 도시를 다 쓸 경우 코딩이 길어지기 때문에 value->string.xml에 따로 String값들을 선언해두었습니다.
//R.layout.simple_~~~는 안드로이드에서 기본제공하는 spinner 모양입니다. 다른것도 있는데 비슷합니다.
        adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//이부분이 정확히 말로 설명을 못하겠습니다. 아무튼 필요합니다. 헤헤 고수분들 도와주세요.
        spin1.setAdapter(adspin1);
//어댑터에 값들을 spinner에 넣습니다. 여기까지 하시면 첫번째 spinner에 값들이 들어갈 것입니다.
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //첫번째 spinner 클릭시 이벤트 발생입니다. setO 정도까지 치시면 자동완성됩니다. 뒤에도 마찬가지입니다.
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//제대로 자동완성하셨다면 이부분이 자동으로 만들어 질 것입니다. int i는 포지션이라 하여 제가 spinner에 몇번째걸 선택했는지 값이 들어갑니다. 필요하겠죠? ㅎㅎ
                if (adspin1.getItem(i).equals("서울특별시")) {
//spinner에 값을 가져와서 i 보이시나요 제가 클릭 한것이 서울인지 확인합니다.
                    choice_do = "서울특별시";//버튼 클릭시 출력을 위해 값을 넣었습니다.
                    adspin2 = ArrayAdapter.createFromResource(SpinnerActivity1.this, R.array.location2, android.R.layout.simple_spinner_dropdown_item);
//서울일 경우에 두번째 spinner에 값을 넣습니다.
//그냥 this가 아닌 Main~~~인 이유는 그냥 this는 메인엑티비티인 경우만 가능합니다.
//지금과 같이 다른 함수안이나 다른 클래스에서는 꼭 자신의 것을 넣어주어야 합니다.
//혹시나 다른 class -> Public View밑에서 작업하시는 분은 view명.getContext()로 해주셔야 합니다.
//예로 View rootView =~~ 선언하신 경우에는 rootView.getContext()써주셔야합니다. this가 아니라요.
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
//두번째 어댑터값을 두번째 spinner에 넣었습니다.
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        //저희는 두번째 선택된 값도 필요하니 이안에 두번째 spinner 선택 이벤트를 정의합니다.
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (adspin2.getItem(i).equals("동작구")) {
//spinner에 값을 가져와서 i 보이시나요 제가 클릭 한것이 서울인지 확인합니다.
                                choice_do = "동작구";//버튼 클릭시 출력을 위해 값을 넣었습니다.
                                adspin3 = ArrayAdapter.createFromResource(SpinnerActivity1.this, R.array.location3, android.R.layout.simple_spinner_dropdown_item);
//서울일 경우에 두번째 spinner에 값을 넣습니다.
//그냥 this가 아닌 Main~~~인 이유는 그냥 this는 메인엑티비티인 경우만 가능합니다.
//지금과 같이 다른 함수안이나 다른 클래스에서는 꼭 자신의 것을 넣어주어야 합니다.
//혹시나 다른 class -> Public View밑에서 작업하시는 분은 view명.getContext()로 해주셔야 합니다.
//예로 View rootView =~~ 선언하신 경우에는 rootView.getContext()써주셔야합니다. this가 아니라요.
                                adspin3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                spin3.setAdapter(adspin3);
//두번째 어댑터값을 두번째 spinner에 넣었습니다.
                                spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    //저희는 두번째 선택된 값도 필요하니 이안에 두번째 spinner 선택 이벤트를 정의합니다.
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        choice_se = adspin3.getItem(i).toString();
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
        btn_refresh.setOnClickListener(new View.OnClickListener() {
            //버튼 클릭시 이벤트입니다.
            @Override
            public void onClick(View view) {
                Toast.makeText(SpinnerActivity1.this, choice_do + " " + choice_se + " " + choice_dong, Toast.LENGTH_SHORT).show();
                //선택된 도 와 시를 Toast로 화면에 보여줍니다.
                Intent intent = new Intent(getApplicationContext(), listActivity1.class);

                intent.putExtra("loc1", choice_do);
                intent.putExtra("loc2", choice_se);
                intent.putExtra("loc3", choice_dong);

                startActivity(intent);

            }
        });
    }
}
