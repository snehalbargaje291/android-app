package com.example.firstapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private Button buttonAdd;
    private Button buttonSubtract;
    private Button buttonMultiply;
    private Button buttonDivide;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        textViewResult = findViewById(R.id.textViewResult);

        buttonAdd.setOnClickListener(v -> performOperation('+'));
        buttonSubtract.setOnClickListener(v -> performOperation('-'));
        buttonMultiply.setOnClickListener(v -> performOperation('*'));
        buttonDivide.setOnClickListener(v -> performOperation('/'));
    }

    private void performOperation(char operation) {
        // Get the numbers from the EditText fields
        String number1Str = editTextNumber1.getText().toString();
        String number2Str = editTextNumber2.getText().toString();

        // Check if both fields are not empty
        if (!number1Str.isEmpty() && !number2Str.isEmpty()) {
            // Parse the numbers
            double number1 = Double.parseDouble(number1Str);
            double number2 = Double.parseDouble(number2Str);

            // Perform the selected operation
            double result = 0;
            switch (operation) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        // Handle division by zero
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    break;
            }

            // Display the result
            textViewResult.setText("Result: " + result);
        } else {
            // If any of the fields is empty, show an error message
            Toast.makeText(this, "Enter both numbers", Toast.LENGTH_SHORT).show();
        }
    }
}
