package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Переменные
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Связываем наши переменные
        tvInfo = (TextView) findViewById(R.id.textView);
        etInput = (EditText) findViewById(R.id.editText);
        bControl = (Button) findViewById(R.id.button);

        guess = (int)(Math.random() * 100);
        gameFinished = false;

    }

    public void onClick(View v) {

        if (!gameFinished) {
            int inp = Integer.parseInt(etInput.getText().toString());
            if (inp > guess)
                tvInfo.setText(getResources().getString(R.string.ahead));
            if (inp < guess)
                tvInfo.setText("Недолет!");
            if (inp > 100)
                tvInfo.setText(getResources().getString(R.string.abouthund));
            if (inp == guess)
            {
                tvInfo.setText("В точку");
                bControl.setText(getResources().getString(R.string.play_more));
                gameFinished = true;
            }
        }
        else
        {
            guess = (int)(Math.random()*100);
            bControl.setText("Ввести значение");
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;
        }
    }
}