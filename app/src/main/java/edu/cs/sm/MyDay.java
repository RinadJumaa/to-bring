package edu.cs.sm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyDay extends AppCompatActivity {
    private ImageView imgMYday;
    private TextView txtMyday;
    private TextView txtLocation;
    private TextView txtreapet ;
    private TextView txtAddDueDate;
    private TextView txtRemind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_day);
        imgMYday = findViewById(R.id.imgback);
        txtMyday = findViewById(R.id.myday);
        txtLocation=findViewById(R.id.btnSetLocation);
        txtreapet=findViewById(R.id.btnReapet);
        txtAddDueDate=findViewById(R.id.btnDuedate);
        txtRemind=findViewById(R.id.btnRemindme);
        //txtAddTasks=findViewById(R.id.btnaddtask);


        imgMYday.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v) {
                Intent i = new Intent(edu.cs.sm.MyDay.this, NoteActivity.class);
                startActivity(i);
                finish();
            }
        });
        txtLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(edu.cs.sm.MyDay.this, LocationAlarm.class);
                startActivity(i);
                finish();
            }
        });
        txtAddDueDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(edu.cs.sm.MyDay.this, AddDueDate.class);
                startActivity(i);
                finish();
            }
        });
        txtRemind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(edu.cs.sm.MyDay.this, NoteActivity.class);
                startActivity(i);
                finish();
            }
        });


}
    }
