package com.example.bestieat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class loca extends AppCompatActivity implements View.OnClickListener{
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loca);

        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit:
                startActivity(new Intent(this, maps.class));
                break;
        }
    }
}
