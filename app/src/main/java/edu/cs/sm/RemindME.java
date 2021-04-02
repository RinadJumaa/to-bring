package edu.cs.sm;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RemindME extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remind_m_e);
        ListView listView=(ListView)findViewById(R.id.listview);

//create ArrayList of String
        final ArrayList<String> arrayList=new ArrayList<>();

//Add elements to arraylist
        arrayList.add("Saturday ");
        arrayList.add("Sunday ");
        arrayList.add("Monday");
        arrayList.add("Tuesday ");
        arrayList.add("Wednesday");
        arrayList.add("Thursday ");
        arrayList.add("Friday ");

//Create Adapter
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);

//assign adapter to listview
        listView.setAdapter(arrayAdapter);

//add listener to listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(edu.cs.sm.RemindME.this,"Remind me:"+i+" "+arrayList.get(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}