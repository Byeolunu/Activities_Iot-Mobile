package com.example.app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Chiffres extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer mp;

    private void playAudio(int resId) {
        if (mp != null) {
            mp.release();
        }
        mp = MediaPlayer.create(this, resId);
        if (mp != null) {
            mp.start();
        }
    }

    private void showToast(int number) {
        String message = getString(R.string.chiffre_format, number);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chiffres);

        findViewById(R.id.i0).setOnClickListener(this);
        findViewById(R.id.im1).setOnClickListener(this);
        findViewById(R.id.im2).setOnClickListener(this);
        findViewById(R.id.im3).setOnClickListener(this);
        findViewById(R.id.im4).setOnClickListener(this);
        findViewById(R.id.im5).setOnClickListener(this);
        findViewById(R.id.im6).setOnClickListener(this);
        findViewById(R.id.im7).setOnClickListener(this);
        findViewById(R.id.im8).setOnClickListener(this);
        findViewById(R.id.im9).setOnClickListener(this);
        Button back = findViewById(R.id.back);
        back.setOnClickListener(v -> {
            Intent i2 = new Intent(getApplicationContext(), Multimedia.class);
            startActivity(i2);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.i0) {
            playAudio(R.raw.a0);
            showToast(0);
        } else if (id == R.id.im1) {
            playAudio(R.raw.a1);
            showToast(1);
        } else if (id == R.id.im2) {
            playAudio(R.raw.a2);
            showToast(2);
        } else if (id == R.id.im3) {
            playAudio(R.raw.a3);
            showToast(3);
        } else if (id == R.id.im4) {
            playAudio(R.raw.a4);
            showToast(4);
        } else if (id == R.id.im5) {
            playAudio(R.raw.a5);
            showToast(5);
        } else if (id == R.id.im6) {
            playAudio(R.raw.a6);
            showToast(6);
        } else if (id == R.id.im7) {
            playAudio(R.raw.a7);
            showToast(7);
        } else if (id == R.id.im8) {
            playAudio(R.raw.a8);
            showToast(8);
        } else if (id == R.id.im9) {
            playAudio(R.raw.a9);
            showToast(9);
        }
    }
}