package com.monkeypark.guessit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int num;
    Random rand;

    public void guessNum(View view)
    {
        try {
            EditText guess = (EditText) findViewById(R.id.guessNum);

            String sGuess = guess.getText().toString();
            if(sGuess != null)
            {
                int iGuess = Integer.parseInt(sGuess);
                if (num == iGuess) {
                    Toast.makeText(this, "You are awesome, you Guess it ", Toast.LENGTH_SHORT).show();

                } else if (num < iGuess) {
                    Toast.makeText(this, "Too High", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Too low", Toast.LENGTH_SHORT).show();
                }
                guess.setText("");
            }else
            {
                Toast.makeText(this, "Please Enter Integer only!!!", Toast.LENGTH_SHORT).show();
            }

        }catch(NumberFormatException e)
        {
            Toast.makeText(this, "Please Enter Integer only!!!", Toast.LENGTH_SHORT).show();
        }


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rand = new Random();
        num = rand.nextInt(20) + 1;

    }
}
