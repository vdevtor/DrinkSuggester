package com.example.drinksuggester.controller;

import android.view.View;

import com.example.drinksuggester.MainActivity;
import com.example.drinksuggester.model.DrinkModel;

public class MainControllerClass {
    private DrinkModel drinkModel;
    private MainActivity mainActivity;
    public MainControllerClass(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        drinkModel = new DrinkModel(this);
    }

    public void suggestDrink(){
        mainActivity.progressBar.setVisibility(View.VISIBLE);
        drinkModel.suggestDrink();
    }

    public void onDrinkSuggested(String drinkName){
        this.mainActivity.tvDrinkName.setText(drinkName);
        this.mainActivity.progressBar.setVisibility(View.INVISIBLE);
    }
}
