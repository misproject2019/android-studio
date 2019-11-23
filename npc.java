package com.example.bestieat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class npc extends AppCompatActivity implements View.OnClickListener{
    private Button arrow;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.npc);

        arrow=(Button)findViewById(R.id.arrow);
        arrow.setOnClickListener(this);
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.arrow:
                startActivity(new Intent(this, user_register.class));
                break;
            case R.id.submit:
                startActivity(new Intent(this, sign.class));
                break;
        }
    }
}
