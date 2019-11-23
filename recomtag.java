package com.example.bestieat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class recomtag extends AppCompatActivity implements View.OnClickListener{
    private Button arrow;
    private Button submit;
    private Button rest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recomtag);

        arrow=(Button)findViewById(R.id.arrow);
        arrow.setOnClickListener(this);

        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(this);

        rest=(Button)findViewById(R.id.rest);
        rest.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.arrow:
                startActivity(new Intent(this, maps.class));
                break;
            case R.id.rest:
                startActivity(new Intent(this, recomtag2.class));
                break;

        }
    }
}
