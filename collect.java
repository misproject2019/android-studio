package com.example.bestieat;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class collect extends AppCompatActivity implements View.OnClickListener{
    private Button arrow;
    private Button my;
    private Button friend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collect);

        arrow=(Button)findViewById(R.id.arrow);
        arrow.setOnClickListener(this);
        my=(Button)findViewById(R.id.my);
        my.setOnClickListener(this);
        friend=(Button)findViewById(R.id.friend);
        friend.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.arrow:
                startActivity(new Intent(this, maps.class));
                break;
            case R.id.my:
                startActivity(new Intent(this, collection_my.class));
                break;
            case R.id.friend:
                startActivity(new Intent(this, collection_fri.class));
                break;
        }
    }
}
