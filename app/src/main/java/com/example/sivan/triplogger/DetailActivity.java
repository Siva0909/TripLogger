package com.example.sivan.triplogger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import Data.DatabaseHandler;

public class DetailActivity extends AppCompatActivity {

    private Button deleteButton;
    private TextView title,date,content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title=(TextView)findViewById(R.id.detailsTitle);
        date=(TextView)findViewById(R.id.detailsTextDate);
        content=(TextView)findViewById(R.id.detailsDestination);
        deleteButton=(Button)findViewById(R.id.deleteButton);

        Bundle extras =getIntent().getExtras();

        if(extras!=null){
            title.setText(extras.getString("Title"));   //"title" is the key that is got from the previous activity which is DisplayWish
            date.setText("Created" +extras.get("Date"));
            content.setText("\"" + extras.get("Content") +"\"");

            final int id= extras.getInt("id");

            deleteButton.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    DatabaseHandler dba = new DatabaseHandler(getApplicationContext());
                    dba.deleteTrip(id);

                    Toast.makeText(getApplicationContext(),"Trip Deleted",Toast.LENGTH_LONG).show();

                    startActivity(new Intent(DetailActivity.this,MainActivity.class));
                }
            });
        }
    }
}
