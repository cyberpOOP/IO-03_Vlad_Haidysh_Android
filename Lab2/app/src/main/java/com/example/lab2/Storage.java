package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Storage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
    }

    public void saveFile(Context context, File path, String filename, String text, boolean let){
        try {
            FileOutputStream fos = new FileOutputStream(new File(path, filename));
            fos.write(text.getBytes());
            fos.close();
            if(let)
                Toast.makeText(context, "File saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Failure file saving", Toast.LENGTH_SHORT).show();
        }
    }

    public String loadFile(Context context, File path, String filename){
        File file = new File(path, filename);

        byte[] content = new byte[(int)file.length()];
        String txt = new String();
        try {
            FileInputStream fis = new FileInputStream(file);
            fis.read(content);
            txt = new String(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return txt;
    }
}