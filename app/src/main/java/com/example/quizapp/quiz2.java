package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class quiz2 extends AppCompatActivity implements View.OnClickListener {

    //Declare variables
    Button ans1,ans2,ans3,submit,next;
    String selectedans = "";
    int currentprogress ;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_quiz2);

        //Match IDs
        next = findViewById(R.id.next);
        submit = findViewById(R.id.Submit);
        ans1 = findViewById(R.id.button10);
        ans2 = findViewById(R.id.button11);
        ans3 = findViewById(R.id.button9);
        progressBar = findViewById(R.id.progressBar);

        //Set onclick to each button
        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        submit.setOnClickListener(this);

        //Receive progress bar value and set it
        Intent receiver1 = getIntent();
        currentprogress = receiver1.getIntExtra("bar",30);
        progressBar.setProgress(currentprogress);
        progressBar.setMax(90);

    }

    @Override
    public void onClick(View view) {

        //Receive name and score value
        Intent receiver = getIntent();
        String inputname = receiver.getStringExtra("name");
        Integer updatedscore = receiver.getIntExtra("score",0);

        //Set all choices button to grey
        ans1.setBackgroundColor(Color.GRAY);
        ans2.setBackgroundColor(Color.GRAY);
        ans3.setBackgroundColor(Color.GRAY);

        //Find and edit a clicked button
        Button clicked = (Button) view;
        selectedans = clicked.getText().toString();
        clicked.setBackgroundColor(Color.BLUE);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //Set all button except next button to be disable to stop client who will change their answer
                next.setEnabled(true);
                ans1.setEnabled(false);
                ans2.setEnabled(false);
                ans3.setEnabled(false);
                submit.setEnabled(false);
                //if and else to check the answer
                if (clicked.getId()==R.id.button11){
                    ans2.setBackgroundColor(Color.GREEN);
                }
                else if (clicked.getId()==R.id.button10)
                {
                    ans2.setBackgroundColor(Color.GREEN);
                    ans1.setBackgroundColor(Color.RED);
                }
                else
                {
                    ans2.setBackgroundColor(Color.GREEN);
                    ans3.setBackgroundColor(Color.RED);
                }
            }
        });
        //Next button
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //Go to next activity
                Intent newIntent = new Intent(quiz2.this, quiz3.class);
                newIntent.putExtra("name",inputname);
                //If and else for adding score
                if (clicked.getId()==R.id.button11){
                    newIntent.putExtra("score",updatedscore+1);
                    newIntent.putExtra("bar",currentprogress +30);

                    startActivity(newIntent);
                }
                else {
                    newIntent.putExtra("score",updatedscore);
                    newIntent.putExtra("bar",currentprogress +30);

                    startActivity(newIntent);
                }
            }
        });
    }
}