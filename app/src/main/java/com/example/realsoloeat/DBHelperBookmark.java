package com.example.user.realsoloeat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//--------------BookmarkActivity 관련 DBHelper 내용입니다.--------------------
public class DBHelperBookmark extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 8;

    public DBHelperBookmark(Context context) {
        super(context, "datadb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableSql = "create table tb_data ("+
                "_id integer primary key autoincrement, " +
                "name not null, " +
                "content)";

        db.execSQL(tableSql);

        db.execSQL("insert into tb_data (name, content) values ('쌀국이','쌀국수 먹을 때 고수 안넣는 메이트')");
        db.execSQL("insert into tb_data (name, content) values ('밥머건닝','닭다리를 싫어해서 닭 날개만 먹는 메이트')");

        String driverTable="create table tb_drive ("+
                "_id integer primary key autoincrement, " +
                "title, " +
                "date, " +
                "type)";

        db.execSQL(driverTable);
        db.execSQL("insert into tb_drive (title, date, type) values ('쌀국이','쌀국수 먹을 때 고수 안넣는 메이트', 'doc')");
        db.execSQL("insert into tb_drive (title, date, type) values ('밥머건닝','닭 날개만 먹는 메이트', 'file')");
        db.execSQL("insert into tb_drive (title, date, type) values ('마라냠냠','마라탕 3단계 먹는 메이트', 'doc')");
        db.execSQL("insert into tb_drive (title, date, type) values ('생고기남','스테이크 레어로 먹는 메이트', 'img')");
        db.execSQL("insert into tb_drive (title, date, type) values ('스트레스팡팡','떡볶이에서 어묵만 먹는 메이트', 'file')");
        db.execSQL("insert into tb_drive (title, date, type) values ('파슷하','크림파스타 나눠먹을 수 있는 메이트', 'doc')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == DATABASE_VERSION) {
            db.execSQL("drop table tb_data");
            db.execSQL("drop table tb_drive");
            onCreate(db);
        }
    }
}
//--------------BookmarkActivity 관련 DBHelper 내용입니다.--------------------