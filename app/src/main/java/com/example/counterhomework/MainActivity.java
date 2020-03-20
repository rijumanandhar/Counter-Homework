package com.example.counterhomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int count = 0;
    private TextView counterText;
    private Button countButton;
    private EditText textEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity","On Create");

        counterText = findViewById(R.id.text_counter);
        countButton = findViewById(R.id.button_count);
        textEditor = findViewById(R.id.editText);

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                counterText.setText(count+"");
            }
        });

        if (savedInstanceState != null){
            Log.d("MainActivity","Get Instance");
            int value = savedInstanceState.getInt("count");
            counterText.setText(value+"");
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("MainActivity","Save Instance");
        outState.putInt("count",count);
    }
}
