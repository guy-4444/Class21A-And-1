package com.guy.chickeninvaders.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.guy.chickeninvaders.Food;
import com.guy.chickeninvaders.R;

import java.util.ArrayList;

public class Activity_Panel extends AppCompatActivity {

    private ImageView panel_IMG_food;
    private ImageView panel_IMG_heart1;
    private ImageView panel_IMG_heart2;
    private ImageView panel_IMG_heart3;
    private TextView panel_LBL_score;
    private Button panel_BTN_yes;
    private Button panel_BTN_no;

    private ArrayList<Food> foods;
    private int index = 0;
    private int score = 0;
    private int lives = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        findViews();

        foods = new ArrayList<>();

        foods.add(new Food().setRes(R.drawable.img_fried_egg).setChicken(true));
        foods.add(new Food().setRes(R.drawable.img_burger).setChicken(false));
        foods.add(new Food().setRes(R.drawable.img_french_fries).setChicken(false));
        foods.add(new Food().setRes(R.drawable.img_fried_chicken).setChicken(true));
        foods.add(new Food().setRes(R.drawable.img_hot_dog).setChicken(false));
        foods.add(new Food().setRes(R.drawable.img_pizza).setChicken(false));


        panel_IMG_food.setImageResource(foods.get(index).getRes());


        panel_BTN_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(true);
            }
        });

        panel_BTN_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(false);
            }
        });


    }

    private void next(boolean ans) {
        if (foods.get(index).isChicken() == ans) {
            score += 100;
            Toast.makeText(this, "Good", Toast.LENGTH_SHORT).show();
        } else {
            lives--;
            updateLivesViews();
            score -= 50;
            Toast.makeText(this, "Bla Bla", Toast.LENGTH_SHORT).show();
        }
        panel_LBL_score.setText("" + score);

        index++;
        if (index >= foods.size()) {
            index = 0;
        }
        panel_IMG_food.setImageResource(foods.get(index).getRes());

        if (lives == 0) {
            finish();
        }
    }

    private void updateLivesViews() {
        if (lives >= 3) {
            return;
        } else if (lives == 2) {
            panel_IMG_heart3.setVisibility(View.INVISIBLE);
        } else if (lives == 1) {
            panel_IMG_heart2.setVisibility(View.INVISIBLE);
        } else if (lives == 0) {
            panel_IMG_heart1.setVisibility(View.INVISIBLE);
        }
    }


    private void findViews() {
        panel_IMG_food = findViewById(R.id.panel_IMG_food);
        panel_IMG_heart1 = findViewById(R.id.panel_IMG_heart1);
        panel_IMG_heart2 = findViewById(R.id.panel_IMG_heart2);
        panel_IMG_heart3 = findViewById(R.id.panel_IMG_heart3);
        panel_LBL_score = findViewById(R.id.panel_LBL_score);
        panel_BTN_yes = findViewById(R.id.panel_BTN_yes);
        panel_BTN_no = findViewById(R.id.panel_BTN_no);
    }
}
