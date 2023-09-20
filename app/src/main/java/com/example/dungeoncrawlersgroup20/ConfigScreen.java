package com.example.dungeoncrawlersgroup20;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfigScreen extends AppCompatActivity {
    EditText Name;
    Button continueButton;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_screen);
        Name = (EditText)findViewById(R.id.Name);
        continueButton = (Button)findViewById(R.id.continueButton);
    }
}
