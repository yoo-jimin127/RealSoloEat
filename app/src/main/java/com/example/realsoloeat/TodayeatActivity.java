package com.example.realsoloeat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.soloeat.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class TodayeatActivity extends AppCompatActivity {

    ImageView foodImg;
    TextView foodName;
    Button next;
    ArrayList<Food> imgList;
    public class Food {

        private String foodName;
        private int foodImg;

        public Food(String foodName, int foodImg) {
            this.foodImg = foodImg;
            this.foodName = foodName;
        }

        public String getFoodName() {
            return foodName;
        }

        public void setFoodName(String foodName) {
            this.foodName = foodName;
        }

        public int getFoodImg() {
            return foodImg;
        }

        public void setFoodImg(int foodImg) {
            this.foodImg = foodImg;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todayeat);

        foodImg = findViewById(R.id.foodimage);
        foodName = findViewById(R.id.foodname);

        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Collections.shuffle(imgList);

                String tempfoodName = imgList.get(0).getFoodName();
                int imgSelected = (int)imgList.get(0).getFoodImg();

                foodName.setText(tempfoodName);
                foodImg.setImageResource(imgSelected);
            }
        });

        imgList = new ArrayList();
        Food food1 = new Food("돈까스", R.drawable.donkaka);
        Food food2 = new Food("초밥", R.drawable.sushi);
        Food food3 = new Food("마라탕", R.drawable.mara);
        Food food4 = new Food("삼겹살", R.drawable.pig);

        imgList.add(food1);
        imgList.add(food2);
        imgList.add(food3);
        imgList.add(food4);

        Collections.shuffle(imgList);

        String tempfoodName = imgList.get(0).getFoodName();
        int imgSelected = (int)imgList.get(0).getFoodImg();

        foodName.setText(tempfoodName);
        foodImg.setImageResource(imgSelected);


    }
}