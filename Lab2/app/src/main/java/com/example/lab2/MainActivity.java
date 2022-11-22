package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    Storage storage = new Storage();
    InputFragment fragmentInput = new InputFragment();
    ResultFragment fragmentResult = new ResultFragment();

    File index;
    File path;

    String filename, fileIndex = "index.txt", indexNumber;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        path = getApplicationContext().getFilesDir();
        index = new File(path, fileIndex);

        if(index.exists()){
            indexNumber = storage.loadFile(MainActivity.this, path, fileIndex);
            i = Integer.parseInt(indexNumber);
        }

       else
            storage.saveFile(MainActivity.this, path, fileIndex,"0", false);

        setFragments();
    }

    @Override
    protected  void onDestroy() {
        super.onDestroy();
        storage.saveFile(MainActivity.this, path, fileIndex, Integer.toString(i), false);
    }

    private void setFragments() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_input, fragmentInput);
        transaction.replace(R.id.frame_result, fragmentResult);
        transaction.commit();
    }

    public void setText(String text){
        filename = "Flowers_Order_"+ i + ".txt";
        i++;
        storage.saveFile(MainActivity.this,path,  filename, text, true);
        fragmentResult.setText(text);

    }


}