package com.example.dungeoncrawlersgroup20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConfigScreen extends AppCompatActivity {
    private EditText name;
    private Button continueButton;
    private ImageButton sprite1;
    private ImageButton sprite2;
    private ImageButton sprite3;
    private int imagechecker = 0;
    private RadioButton easy;
    private RadioButton medium;
    private RadioButton hard;
    private int radiochecker = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_screen);
        name = (EditText) findViewById(R.id.Name);
        easy = (RadioButton) findViewById(R.id.radioButton);
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radiochecker = 1;
            }
        });
        medium = (RadioButton) findViewById(R.id.radioButton2);
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radiochecker = 2;
            }
        });
        hard = (RadioButton) findViewById(R.id.radioButton3);
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radiochecker = 3;
            }
        });
        sprite1 = (ImageButton) findViewById(R.id.imageButton);
        sprite1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConfigScreen.this,
                        "You Selected the First Character", Toast.LENGTH_SHORT).show();
                imagechecker = 1;
            }
        });
        sprite2 = (ImageButton) findViewById(R.id.imageButton2);
        sprite2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConfigScreen.this,
                        "You Selected the Second Character", Toast.LENGTH_SHORT).show();
                imagechecker = 2;
            }
        });
        sprite3 = (ImageButton) findViewById(R.id.imageButton3);
        sprite3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConfigScreen.this,
                        "You Selected the Third Character", Toast.LENGTH_SHORT).show();
                imagechecker = 3;
            }
        });
        continueButton = (Button) findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((name.getText().toString().trim().length() > 0)
                        && (imagechecker != 0) && (radiochecker != 0)) {
                    Intent i = new Intent(ConfigScreen.this, GameScreen.class);
                    String username = name.getText().toString();
                    Bundle playerinfo = new Bundle();
                    playerinfo.putString("user", username);
                    playerinfo.putInt("diff", radiochecker);
                    playerinfo.putInt("sprite", imagechecker);
                    i.putExtras(playerinfo);
                    startActivity(i);
                } else {
                    Toast.makeText(ConfigScreen.this,
                            "You need to select an image, difficulty, "
                                    + "and/or enter a name before continuing",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
