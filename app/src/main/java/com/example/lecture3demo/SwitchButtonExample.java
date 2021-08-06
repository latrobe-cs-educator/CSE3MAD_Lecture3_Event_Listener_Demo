package com.example.lecture3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SwitchButtonExample extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_button_example);

        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3= (Button) findViewById(R.id.button3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        //Get the data from the intent
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            message = extras.getString("Msg");
            Log.d("IntentData", message);
        }
    }

    // Implement the OnClickListener callback
    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.button:
            {
                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.button2:
            {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.button3:
            {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}