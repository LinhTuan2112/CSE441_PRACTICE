package com.example.servicedemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btn_play, btn_stop;
    private TextView tv_songName;
    private static final String AUDIO_URL = "https://www.youtube.com/watch?v=OrDB4jpA1g8";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn_play = findViewById(R.id.btn_play);
        btn_stop = findViewById(R.id.btn_stop);
        tv_songName = findViewById(R.id.tv_songName);

        btn_play.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MusicService.class);
            intent.putExtra("audioUrl", AUDIO_URL);
            startService(intent);
            tv_songName.setText("Đang phát: Thiên lý ơi");
        });

        btn_stop.setOnClickListener(v -> {
            stopService(new Intent(MainActivity.this, MusicService.class));
            tv_songName.setText("Dừng phát nhạc ");
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}