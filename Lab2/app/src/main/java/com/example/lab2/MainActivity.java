package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;


public class MainActivity extends AppCompatActivity {

    private RadioGroup ColorGroup;
    private RadioGroup BunchGroup;
    private RadioButton ColorButton;
    private RadioButton BunchButton;
    private TextView TextRes;
    private EditText Text;
    MainFragment Fragment = new MainFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ColorGroup = findViewById(R.id.RadioColor);
        BunchGroup = findViewById(R.id.RadioSize);

        Button ButtonOK = findViewById(R.id.button);
        Text = findViewById(R.id.TextField);

        SetFragment();


        ButtonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] mass = new int[3];
                boolean let = true;
                mass[0] = Text.getText().length();
                mass[1] = ColorGroup.getCheckedRadioButtonId();
                mass[2] = (int)BunchGroup.getCheckedRadioButtonId()-1;

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

                    /*TextRes.setText("Your Order is:\n"+order+"\n"+
                            "Your Comment:\n"+Text.getText()+"\nPrice: "+price);*/
                    Fragment.UpdateText("Your Order is:\n"+order+"\n"+
                            "Your Comment:\n"+Text.getText()+"\nPrice: "+price);
                    SetFragment();

                }

            }
        });
    }

    private void SetFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, Fragment);
        transaction.commit();
    }
}