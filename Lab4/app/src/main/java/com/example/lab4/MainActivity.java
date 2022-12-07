package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button video = findViewById(R.id.video);
        Button audio = findViewById(R.id.audio);

        Video videoFragment = new Video();
        Audio audioFragment = new Audio();

        video.setOnClickListener(view -> setFragment(videoFragment));
        audio.setOnClickListener(view -> setFragment(audioFragment));
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.commit();
    }
}