package com.example.block06;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imageView_large = (ImageView) findViewById(R.id.imageview_large);
        imageView_large.setImageResource(R.drawable.download);

        SeekBar seekBar_tuner = (SeekBar) findViewById(R.id.seekbar_tuner);
        seekBar_tuner.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int last_progress;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                last_progress=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                imageView_large.setColorFilter(Color.argb(100,last_progress,0,255-last_progress), PorterDuff.Mode.SRC_ATOP);
            }
        });
    }
}
