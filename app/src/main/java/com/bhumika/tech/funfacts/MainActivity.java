// The package to which this class belongs
package com.bhumika.tech.funfacts;

// importing the in-built packages, so that we can use them
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

// To generate random numbers
import java.util.Random;
// For generating colors
import android.graphics.Color;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // "extends" used to "inherit" classes. That is, get some basic properties/behaviours from parent class
    // "implements" used to "implement", i.e. give the logic for an interface

    // AppCompatActivity is a type on activity
    // View.OnClickListener listens/looks out for "click" events on views that are "registered" with it

    // An array of facts
    String[] facts = {
            "Ants stretch when they wake up in the morning.",
            "Ostriches can run faster than horses.",
            "Olympic gold medals are actually made mostly of silver.",
            "You are born with 300 bones; by the time you are an adult you will have 206.",
            "It takes about 8 minutes for light from the Sun to reach Earth.",
            "Some bamboo plants can grow almost a meter in just one day.",
            "The state of Florida is bigger than England.",
            "Some penguins can leap 2-3 meters out of the water.",
            "On average, it takes 66 days to form a new habit.",
            "Mammoths still walked the earth when the Great Pyramid was being built." };

    TextView factTextView;
    Button changeFactButton;
    RelativeLayout container; // "reference" to layout that encloses the fact text view & the button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // setting the UI contained in avtivity_main.xml

        initLayouts(); // get the different layout objects & assign them to corressponding references
    }

    protected void initLayouts()
    {
        factTextView = findViewById(R.id.factTextView);
        factTextView.setText(facts[0]); // set some basic fact to display
        changeFactButton = findViewById(R.id.changeFactButton);
        changeFactButton.setOnClickListener(this); // register the button with the listener
        container = findViewById(R.id.container); // get the enclosing layout
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.changeFactButton: // if change fact button was clicked
                changeFactAndColor();
                break;
        }
    }

    private void changeFactAndColor()
    {
        Random randomObj = new Random(); // getting an Object of "Random" class
        int index = randomObj.nextInt(9); // get a random "integer" between 0 to 9
        factTextView.setText(facts[index]); // set a random fact from the facts array

        // set random values for Red(R), Green(G), Blue(B) components using Random
        // gets a random "integer" between 0 to 255
        // alpha is the opacity of color
        // alpha value of 255 makes the color fully opaque
        // aplha value 0 makes the color fully transparent
        int color = Color.argb(255, randomObj.nextInt(256), randomObj.nextInt(256), randomObj.nextInt(256));
        container.setBackgroundColor(color); // set background color for the layout
    }
}

// CHALLENGE
// Try to adjust the text color & background color to have a good contrast so that the text is readable on a background color