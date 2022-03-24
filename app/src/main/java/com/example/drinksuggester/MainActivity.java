package com.example.drinksuggester;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.drinksuggester.controller.MainControllerClass;

public class MainActivity extends AppCompatActivity {

    public TextView tvDrinkName;
    public ProgressBar progressBar;
    public Button button;

    MainControllerClass mainControllerClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainControllerClass = new MainControllerClass(this);
        setContentView(R.layout.activity_main);
        tvDrinkName = findViewById(R.id.tv_randomDrink);
        progressBar = findViewById(R.id.progress_bar);
        button = findViewById(R.id.btn_get_drink);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
            mainControllerClass.suggestDrink();
            }
        });
    }
}