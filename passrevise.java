package com.example.bestieat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class passrevise extends AppCompatActivity implements View.OnClickListener{
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passrevise);

        back=(Button)findViewById(R.id.back);
        back.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, userinfo.class));
    }
}
