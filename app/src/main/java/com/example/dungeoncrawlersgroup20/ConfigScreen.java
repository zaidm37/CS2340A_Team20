package com.example.dungeoncrawlersgroup20;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConfigScreen extends AppCompatActivity {
    EditText Name;
    Button continueButton;
    TextView textView;
    ImageButton sprite1;
    ImageButton sprite2;
    ImageButton sprite3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_screen);
        Name = (EditText)findViewById(R.id.Name);
        sprite1 = (ImageButton) findViewById(R.id.imageButton);
        sprite1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConfigScreen.this, "You Selected the First Character", Toast.LENGTH_SHORT).show();
            }
        });
        sprite2 = (ImageButton) findViewById(R.id.imageButton2);
        sprite2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConfigScreen.this, "You Selected the Second Character", Toast.LENGTH_SHORT).show();
            }
        });
        sprite3 = (ImageButton) findViewById(R.id.imageButton3);
        sprite3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConfigScreen.this, "You Selected the Third Character", Toast.LENGTH_SHORT).show();
            }
        });
        continueButton = (Button)findViewById(R.id.continueButton);
    }
}
