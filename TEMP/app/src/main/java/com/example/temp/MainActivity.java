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

    RadioGroup ColorGroup;
    RadioGroup BunchGroup;
    RadioButton ColorButton;
    RadioButton BunchButton;
    TextView TextRes;
    EditText Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ColorGroup = findViewById(R.id.RadioColor);
        BunchGroup = findViewById(R.id.RadioSize);

        Button ButtonOK = findViewById(R.id.button);
        TextRes = findViewById(R.id.textView);
        Text = findViewById(R.id.TextField);

        ButtonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mass[] = new int[3];
                boolean let = true;
                mass[0] = Text.getText().length();
                mass[1] = ColorGroup.getCheckedRadioButtonId();
                mass[2] = (int)BunchGroup.getCheckedRadioButtonId()-1;


                //TextRes.setText(mass[0]+" "+mass[1]+" "+mass[2]);

                for(int i : mass)
                    switch (i){
                        case 0:
                            Toast.makeText(getApplicationContext(), "Comment is empty",
                                    Toast.LENGTH_SHORT).show();
                            TextRes.setText(R.string.TextView);
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
                    ColorButton = findViewById(ColorGroup.getCheckedRadioButtonId());
                    BunchButton = findViewById(BunchGroup.getCheckedRadioButtonId());
                    int PriceId = BunchGroup.getCheckedRadioButtonId();
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
                    order = BunchButton.getText().toString()+" of " +
                            ColorButton.getText().toString()+" roses.";
                    TextRes.setText("Your Order is:\n"+order+"\n"+
                            "Your Comment:\n"+Text.getText()+"\nPrice: "+price);
                    //TextRes.setText(""+BunchGroup.getCheckedRadioButtonId());
                }

            }
        });
    }
}