package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class End extends AppCompatActivity {

    //Declare variables
    TextView disname,result;
    Button Takenewquiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        //Match IDs
        disname = findViewById(R.id.textView4);
        result = findViewById(R.id.textView7);

        //Receive a value and display
        Intent receiver = getIntent();
        String inputname = receiver.getStringExtra("name");
        Integer updatedscore = receiver.getIntExtra("score",0);
        disname.setText("Congratulations "+inputname);
        result.setText("You got:"+updatedscore+"/3");

        //Take new quiz button
        Takenewquiz = findViewById(R.id.button3);
        Takenewquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Go to next activity and pass name
                Intent newIntent = new Intent(End.this, MainActivity.class);
                newIntent.putExtra("name",inputname);
                startActivity(newIntent);
            }
        });



    }
}