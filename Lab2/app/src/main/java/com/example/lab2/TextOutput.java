package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextOutput extends AppCompatActivity {

    TextView text;
    Storage storage = new Storage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        text = findViewById(R.id.textView2);
        if (storage.checkStorage(this)) {
            text.setText(storage.loadFile(this));
        } else {
            text.setText(R.string.empty);
        }

    }
}