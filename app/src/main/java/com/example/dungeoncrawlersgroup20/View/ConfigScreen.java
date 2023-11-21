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
        medium = (RadioButton) findViewById(R.id.radioButton2);
        hard = (RadioButton) findViewById(R.id.radioButton3);
        sprite1 = (ImageButton) findViewById(R.id.imageButton);
        sprite2 = (ImageButton) findViewById(R.id.imageButton2);
        sprite3 = (ImageButton) findViewById(R.id.imageButton3);

        setUpDifficultyButtons();
        setupSpriteButtons();





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
    private void setUpDifficultyButtons() {
        easy.setOnClickListener(view -> setDifficulty("Easy", 3000));
        medium.setOnClickListener(view -> setDifficulty("Medium", 2000));
        hard.setOnClickListener(view -> setDifficulty("Hard", 1000));
    }

    private void setDifficulty(String difficulty, int health) {
        configViewModel.setPLayerDifficulty(difficulty);
        configViewModel.setPlayerHealth(health);
    }

    private void setupSpriteButtons() {
        sprite1.setOnClickListener(view -> selectSprite(R.drawable.sprite1, "First"));
        sprite2.setOnClickListener(view -> selectSprite(R.drawable.sprite2, "Second"));
        sprite3.setOnClickListener(view -> selectSprite(R.drawable.sprite3, "Third"));
    }

    private void selectSprite(int drawableId, String spriteNumber) {
        Toast.makeText(ConfigScreen.this,
                "You Selected the " + spriteNumber + " Character", Toast.LENGTH_SHORT).show();
        configViewModel.setPlayerSprite(ContextCompat.getDrawable(ConfigScreen.this, drawableId));
    }
}
