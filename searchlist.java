package com.example.bestieat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class searchlist extends AppCompatActivity implements View.OnClickListener{
    private Button arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchlist);

        arrow=(Button)findViewById(R.id.arrow);
        arrow.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, maps.class));
    }
}
