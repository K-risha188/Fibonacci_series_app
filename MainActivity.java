package com.krisha.fibonacci;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText numInput;
    private TextView fibonacciList;
    TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numInput = findViewById(R.id.numInput);
        Button clearButton = findViewById(R.id.clearButton);
        fibonacciList = findViewById(R.id.fibonacciList);
         resultTV = findViewById(R.id.result_tv);


        Button generateButton = findViewById(R.id.generateButton);
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTV.setText(generateFibonacciSeries());
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFibonacciSeries();
            }
        });
    }

    private CharSequence generateFibonacciSeries() {
        try {
            int count = Integer.parseInt(numInput.getText().toString().trim());
            List<Integer> fibonacciNumbers = new ArrayList<>();

            int a = 0, b = 1;
            fibonacciNumbers.add(a);
            fibonacciNumbers.add(b);

            for (int i = 2; i < count; i++) {
                int next = a + b;
                fibonacciNumbers.add(next);
                a = b;
                b = next;
            }

            StringBuilder sb = new StringBuilder();
            for (int num : fibonacciNumbers) {
                sb.append(num).append(", ");
            }

            fibonacciList.setText(sb.toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void clearFibonacciSeries(){
        fibonacciList.setText(" ");
        resultTV.setText(" ");
        numInput.setText(" ");
    }
    }
