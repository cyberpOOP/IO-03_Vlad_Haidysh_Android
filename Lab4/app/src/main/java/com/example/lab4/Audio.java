package com.example.lab4;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

public class Audio extends Fragment {

    ImageView title;
    ImageButton back, pause, forward;
    MediaPlayer player;
    int n = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_audio, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        title = view.findViewById(R.id.imageView);
        title.setImageResource(R.drawable.image);

        if (player == null) {
            player = MediaPlayer.create(getContext(), R.raw.audio);
            player.setOnCompletionListener(
                    mp -> stopPlayer());
        }
        player.start();

        back = view.findViewById(R.id.back);
        pause = view.findViewById(R.id.pause);
        forward = view.findViewById(R.id.forward);

        back.setOnClickListener(view1 -> stop());
        pause.setOnClickListener(view2 -> pause());
        forward.setOnClickListener(view3 -> stopPlayer());
    }

    public void pause() {
        if (player != null && n == 0) {
            player.pause();
            n = 1;
            pause.setImageResource(android.R.drawable.ic_media_play);
        }
        else if(player != null){
            player.start();
            n = 0;
            pause.setImageResource(android.R.drawable.ic_media_pause);
        }
    }

    public void stop() {
        player.pause();
        player.seekTo(0);
        n = 1;
        pause.setImageResource(android.R.drawable.ic_media_play);
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(getContext(), "Song ends", Toast.LENGTH_SHORT).show();

        }
    }

}