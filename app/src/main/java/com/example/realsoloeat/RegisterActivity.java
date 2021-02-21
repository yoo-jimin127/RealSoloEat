package com.example.realsoloeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.soloeat.R;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    EditText idView;
    EditText passView;
    EditText nameView;
    EditText ageView;
    Button addBtn;
    Button move_login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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
//                Intent intent2 = new Intent(RegisterActivity.this, LoginActivity.class);
//                startActivity(intent2);
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        String title = idView.getText().toString();
        String content = passView.getText().toString();
        String name = nameView.getText().toString();
        String age = ageView.getText().toString();

        DBHelperRegister helper = new DBHelperRegister(this);
        SQLiteDatabase db = helper.getWritableDatabase(); //데이터 베이스 여는 작업
        db.execSQL("insert into tb_memo (title, content, name, age) values (?, ?, ?, ?)", new String[]{title, content, name, age});
        db.close();

//    Intent intent = new Intent(this, ReadDbActivityRegister.class);
//    startActivity(intent);
//
//    Intent intent1 = new Intent();
//        ComponentName componentName = new ComponentName("com.example.realsoloeat", "com.example.realsoloeat.LoginActivity");
//
//        intent1.setComponent(componentName);
//        startActivity(intent1);
    }
}

//public class RegisterActivity extends AppCompatActivity {
//
//    private EditText et_id, et_pass, et_name, et_age;
//    private Button btn_register;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);//액티비티 시작 시 처음으로 실행되는 생명주기
//        setContentView(R.layout.activity_register);
//
//        //아이디 값 찾아주기
//        et_id = findViewById(R.id.et_id);
//        et_pass = findViewById(R.id.et_pass);
//        et_name = findViewById(R.id.et_name);
//        et_age = findViewById(R.id.et_age);
//
//        //회원가입 버튼 클릭 시 수행
//        btn_register = findViewById(R.id.btn_register);
//        btn_register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // EditText에 현재 입력 되어있는 값을 get 해오는 과정
//                String userID = et_id.getText().toString();
//                String userPass = et_pass.getText().toString();
//                String userName = et_name.getText().toString();
//                int userAge = Integer.parseInt(et_age.getText().toString());
//
//                Response.Listener<String> responseListener = new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            boolean success = jsonObject.getBoolean("success");
//
//                            //회원가입이 성공적으로 완료된 경우
//                            if (success) {
//                                Toast.makeText(getApplicationContext(), "회원 가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                                startActivity(intent);
//                            }
//
//                            //회원가입에 실패한 경우
//                            else {
//                                Toast.makeText(getApplicationContext(), "회원 가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
//                                return;
//                            }
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                };
//
//                //서버로 Volley를 이용해 요청함.
//                RegisterRequest registerRequest = new RegisterRequest(userID, userPass, userName, userAge, responseListener);
//                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
//                queue.add(registerRequest);
//
//
//            }
//        });
//
//    }
//}