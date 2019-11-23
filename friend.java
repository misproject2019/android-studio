package com.example.bestieat;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class friend extends AppCompatActivity implements View.OnClickListener{
    private Button arrow;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend);

        arrow=(Button)findViewById(R.id.arrow);
        arrow.setOnClickListener(this);
        add=(Button)findViewById(R.id.add);
        add.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.arrow:
                startActivity(new Intent(this, maps.class));
                break;
            case R.id.add:
                startActivity(new Intent(this, addfriend.class));
                break;
        }
    }
}
