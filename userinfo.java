package com.example.bestieat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class userinfo extends AppCompatActivity implements View.OnClickListener{
    private Button arrow;
    private Button logout;
    private Button revise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinfo);

        arrow=(Button)findViewById(R.id.arrow);
        arrow.setOnClickListener(this);
        logout=(Button)findViewById(R.id.logout);
        logout.setOnClickListener(this);
        revise=(Button)findViewById(R.id.revise);
        revise.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.arrow:
                startActivity(new Intent(this, maps.class));
                break;
            case R.id.logout:
                startActivity(new Intent(this, sign.class));
                break;
            case R.id.revise:
                startActivity(new Intent(this, passrevise.class));
                break;
        }
    }
}
