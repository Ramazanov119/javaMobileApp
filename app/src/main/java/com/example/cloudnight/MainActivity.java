package com.example.cloudnight;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = (TextView)findViewById(R.id.textView);
        etInput = (EditText)findViewById(R.id.editTextNumber);
        bControl = (Button)findViewById(R.id.button);
        guess = (int)(Math.random()*100);
        gameFinished = false;

    }


    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    public void onClick(View view) {
        if (!gameFinished) {
            if (etInput.getText().toString().trim().isEmpty()) {
                etInput.setError(getResources().getString(R.string.error));
            } else {
                int inp = Integer.parseInt(etInput.getText().toString());
                if (inp > guess)
                    if (inp > 100){
                    etInput.setError(getResources().getString(R.string.error));}
                    else {
                        tvInfo.setText(getResources().getString(R.string.ahead));
                    }
                if (inp < guess)
                    tvInfo.setText(getResources().getString(R.string.behind));
                if (inp == guess) {
                    tvInfo.setText(getResources().getString(R.string.hit));
                    bControl.setText(getResources().getString(R.string.play_more));
                    gameFinished = true;
                }
            }
        }
        else
        {
            guess = (int)(Math.random()*100);
            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;
        }
        etInput.setText("");
    }

    public void onClick_end(View view) {
        this.finish();
    }
}

