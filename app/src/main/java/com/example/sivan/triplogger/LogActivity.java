package com.example.sivan.triplogger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import Data.DatabaseHandler;
import Model.MyTrips;

public class LogActivity extends AppCompatActivity {

    private EditText title,date,tripType,destination, duration, comment;
    private Button save,cancel;

    //Creating object of Database Handler to access the db, table and other CRUD queries

    private DatabaseHandler dba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        title=(EditText)findViewById(R.id.editTitleText);
        date=(EditText)findViewById(R.id.editDateText);
        tripType=(EditText)findViewById(R.id.editTripTypeText);
        destination=(EditText)findViewById(R.id.editDestinationText);
        duration=(EditText)findViewById(R.id.editDurationText);
        comment=(EditText)findViewById(R.id.editCommentText);

        save=(Button)findViewById(R.id.saveButton);
        cancel=(Button)findViewById(R.id.cancelButton);

        dba = new DatabaseHandler(LogActivity.this);

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //need to write the logic to add the trips.  After saving go the main activity
                addTrips();



            }
        });


        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //write logic to cancel, after cancelling go to main activity
                //clear form after adding
               clearTrips();

            }
        });
    }

    private void clearTrips() {
        //Clearing the contents in the textbox and goin back to main activity
        title.setText("");
        date.setText("");
        tripType.setText("");
        destination.setText("");
        duration.setText("");
        comment.setText("");

        //to go to main activity after saving
        Intent intent = new Intent(LogActivity.this,MainActivity.class);
        startActivity(intent);
    }

    private void addTrips() {

        MyTrips trips = new MyTrips();

        trips.setTitle(title.getText().toString().trim());
        trips.setDate(date.getText().toString().trim());
        trips.setTripType(tripType.getText().toString().trim());
        trips.setDestination(destination.getText().toString().trim());
        trips.setDuration(duration.getText().toString().trim());
        trips.setComment(comment.getText().toString().trim());

        dba.addTrips(trips);
        dba.close();

        //clear form after adding
        title.setText("");
        date.setText("");
        tripType.setText("");
        destination.setText("");
        duration.setText("");
        comment.setText("");

        //to go to main activity after saving
        Intent intent = new Intent(LogActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
