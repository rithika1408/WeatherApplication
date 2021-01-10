package com.example.weather;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class Favourites extends AppCompatActivity {
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        ListView listView=findViewById(R.id.listview);
        String[] strings={"Kolkata","Bangalore"};
        arrayList=new ArrayList<>(Arrays.asList(strings));
        adapter=new ArrayAdapter<String>(this,R.layout.layout,R.id.item,arrayList);
        listView.setAdapter(adapter);
        Intent in=getIntent();
        String newitem=in.getStringExtra("name");
        int i=arrayList.size()-1;
        arrayList.add(i+1,newitem);
        adapter.notifyDataSetChanged();
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int item=position;
                new AlertDialog.Builder(Favourites.this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle(Html.fromHtml("<font color='#000000'>"+"Are you sure "+"</font>"))
                        .setMessage("Do you want to delete this item")
                        .setMessage(Html.fromHtml("<font color='#000000'>"+"Do you want to delete this item ?"+
                                "</font>"))
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrayList.remove(item);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No",null).show();
                return true;
            }
        });
    }
}