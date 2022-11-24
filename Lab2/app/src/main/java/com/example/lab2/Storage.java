package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Storage extends AppCompatActivity {

    File path;
    String filename;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        path = getExternalFilesDir(null);
        filename = "Flowers_Order.txt";
        text = findViewById(R.id.textView2);
        /*File path = getExternalFilesDir(null);
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        Toast.makeText(this, path.toString()+"/", Toast.LENGTH_LONG).show();
        Uri uri = Uri.parse(path.toString());
        intent.setDataAndType(uri, "");
        startActivity(Intent.createChooser(intent, "Open folder"));*/

        text.setText(loadFile());
    }

    public void saveFile(Context context, File path, String filename, String text) {
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

    public String loadFile() {
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
}