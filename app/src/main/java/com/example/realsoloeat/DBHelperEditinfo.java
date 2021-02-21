package com.example.realsoloeat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperEditinfo extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public DBHelperEditinfo(Context context) {
        super(context, "memodb", null, DATABASE_VERSION);
    }

    //앱 설치 이후 SQLiteOpenHelper가 최초로 이용되는 순간 한 번 호출됨, 테이블 생성 코드 작성
    @Override
    public void onCreate(SQLiteDatabase db) {
        String memoSQL = "create table tb_memo (" +
                "_id integer primary key autoincrement, " +
                "title not null, " + "content not null, " + "name not null, " +
                "age)";
        db.execSQL(memoSQL);
    }

    //SQLiteOpenHelper 클래스의 생성자에 전달되는 데이터베이스 버전 정보 변경 시마다 호출
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == DATABASE_VERSION) {
            db.execSQL("drop table tb_memo");
            onCreate(db);
        }
    }
}