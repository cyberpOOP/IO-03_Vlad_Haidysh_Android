package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;


public class MainActivity extends AppCompatActivity {

    Storage storage = new Storage();
    InputFragment fragmentInput = new InputFragment();
    ResultFragment fragmentResult = new ResultFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setFragments();
    }

    private void setFragments() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_input, fragmentInput);
        transaction.replace(R.id.frame_result, fragmentResult);
        transaction.commit();
    }

    public void setText(String text){
        storage.saveFile(this, text);
        fragmentResult.setText(text);
    }

    public void openStorage(){
        Intent intent = new Intent(MainActivity.this, TextOutput.class);
        startActivity(intent);
    }
}