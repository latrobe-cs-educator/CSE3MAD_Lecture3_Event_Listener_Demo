package com.example.lecture3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*      This example shows how to set OnClickListeners for multiple buttons and handle them all in one onClick method.
        Instead of passing an anonymous inner class to the setOnClickListener method,
        we will pass the activity itself and implement the OnClickListener interface into our MainActivity.
        We will then use a switch/case statement to check for the button IDs and handle the corresponding button click.  */

public class MainActivity extends AppCompatActivity
{
    Button Anon_Btn, Named_Btn, GoTo_Btn, Long_Click_Btn, Implicit_intent_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anon_Btn = (Button)findViewById(R.id.AnonBtn);
        Named_Btn = (Button)findViewById(R.id.NamedBtn);
        GoTo_Btn = (Button)findViewById(R.id.GoToClassExample);
        Long_Click_Btn = (Button)findViewById(R.id.longClickBtn);
        Implicit_intent_Btn = (Button)findViewById(R.id.impBtn);

        /*Android developers often use anonymous inner classes to define specialized listeners, which register
        //callbacks for specific behavior when an event occurs. For example, to listen for clicks on a View control,
        //the developer must call the setOnClickListener() method, which takes a single parameter: a View.OnClickListener object.
        //Developers routinely use the anonymous inner class technique to create, define and use their custom View.OnClickListener */

        //Register the onClick listener with Anonymous Inner Class
        Anon_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "I used an Anonymous Inner Class", Toast.LENGTH_SHORT).show();
            }
        });

        //Using a named inner class is more cumbersome and simply not required
        Named_Btn.setOnClickListener(new MyNamedListener());

        //Standard and LongClick examples
        Long_Click_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Standard Click", Toast.LENGTH_SHORT).show();
            }
        });

        Long_Click_Btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getApplicationContext(), "LongClick", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        Implicit_intent_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.latrobe.edu.au/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    class MyNamedListener implements View.OnClickListener {
        public void onClick(View arg0) {
            Toast.makeText(getApplicationContext(), "I used a Named Class", Toast.LENGTH_SHORT).show();
        }
    }

    //Less preferred as it doesn't follow the stand Android separation of function and presentation
    public void myCustomMethod(View view) {
        Toast.makeText(getApplicationContext(), "I used onClick in my XML", Toast.LENGTH_SHORT).show();
    }

    public void goToSwitchActivity(View view) {
        //EXPLICIT intent example
        Intent intent = new Intent(this, SwitchButtonExample.class);
        startActivity(intent);
    }
}