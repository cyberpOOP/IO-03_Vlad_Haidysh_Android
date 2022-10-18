package com.example.temp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private RadioGroup colorGroup;
    private RadioGroup bunchGroup;
    private RadioButton colorButton;
    private RadioButton bunchButton;
    private TextView textRes;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorGroup = findViewById(R.id.RadioColor);
        bunchGroup = findViewById(R.id.RadioSize);

        Button buttonOK = findViewById(R.id.button);
        textRes = findViewById(R.id.textView);
        text = findViewById(R.id.TextField);

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mass[] = new int[3];
                boolean let = true;
                mass[0] = text.getText().length();
                mass[1] = colorGroup.getCheckedRadioButtonId();
                mass[2] = (int) bunchGroup.getCheckedRadioButtonId()-1;


                //TextRes.setText(mass[0]+" "+mass[1]+" "+mass[2]);

                for(int i : mass)
                    switch (i){
                        case 0:
                            Toast.makeText(getApplicationContext(), "Comment is empty",
                                    Toast.LENGTH_SHORT).show();
                            textRes.setText(R.string.TextView);
                            let = false;
                            break;
                        case -1:
                            Toast.makeText(getApplicationContext(), "Choose flowers color",
                                    Toast.LENGTH_SHORT).show();
                            let = false;
                            break;
                        case -2:
                            Toast.makeText(getApplicationContext(), "Choose bunch size",
                                    Toast.LENGTH_SHORT).show();
                            let = false;
                            break;
                    }

                if(let){
                    colorButton = findViewById(colorGroup.getCheckedRadioButtonId());
                    bunchButton = findViewById(bunchGroup.getCheckedRadioButtonId());
                    int PriceId = bunchGroup.getCheckedRadioButtonId();
                    String price ="";
                    String order;
                    switch(PriceId){
                        case 2131230733:
                            price = "20$";
                            break;
                        case 2131230730:
                            price = "30$";
                            break;
                        case 2131230727:
                            price = "45$";
                            break;
                        case -1:
                            price ="10$";
                            break;
                    }
                    order = bunchButton.getText().toString()+" of " +
                            colorButton.getText().toString()+" roses.";
                    textRes.setText("Your Order is:\n"+order+"\n"+
                            "Your Comment:\n"+text.getText()+"\nPrice: "+price);
                    //TextRes.setText(""+BunchGroup.getCheckedRadioButtonId());
                }

            }
        });
    }
}