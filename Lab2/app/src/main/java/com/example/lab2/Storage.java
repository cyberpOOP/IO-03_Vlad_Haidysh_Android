package com.example.lab2;

import android.content.Context;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Storage {


    String filename = "Flowers_Order.txt";

    public void saveFile(Context context, String text) {
        File path = context.getExternalFilesDir(null);
        try {
            FileOutputStream fos = new FileOutputStream(new File(path, filename));
            fos.write(text.getBytes());
            fos.close();
            Toast.makeText(context, "File saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Failure file saving", Toast.LENGTH_SHORT).show();
        }
    }

    public String loadFile(Context context) {
        File path = context.getExternalFilesDir(null);
        File file = new File(path, filename);

        byte[] content = new byte[(int) file.length()];
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

    public boolean checkStorage(Context context){
        File path = context.getExternalFilesDir(null);
        File file = new File(path, filename);
        if(file.exists())
            return true;
         return false;
    }
}


