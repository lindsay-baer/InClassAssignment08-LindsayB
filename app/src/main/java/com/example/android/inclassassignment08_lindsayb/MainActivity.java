package com.example.android.inclassassignment08_lindsayb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView displayList;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference hikingTripRef = database.getReference("Hiking Trip");
    private ArrayList<HikingTrip> hikingTripList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayList = (TextView) findViewById(R.id.display_text);

        hikingTripRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                hikingTripList.add(dataSnapshot.getValue(HikingTrip.class));
                displayPlaces();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Toast.makeText(MainActivity.this, dataSnapshot.getValue(HikingTrip.class) + " has changed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Toast.makeText(MainActivity.this, dataSnapshot.getValue(HikingTrip.class) + " is removed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void another(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    private void displayPlaces() {
        String text = "";
        for (HikingTrip r : hikingTripList)
            text += r;
        displayList.setText(text);
    }
}