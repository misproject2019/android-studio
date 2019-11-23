package com.example.bestieat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class roulette_rest extends AppCompatActivity implements View.OnClickListener{
    private Button arrow;
    private Button tasklist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recom_rest);

        arrow=(Button)findViewById(R.id.arrow);
        arrow.setOnClickListener(this);
        tasklist=(Button)findViewById(R.id.tasklist);
        tasklist.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.arrow:
                startActivity(new Intent(this, maps.class));
                break;
            case R.id.tasklist:
                startActivity(new Intent(this, task.class));
                break;
        }
    }
}