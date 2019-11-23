package com.example.bestieat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class rest extends AppCompatActivity implements View.OnClickListener{
    private Button arrow;
    private Button tasklist;
    private Button revise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rest);

        arrow=(Button)findViewById(R.id.arrow);
        arrow.setOnClickListener(this);

        tasklist=(Button)findViewById(R.id.tasklist);
        tasklist.setOnClickListener(this);

        revise=(Button)findViewById(R.id.revise);
        revise.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.arrow:
                startActivity(new Intent(this, maps.class));
                break;
            case R.id.tasklist:
                startActivity(new Intent(this, rest_task.class));
                break;
            case R.id.revise:
                startActivity(new Intent(this, rest_task.class));
                break;
        }
    }
}
