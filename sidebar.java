package com.example.bestieat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class sidebar extends AppCompatActivity implements View.OnClickListener{
    private Button main;
    private Button npc;
    private Button rest;
    private Button user;
    private Button task;
    private Button coupon;
    private Button collect;
    private Button friend;
    private Button shop;
    private Button record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sidebar);

        main=(Button)findViewById(R.id.main);
        main.setOnClickListener(this);
        npc=(Button)findViewById(R.id.npc);
        npc.setOnClickListener(this);
        rest=(Button)findViewById(R.id.rest);
        rest.setOnClickListener(this);
        user=(Button)findViewById(R.id.user);
        user.setOnClickListener(this);
        task=(Button)findViewById(R.id.task);
        task.setOnClickListener(this);
        coupon=(Button)findViewById(R.id.coupon);
        coupon.setOnClickListener(this);
        collect=(Button)findViewById(R.id.collect);
        collect.setOnClickListener(this);
        friend=(Button)findViewById(R.id.friend);
        friend.setOnClickListener(this);
        shop=(Button)findViewById(R.id.shop);
        shop.setOnClickListener(this);
        record=(Button)findViewById(R.id.record);
        record.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main:
                startActivity(new Intent(this, maps.class));
                break;
            case R.id.npc:
                startActivity(new Intent(this, npc.class));
                break;
            case R.id.rest:
                startActivity(new Intent(this, rest.class));
                break;
            case R.id.user:
                startActivity(new Intent(this, userinfo.class));
                break;
            case R.id.task:
                startActivity(new Intent(this, task.class));
                break;
            case R.id.coupon:
                startActivity(new Intent(this, coupon.class));
                break;
            case R.id.collect:
                startActivity(new Intent(this, collect.class));
                break;
            case R.id.friend:
                startActivity(new Intent(this, friend.class));
                break;
            case R.id.shop:
                startActivity(new Intent(this, shop.class));
                break;
            case R.id.record:
                startActivity(new Intent(this, record.class));
                break;
        }
    }
}
