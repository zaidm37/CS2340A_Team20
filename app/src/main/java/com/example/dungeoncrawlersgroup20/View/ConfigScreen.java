package com.example.dungeoncrawlersgroup20.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.dungeoncrawlersgroup20.R;
import com.example.dungeoncrawlersgroup20.ViewModel.ConfigViewModel;

public class ConfigScreen extends AppCompatActivity {
    private EditText name;
    private Button continueButton;
    private ImageButton sprite1;
    private ImageButton sprite2;
    private ImageButton sprite3;
    private RadioButton easy;
    private RadioButton medium;
    private RadioButton hard;
    private ConfigViewModel configViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_screen);
        configViewModel = new ViewModelProvider(this).get(ConfigViewModel.class);
        configViewModel.setPlayerSprite(null);
        configViewModel.setPLayerDifficulty("");
        name = (EditText) findViewById(R.id.Name);
        easy = (RadioButton) findViewById(R.id.radioButton);
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configViewModel.setPLayerDifficulty("Easy");
                configViewModel.setPlayerHealth(3000);
            }
        });
        medium = (RadioButton) findViewById(R.id.radioButton2);
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configViewModel.setPLayerDifficulty("Medium");
                configViewModel.setPlayerHealth(2000);
            }
        });
        hard = (RadioButton) findViewById(R.id.radioButton3);
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configViewModel.setPLayerDifficulty("Hard");
                configViewModel.setPlayerHealth(1000);
            }
        });
        sprite1 = (ImageButton) findViewById(R.id.imageButton);
        sprite1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConfigScreen.this,
                        "You Selected the First Character", Toast.LENGTH_SHORT).show();
                configViewModel.setPlayerSprite(ContextCompat.getDrawable(
                        ConfigScreen.this, R.drawable.sprite1));
            }
        });
        sprite2 = (ImageButton) findViewById(R.id.imageButton2);
        sprite2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConfigScreen.this,
                        "You Selected the Second Character", Toast.LENGTH_SHORT).show();
                configViewModel.setPlayerSprite(ContextCompat.getDrawable(
                        ConfigScreen.this, R.drawable.sprite2));
            }
        });
        sprite3 = (ImageButton) findViewById(R.id.imageButton3);
        sprite3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConfigScreen.this,
                        "You Selected the Third Character", Toast.LENGTH_SHORT).show();
                configViewModel.setPlayerSprite(ContextCompat.getDrawable(
                        ConfigScreen.this, R.drawable.sprite3));
            }
        });
        continueButton = (Button) findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configViewModel.setPlayerName(name.getText().toString());
                if (configViewModel.isValidInput()) {
                    Intent i = new Intent(ConfigScreen.this, GameScreen.class);
                    Bundle playerinfo = new Bundle();
                    playerinfo.putString("diff", configViewModel.getPlayerDifficulty());
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
