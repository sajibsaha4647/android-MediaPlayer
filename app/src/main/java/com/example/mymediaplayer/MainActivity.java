package com.example.mymediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imageButton1, imageButton2;
    private ImageView imageView;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton1 = findViewById(R.id.Imagebutton); //play
        imageButton2 = findViewById(R.id.Imagebutton2);//pause
        imageView = findViewById(R.id.imageviews);
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.aideo);

        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.Imagebutton) {

            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.aideo);
            mediaPlayer.start();

        } else if (view.getId() == R.id.Imagebutton2) {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}