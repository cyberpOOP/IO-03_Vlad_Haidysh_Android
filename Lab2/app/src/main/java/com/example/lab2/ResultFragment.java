package com.example.lab2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ResultFragment extends Fragment {

    TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        text = view.findViewById(R.id.textView);
    }

    public void setText(String res){
        text.setText(res);
    }
}