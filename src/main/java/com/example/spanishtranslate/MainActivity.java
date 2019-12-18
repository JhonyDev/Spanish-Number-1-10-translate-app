package com.example.spanishtranslate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private TextView eng_numbers;
    private TextView spn_numbers;
    private BottomNavigationView bottomNavigationView;
    private SoundPool sp;
    private int sound1;
    private int sound2;
    private int sound3;
    private int sound4;
    private int sound5;
    private int sound6;
    private int sound7;
    private int sound8;
    private int sound9;
    private int sound10;

    int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        sp = new SoundPool.Builder()
                .setMaxStreams(6)
                .setAudioAttributes(audioAttributes)
                .build();

        sound1 = sp.load(getApplicationContext(),R.raw.spn1,1);
        sound2 = sp.load(getApplicationContext(),R.raw.spn2,1);
        sound3 = sp.load(getApplicationContext(),R.raw.spn3,1);
        sound4 = sp.load(getApplicationContext(),R.raw.spn4,1);
        sound5 = sp.load(getApplicationContext(),R.raw.spn5,1);
        sound6 = sp.load(getApplicationContext(),R.raw.spn6,1);
        sound7 = sp.load(getApplicationContext(),R.raw.spn7,1);
        sound8 = sp.load(getApplicationContext(),R.raw.spn8,1);
        sound9 = sp.load(getApplicationContext(),R.raw.spn9,1);
        sound10 = sp.load(getApplicationContext(),R.raw.spn10,1);

        eng_numbers=findViewById(R.id.eng_nums);
        spn_numbers=findViewById(R.id.spn_nums);
        bottomNavigationView=findViewById(R.id.bottom_nav_bar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.prev:
                        num--;
                        if(num<1){
                            num=10;
                        }
                        print_numbers(num);
                        break;
                    case R.id.next:
                        num++;
                        if(num>10){
                            num=1;
                        }
                        print_numbers(num);
                        break;
                    case R.id.speak:
                        speaknum(num);
                        break;
                }
                return false;
            }
        });
    }
    private void print_numbers(int num) {
        switch (num) {
            case 1:
                eng_numbers.setText("ONE (1)");
                spn_numbers.setText("UNO");
                break;
            case 2:
                eng_numbers.setText("TWO (2)");
                spn_numbers.setText("DOS");
                break;
            case 3:
                eng_numbers.setText("THREE (3)");
                spn_numbers.setText("TRES");
                break;
            case 4:
                eng_numbers.setText("FOUR (4)");
                spn_numbers.setText("CUATRO");
                break;
            case 5:
                eng_numbers.setText("FIVE (5)");
                spn_numbers.setText("CINCO");
                break;
            case 6:
                eng_numbers.setText("SIX (6)");
                spn_numbers.setText("SEIS");
                break;
            case 7:
                eng_numbers.setText("SEVEN (7)");
                spn_numbers.setText("SIETE");
                break;
            case 8:
                eng_numbers.setText("EIGHT (8)");
                spn_numbers.setText("OCHO");
                break;
            case 9:
                eng_numbers.setText("NINE (9)");
                spn_numbers.setText("NUEVE");
                break;
            case 10:
                eng_numbers.setText("TEN (10)");
                spn_numbers.setText("DIEZ");
                break;
        }
    }
    private void speaknum(int num) {
        switch (num) {
            case 1:
                sp.play(sound1,1.0f,1.0f,0,0,1f);
                break;
            case 2:
                sp.play(sound2,1.0f,1.0f,0,0,1f);
                break;
            case 3:
                sp.play(sound3,1.0f,1.0f,0,0,1f);
                break;
            case 4:
                sp.play(sound4,1.0f,1.0f,0,0,1f);
                break;
            case 5:
                sp.play(sound5,1.0f,1.0f,0,0,1f);
                break;
            case 6:
                sp.play(sound6,1.0f,1.0f,0,0,1f);
                break;
            case 7:
                sp.play(sound7,1.0f,1.0f,0,0,1f);
                break;
            case 8:
                sp.play(sound8,1.0f,1.0f,0,0,1f);
                break;
            case 9:
                sp.play(sound9,1.0f,1.0f,0,0,1f);
                break;
            case 10:
                sp.play(sound10,1.0f,1.0f,0,0,1f);
                break;
        }
    }
}
