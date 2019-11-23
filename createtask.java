package com.example.bestieat;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class createtask extends AppCompatActivity implements View.OnClickListener{
    private Button arrow;
    private Button require;
    private Button startdate;
    private Button enddate;
    String single[] = {"出示優惠畫面", "打卡", "其他"};
    private String singleChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createtask);

        arrow=(Button)findViewById(R.id.arrow);
        arrow.setOnClickListener(this);
        require=(Button)findViewById(R.id.require);
        startdate=(Button)findViewById(R.id.startdate);
        enddate=(Button)findViewById(R.id.enddate);
    }
    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, rest_task.class));
    }
    public void datePickerDialog(View view) {
        Dialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                startdate.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
            }
        }, 2019, 10, 2);
        dialog.show();//显示对话框
    }
    public void datePickerDialog2(View view) {
        Dialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                enddate.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
            }
        }, 2019, 10, 2);
        dialog.show();//显示对话框
    }

    public void singleChoiceItems(View view) {
        Dialog dialog = new AlertDialog.Builder(this)
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        singleChoice = single[0];//默认选择第一项
                        require.setText(singleChoice);
                        dialog.dismiss();
                    }
                })
                //设置单选框监听
                .setSingleChoiceItems(single, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        singleChoice = single[which];//根据which决定选择了哪一个子项
                    }
                }).create();
        dialog.show();
    }
}
