package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;

    public void generateRandomNumber(){
        Random random = new Random();
        randomNumber = random.nextInt(20) + 1;
    }
    public void guessNumber(View view){

        EditText text = findViewById(R.id.editTextTextPersonName);
        if(text.getText().toString().isEmpty())
            Toast.makeText(this, "Please Enter a Number", Toast.LENGTH_SHORT).show();
        else {
            int number = Integer.parseInt(text.getText().toString());
            String s;

            if(number < 1  || number > 20)
                Toast.makeText(this, "Enter Number Between 1 and 20", Toast.LENGTH_SHORT).show();
            else {
                if (number > randomNumber)
                    s = "Lower";
                else if (number < randomNumber)
                    s = "Higher";
                else {
                    s = "You got it!Try Again";
                    generateRandomNumber();
                }

                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();
    }
}