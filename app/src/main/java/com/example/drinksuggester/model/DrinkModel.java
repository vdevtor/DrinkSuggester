package com.example.drinksuggester.model;

import android.os.Handler;
import android.os.Looper;

import com.example.drinksuggester.controller.MainControllerClass;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DrinkModel {
    String[] drinkList = {"Sweet Bananas","Lemonade","Vodka,Sparkle Water",
            "Milk Shake", "Gin", "Water","Soda","Tea","Coffee","Beer"};

    private MainControllerClass mainControllerClass;

    public DrinkModel(MainControllerClass mainControllerClass){
        this.mainControllerClass = mainControllerClass;
    }
    public void suggestDrink(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        final String[] drinkName = {""};

        executor.execute(new Runnable() {
            @Override
            public void run() {
                //background work here
                try{

                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                drinkName[0] = drinkList[new Random().nextInt(drinkList.length)];

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mainControllerClass.onDrinkSuggested(drinkName[0]);
                    }
                });
            }
        });
    }
}
