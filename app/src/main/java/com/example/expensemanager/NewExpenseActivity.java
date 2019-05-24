package com.example.expensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewExpenseActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    private String expenseName;
    private int expenseAmount;

    private EditText expenseNameEditText;
    private EditText expenseAmountEditText;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_expense);

        expenseNameEditText = findViewById(R.id.expenseNameEditText);
        expenseAmountEditText = findViewById(R.id.expenseAmountEditText);

        final Button button =findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(expenseNameEditText.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    expenseName = expenseNameEditText.getText().toString();
                    String expenseAmount = expenseAmountEditText.getText().toString();
                    int finalValue = Integer.parseInt(expenseAmount);
                    replyIntent.putExtra(expenseName, finalValue);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
