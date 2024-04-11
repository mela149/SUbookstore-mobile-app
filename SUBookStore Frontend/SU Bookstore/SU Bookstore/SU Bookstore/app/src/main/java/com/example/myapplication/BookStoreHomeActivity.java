package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BookStoreHomeActivity extends AppCompatActivity {

    TextView fiction;
    Toolbar toolbar;
    TextView nonFiction;
    TextView fantasy;
    TextView all;
    TextView thriller;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_store_home);

        toolbar = findViewById(R.id.toolbar);
        fiction = findViewById(R.id.fiction);
        nonFiction = findViewById(R.id.non_fiction);
        editText = findViewById(R.id.searchEditText);
        all = findViewById(R.id.all);
        fantasy = findViewById(R.id.fantasy);
        thriller = findViewById(R.id.thriller);

        setSupportActionBar(toolbar);
        setTitle("");

        Button viewCart = findViewById(R.id.view_cart);
        viewCart.setOnClickListener(v -> startActivity(new Intent(this, CartListActivity.class)));

        fiction.setOnClickListener(view -> {
            Intent intent = new Intent(BookStoreHomeActivity.this, BooksListActivity.class);
            intent.putExtra("key", fiction.getText().toString());
            startActivity(intent);
        });
        nonFiction.setOnClickListener(v->  {
            Intent intent = new Intent(BookStoreHomeActivity.this, BooksListActivity.class);
            intent.putExtra("key", nonFiction.getText().toString());
            startActivity(intent);
        });
        fantasy.setOnClickListener(v-> {
            Intent intent = new Intent(BookStoreHomeActivity.this, BooksListActivity.class);
            intent.putExtra("key", fantasy.getText().toString());
            startActivity(intent);
        });
        thriller.setOnClickListener(v->  {
            Intent intent = new Intent(BookStoreHomeActivity.this, BooksListActivity.class);
            intent.putExtra("key", thriller.getText().toString());
            startActivity(intent);
        });
        all.setOnClickListener(v -> {
            Intent intent = new Intent(BookStoreHomeActivity.this, SearchBookActivity.class);
            startActivity(intent);
        });
        editText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if(editText.getText().toString().isEmpty()){
                    Toast.makeText(BookStoreHomeActivity.this, "You input nothing", Toast.LENGTH_LONG).show();
                    return false;
                }
                Intent intent = new Intent(BookStoreHomeActivity.this, SearchBookActivity.class);
                intent.putExtra("key", editText.getText().toString().trim());
                startActivity(intent);
                return true;
            }
            return false;
        });
    }
}