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

public class Multimedia extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_multimedia);
        Button chiffres = findViewById(R.id.chiffres);
        ImageView cat = findViewById(R.id.chat);
        ImageView chien = findViewById(R.id.chien);
        ImageView monkey = findViewById(R.id.monkey);
        ImageView deer = findViewById(R.id.deer);
        ImageView elephant = findViewById(R.id.elephant);
        ImageView koala = findViewById(R.id.koala);


        chiffres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(), Chiffres.class);
                startActivity(i1);
            }
        });

        cat.setOnClickListener(v -> {
            Intent intent = new Intent(this, VideoActivity.class);
            intent.putExtra("videoRes", R.raw.cat);
            startActivity(intent);
        });

        chien.setOnClickListener(v->{
            Intent intent = new Intent(this, VideoActivity.class);
            intent.putExtra("videoRes", R.raw.dog);
            startActivity(intent);

        });

        monkey.setOnClickListener(v->{
            Intent intent = new Intent(this, VideoActivity.class);
            intent.putExtra("videoRes", R.raw.monkey);
            startActivity(intent);

        });

        deer.setOnClickListener(v->{
            Intent intent = new Intent(this, VideoActivity.class);
            intent.putExtra("videoRes", R.raw.deer);
            startActivity(intent);

        });

        elephant.setOnClickListener(v->{
            Intent intent = new Intent(this, VideoActivity.class);
            intent.putExtra("videoRes", R.raw.elephant);
            startActivity(intent);

        });

        koala.setOnClickListener(v->{
            Intent intent = new Intent(this, VideoActivity.class);
            intent.putExtra("videoRes", R.raw.koala);
            startActivity(intent);

        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}