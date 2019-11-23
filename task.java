package com.example.bestieat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class task extends AppCompatActivity implements View.OnClickListener{
    private Button arrow;
    private Button daily;
    private Button normal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task);

        arrow=(Button)findViewById(R.id.arrow);
        arrow.setOnClickListener(this);
        daily=(Button)findViewById(R.id.daily);
        daily.setOnClickListener(this);
        normal=(Button)findViewById(R.id.normal);
        normal.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.arrow:
                startActivity(new Intent(this, maps.class));
                break;
            case R.id.daily:
                startActivity(new Intent(this, mydaily.class));
                break;
            case R.id.normal:
                startActivity(new Intent(this, mynormal.class));
                break;
        }
    }
}
