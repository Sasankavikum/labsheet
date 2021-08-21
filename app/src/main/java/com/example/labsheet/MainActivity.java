package com.example.labsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void play(View v){
        if(player==null){
            player=MediaPlayer.create(this,R.raw.song);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }
    public void pause(View v){
        if(player != null){
            player.pause();
        }
    }
    public void stop(View v){
        stopPlayer();
    }

    private void stopPlayer(){
        if(player != null){
            player.release();
            player=null;
            Toast.makeText(this,"MediaPlayer released",Toast.LENGTH_SHORT);
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        stopPlayer();
    }
}