package com.example.lab4;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_video, container, false);
    }

    VideoView video;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        video = view.findViewById(R.id.videoView);

        video.setMediaController(new MediaController(getContext()));

        String uriPath = "android.resource://" + getContext().getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(uriPath);
        video.setVideoURI(uri);
        video.start();

    }
}