package com.example.bestieat;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class addfriend extends AppCompatActivity implements View.OnClickListener{
    private Button arrow;
    private Button invite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addfriend);

        arrow=(Button)findViewById(R.id.arrow);
        arrow.setOnClickListener(this);
        invite=(Button)findViewById(R.id.invite);
        invite.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.arrow:
                startActivity(new Intent(this, friend.class));
                break;
        }
    }
}
