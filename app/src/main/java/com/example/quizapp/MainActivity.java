package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Auth Chanakijkamjorn 21803849 SIT305

    //Declare variables
    Button start;
    EditText inputname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Match IDs
        start = findViewById(R.id.button);
        inputname = findViewById(R.id.name);


        //Click start to go to next activity
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(MainActivity.this, quiz1.class);
                newIntent.putExtra("name",inputname.getText().toString());
                newIntent.putExtra("score",0);
                newIntent.putExtra("bar",30);
                startActivity(newIntent);

            }
        });

        //Receive an input name and set edittext
        Intent receiver = getIntent();
        String inputname2 = receiver.getStringExtra("name");
        inputname.setText(inputname2);


    }
}