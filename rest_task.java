package com.example.bestieat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class rest_task extends AppCompatActivity implements View.OnClickListener{
    private Button arrow;
    private Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rest_task);

        arrow=(Button)findViewById(R.id.arrow);
        arrow.setOnClickListener(this);
        create=(Button)findViewById(R.id.create);
        create.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.arrow:
                startActivity(new Intent(this, rest.class));
                break;
            case R.id.create:
                startActivity(new Intent(this, createtask.class));
                break;
        }
    }
}
