package com.mirea.kt.bankcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText textMonths = findViewById(R.id.editTextMonths);
        EditText textPercentage = findViewById(R.id.editTextYearPercentage);
        EditText textBaseSum = findViewById(R.id.editTextBaseSum);
        TextView outText = findViewById(R.id.tvCalculatedSum);
        Button button = findViewById(R.id.btnCalc);

        button.setOnClickListener(v->{
            Log.d("button_click","Main button clicked");

                String stringPercentage = textPercentage.getText().toString();
                String stringBaseSum = textBaseSum.getText().toString();
                String stringMonth = textMonths.getText().toString();

                if (!stringPercentage.isEmpty() && !stringBaseSum.isEmpty() && !stringMonth.isEmpty()) {
                    try {
                        float percentage = Float.parseFloat(stringPercentage);
                        float baseSum = Float.parseFloat(stringBaseSum);
                        int months = Integer.parseInt(stringMonth);

                        if (months>1200){
                            months=1200;
                            textMonths.setText("1200");
                        }

                        float newSum = baseSum;
                        for (int i = 0; i < months; i++) {
                            newSum = newSum * (1 + (percentage / (1200)));
                            Log.d("calculation", "" + newSum);
                        }

                        String text = getResources().getString(R.string.outcome) + " " + newSum;

                            outText.setText(text);
                            outText.setTextColor(getResources().getColor(R.color.black));
                            Log.d("calculation", "Successfully calculated");

                    }catch (Exception e){
                        outText.setText(getResources().getString(R.string.error));
                        outText.setTextColor(getResources().getColor(R.color.warning));
                        Log.d("app", "Data error");
                    }
                } else {
                    outText.setText(getResources().getString(R.string.empty_fields));
                    outText.setTextColor(getResources().getColor(R.color.warning));
                    Log.d("calculation", "Empty fields");
                }


        });
    }
}