package com.example.app;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Notifications extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.notifications);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button1) {
            Toast.makeText(this, "Toast léger !", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.button2) {
            Toast.makeText(this, "Toast long !", Toast.LENGTH_LONG).show();
        } else if (id == R.id.button3) {
            showDialog1();
        } else if (id == R.id.button4) {
            showDialog2();
        } else if (id == R.id.button5) {
            showDialog3();
        }
    }

    private void showDialog1() {
        new AlertDialog.Builder(this)
                .setTitle("Dialogue Simple")
                .setMessage("Ceci est une boîte de dialogue avec un seul bouton.")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void showDialog2() {
        new AlertDialog.Builder(this)
                .setTitle("Confirmation")
                .setMessage("Êtes-vous sûr ?")
                .setPositiveButton("Oui", (dialog, which) -> {
                    Toast.makeText(this, "Action confirmée", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Non", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void showDialog3() {
        final EditText input = new EditText(this);
        input.setHint("Entrez votre texte ici");

        new AlertDialog.Builder(this)
                .setTitle("Dialogue Complexe")
                .setMessage("Entrez quelque chose ci-dessous.")
                .setView(input)
                .setPositiveButton("Valider", (dialog, which) -> {
                    String text = input.getText().toString();
                    Toast.makeText(this, "Texte saisi : " + text, Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Annuler", (dialog, which) -> dialog.dismiss())
                .setNeutralButton("Plus tard", (dialog, which) -> dialog.dismiss())
                .show();
    }
}