package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuyNowActivity extends AppCompatActivity {

    private EditText titleInput;
    private EditText lastNameInput;
    private EditText addressInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_now);
        titleInput = findViewById(R.id.titleInput);
        lastNameInput = findViewById(R.id.lastNameInput);
        addressInput = findViewById(R.id.addressInout);

        Button buyNowButton = findViewById(R.id.buy_now);
        buyNowButton.setOnClickListener(view -> {
            String title = titleInput.getText().toString().trim();
            String lastName = lastNameInput.getText().toString().trim();
            String address = addressInput.getText().toString().trim();
            if (title.isEmpty() || lastName.isEmpty() || address.isEmpty()) {
                Toast.makeText(BuyNowActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(BuyNowActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            }
        });
    }
}