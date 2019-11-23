package com.example.bestieat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifImageView;

public class roulette extends AppCompatActivity implements View.OnClickListener{
    private Button arrow;
    private Button press;
    private Button stop;
    private GifImageView run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roulette);

        arrow=(Button)findViewById(R.id.arrow);
        arrow.setOnClickListener(this);
        press=(Button)findViewById(R.id.press);
        press.setOnClickListener(this);
        stop=(Button)findViewById(R.id.stop);
        stop.setOnClickListener(this);
        run=(GifImageView)findViewById(R.id.run);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.arrow:
                startActivity(new Intent(this, roulette_tag.class));
                break;
            case R.id.press:
                run.setVisibility(View.VISIBLE);
                stop.setVisibility(View.VISIBLE);
                break;
            case R.id.stop:
                startActivity(new Intent(this, roulette_rest.class));
                break;
        }
    }
}
