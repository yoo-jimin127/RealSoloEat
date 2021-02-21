package com.example.realsoloeat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 8;

    public DBHelper(Context context) {
        super(context, "datadb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//--------------BookmarkActivity 관련 DBHelper 내용입니다.--------------------
        String tableSql = "create table tb_data ("+
                "_id integer primary key autoincrement, " +
                "name not null, " +
                "content)";

        db.execSQL(tableSql);

        db.execSQL("insert into tb_data (name, content) values ('쌀국이','쌀국수 먹을 때 고수 안넣는 메이트')");
        db.execSQL("insert into tb_data (name, content) values ('밥머건닝','닭다리를 싫어해서 닭 날개만 먹는 메이트')");
/*
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
 */

//--------------리스트 관련 DBHelper 내용입니다.--------------------
        String driverTable= "create table tb_drive ("+
                "_id integer primary key autoincrement, " +
                "rest_name not null, " +
                "person not null, " +
                "sex not null, " +
                "old not null, " +
                "lev not null, " +
                "total_num not null, " +
                "num not null, " + "person1, " + "sex1, " +"old1, " + "lev1, " +
                "person2, " + "sex2, " + "old2, " + "lev2, " + "address, " + "cate, " +
                "time_month, " + "time_day, " + "time_hour, " + "detail)";


        db.execSQL(driverTable);

        db.execSQL("insert into tb_drive (rest_name, person, sex, old, lev, total_num, num, person1, sex1, old1, lev1, person2, sex2, old2, lev2, " +
                "address, cate, time_month, time_day, time_hour, detail) values ('고랭','쌀국이','남','2-','2', 4, 2,'국쌀이','여','2-','3', null, null, null, null," +
                " '서울시 동작구 상도동 507-3', '그외', '12', '3', '15', '쌀국수는 제가 먹겠습니다. 다른 분 혹시 밥 메뉴 드셔주시면 같이 나눠서 먹어요.')");
        db.execSQL("insert into tb_drive (rest_name, person, sex, old, lev, total_num, num, person1, sex1, old1, lev1, person2, sex2, old2, lev2, " +
                "address, cate, time_month, time_day, time_hour, detail) values ('고랭','밥이조아','여','3-', '1', 2, 1, null, null, null, null, null, null, null, null," +
                " '서울시 동작구 상도동 507-3', '그외', '12', '3', '14', '고랭? 안고랭! 고랭 앞에서 2시까지 만나요')");
        db.execSQL("insert into tb_drive (rest_name, person, sex, old, lev, total_num, num, person1, sex1, old1, lev1, person2, sex2, old2, lev2, " +
                "address, cate, time_month, time_day, time_hour, detail) values ('뚝배기 스파게티','파슷하','남','2-','1', 4, 1, null, null, null, null, null, null, null, null," +
                " '서울시 동작구 상도동 508-4', '양식', '12', '4', '18', '도서관 앞에서 만나서 갈 사람 구합니다. 남자만요.')");
        db.execSQL("insert into tb_drive (rest_name, person, sex, old, lev, total_num, num, person1, sex1, old1, lev1, person2, sex2, old2, lev2, " +
                "address, cate, time_month, time_day, time_hour, detail) values ('뚝배기 스파게티','냠냠냠','남','2-', '4', 3, 2, '옴뇸', '남', '2-', '5', null, null, null, null," +
                " '서울시 동작구 상도동 508-4', '양식', '12', '5', '17', '컴퓨터학부 같이 드실 분!')");
        db.execSQL("insert into tb_drive (rest_name, person, sex, old, lev, total_num, num, person1, sex1, old1, lev1, person2, sex2, old2, lev2, " +
                "address, cate, time_month, time_day, time_hour, detail) values ('뚝배기 스파게티','고로롱','여','4-', '1', 2, 1, null, null, null, null, null, null, null, null," +
                " '서울시 동작구 상도동 508-4', '양식', '12', '5', '13', '소웨 2학년입니다. 같이 밥친구 구해요!')");
        db.execSQL("insert into tb_drive (rest_name, person, sex, old, lev, total_num, num, person1, sex1, old1, lev1, person2, sex2, old2, lev2, " +
                "address, cate, time_month, time_day, time_hour, detail) values ('스톤 504','갑부된다','여','2-', '3', 4, 3, '강아지월', '남', '2-', '4', '기린은배신배신', '남', '2-', '5'," +
                " '서울시 동작구 상도동 507-11', '양식', '12', '3', '17', '혼자 먹기는 수치스럽네여 같이먹어여')");
        db.execSQL("insert into tb_drive (rest_name, person, sex, old, lev, total_num, num, person1, sex1, old1, lev1, person2, sex2, old2, lev2, " +
                "address, cate, time_month, time_day, time_hour, detail) values ('스톤 504','밥머건닝','여','3-', '2', 2, 1, null, null, null, null, null, null, null, null," +
                " '서울시 동작구 상도동 507-11', '양식', '12', '4', '18', '피자먹고 싶은데 혼자 먹기는 좀 그래서 모집해요')");
        db.execSQL("insert into tb_drive (rest_name, person, sex, old, lev, total_num, num, person1, sex1, old1, lev1, person2, sex2, old2, lev2, " +
                "address, cate, time_month, time_day, time_hour, detail) values ('스톤 504','피자광','남','2-', '5', 4, 2, '건축학부', '남', '2-', '4', null, null, null, null," +
                " '서울시 동작구 상도동 507-11', '양식', '12', '5', '12', '핸드폰으로 연락주세요 010-1234-5678')");
        db.execSQL("insert into tb_drive (rest_name, person, sex, old, lev, total_num, num, person1, sex1, old1, lev1, person2, sex2, old2, lev2, " +
                "address, cate, time_month, time_day, time_hour, detail) values ('동경야네','일식최고','여','3-', '3', 2, 1, null, null, null, null, null, null, null, null," +
                " '서울시 동작구 상도동 504', '일식', '12', '3', '12', '연어 한 조각 주실 분 구해요')");
        db.execSQL("insert into tb_drive (rest_name, person, sex, old, lev, total_num, num, person1, sex1, old1, lev1, person2, sex2, old2, lev2, " +
                "address, cate, time_month, time_day, time_hour, detail) values ('스시이야기','초밥짱','남','3-', '2', 4, 2, '뜨끈한국물', '여', '2-', '3', null, null, null, null," +
                " '서울시 동작구 상도동 501', '일식', '12', '4', '11', '같이 먹으면서 친해져요. 방학동안 밥 먹을 사람이 없어서 구합니다.')");
        db.execSQL("insert into tb_drive (rest_name, person, sex, old, lev, total_num, num, person1, sex1, old1, lev1, person2, sex2, old2, lev2, " +
                "address, cate, time_month, time_day, time_hour, detail) values ('스시이야기','온천갈래','남','4-', '3', 3, 2, '먹죽한다', '남', '3-', '1', null, null, null, null," +
                " '서울시 동작구 상도동 501', '일식', '12', '3', '12', '오랜만에 스시먹읍시다. 12:10까지 스시이야기 앞에서')");
        db.execSQL("insert into tb_drive (rest_name, person, sex, old, lev, total_num, num, person1, sex1, old1, lev1, person2, sex2, old2, lev2, " +
                "address, cate, time_month, time_day, time_hour, detail) values ('신룽푸마라탕','샹궈먹자','여','2-', '4', 4, 3, '꿔발오우', '여', '2-', '2', '빤을먹어보는', '여', '3-', '1'," +
                " '서울시 동작구 상도동 505-6', '중식', '12', '4', '12', '마라탕에 샹궈, 꿔바로우까지 먹으실 분')");
        db.execSQL("insert into tb_drive (rest_name, person, sex, old, lev, total_num, num, person1, sex1, old1, lev1, person2, sex2, old2, lev2, " +
                "address, cate, time_month, time_day, time_hour, detail) values ('아쯔다무라','아삭','여','3-', '5', 2, 1, null, null, null, null, null, null, null, null," +
                " '서울시 동작구 상도동 494-11', '일식', '12', '4', '17', '아쯔다무라 열리자마자 갈 사람 구합니다')");
        db.execSQL("insert into tb_drive (rest_name, person, sex, old, lev, total_num, num, person1, sex1, old1, lev1, person2, sex2, old2, lev2, " +
                "address, cate, time_month, time_day, time_hour, detail) values ('아쯔다무라','너는돈까스','남','2-', '3', 3, 2, '나는우동', '남', '3-', '1', null, null, null, null," +
                " '서울시 동작구 상도동 494-11', '일식', '12', '5', '18', '시간 지체 없음 딱 6시 30분에 만나실 분')");
        db.execSQL("insert into tb_drive (rest_name, person, sex, old, lev, total_num, num, person1, sex1, old1, lev1, person2, sex2, old2, lev2, " +
                "address, cate, time_month, time_day, time_hour, detail) values ('청년다방','떡볶이가체고지','여','2-', '5', 4, 3, '감튀첵오', '여', '3-', '4', '오징어', '남', '2-', '4'," +
                " '서울시 동작구 상도동 502-5', '분식', '12', '3', '13', '1시 20분까지 오세요 청년다방 앞으로')");
        db.execSQL("insert into tb_drive (rest_name, person, sex, old, lev, total_num, num, person1, sex1, old1, lev1, person2, sex2, old2, lev2, " +
                "address, cate, time_month, time_day, time_hour, detail) values ('청년다방','혼자먹기힘들다','남','2-', '2', 3, 2, '컴공과남', '남', '2-', '3', null, null, null, null," +
                " '서울시 동작구 상도동 502-5', '분식', '12', '4', '14', '식사 같이 하실 분! 청년다방 혼자 먹긴 부담스럽네요')");

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