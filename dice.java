package com.example.bestieat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class dice extends AppCompatActivity implements View.OnClickListener{
    private Button main;
    private ImageButton dice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dice);

        main=(Button)findViewById(R.id.main);
        main.setOnClickListener(this);
        dice=(ImageButton)findViewById(R.id.dice);
        dice.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main:
                startActivity(new Intent(this, maps.class));
                break;
            case R.id.dice:
                startActivity(new Intent(this, dice_rest.class));
                break;
        }
    }
}
