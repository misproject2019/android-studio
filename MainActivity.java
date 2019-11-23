package com.example.bestieat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button press;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        press=(Button)findViewById(R.id.press);
        press.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        startActivity(new Intent(this, sign.class));
    }
}
