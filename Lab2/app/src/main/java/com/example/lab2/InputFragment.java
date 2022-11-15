package com.example.lab2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class InputFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        EditText text = view.findViewById(R.id.textEdit);
        RadioGroup groupColor = view.findViewById(R.id.radioColor);
        RadioGroup groupBunch = view.findViewById(R.id.radioBunch);
        Button buttonOK = view.findViewById(R.id.button);

        RadioButton[] bunchButtons = new RadioButton[6];
        bunchButtons[0] = view.findViewById(R.id.radioSmall);
        bunchButtons[1] = view.findViewById(R.id.radioMedium);
        bunchButtons[2] = view.findViewById(R.id.radioBig);
        bunchButtons[3] = view.findViewById(R.id.radioRed);
        bunchButtons[4] = view.findViewById(R.id.radioYellow);
        bunchButtons[5] = view.findViewById(R.id.radioBlack);

        StringBuilder finalText = new StringBuilder();

        buttonOK.setOnClickListener(view1 -> {
            int[] arr = new int[3];
            boolean let = true;
            arr[0] = text.getText().length();
            arr[1] = groupColor.getCheckedRadioButtonId();
            arr[2] = groupBunch.getCheckedRadioButtonId();

            for(int i :arr){
                switch (i){
                    case 0:
                        Toast.makeText(getContext(), "Comment is empty",
                                Toast.LENGTH_SHORT).show();
                        let = false;
                        break;

                    case -1:
                        Toast.makeText(getContext(), "Some radiobutton isn't checked",
                                Toast.LENGTH_SHORT).show();
                        let = false;
                        break;
                }
                if(!let) break;
            }

            if(let){
                RadioButton bunch = null;
                RadioButton color = null;
                for(RadioButton i : bunchButtons){
                    if(i.getId() == groupBunch.getCheckedRadioButtonId())
                        bunch = i;
                    if(i.getId() == groupColor.getCheckedRadioButtonId())
                        color = i;
                }
                //fix this somehow
                finalText.append(getResources().getString(R.string.Order));
                assert bunch != null;
                finalText.append(bunch.getText().toString());
                finalText.append(" of ");
                assert color != null;
                finalText.append(color.getText().toString());
                finalText.append(" roses\n");
                finalText.append(getResources().getString(R.string.Comment));
                finalText.append(text.getText().toString());

                ((MainActivity)getActivity()).setText(finalText.toString());
            }

        });
    }
}