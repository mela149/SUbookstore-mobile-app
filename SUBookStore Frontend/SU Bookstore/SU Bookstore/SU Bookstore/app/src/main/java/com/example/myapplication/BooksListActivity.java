package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BooksListActivity extends AppCompatActivity implements BooksAdapter.OnItemClickListener {

    private BooksAdapter booksAdapter;
    private List<Book> books;
    private RecyclerView recyclerView;
    private TextView type;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);
        String typeIntent = getIntent().getStringExtra("key");
        editText = findViewById(R.id.searchEditText);
        recyclerView = findViewById(R.id.recyclerView);
        type = findViewById(R.id.type);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        type.setText(typeIntent);
        books = BookController.getBooksByCategory(typeIntent);
        booksAdapter = new BooksAdapter(books, this);
        recyclerView.setAdapter(booksAdapter);
        booksAdapter.setOnItemClickListener(this);
        editText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if(editText.getText().toString().isEmpty()){
                    booksAdapter.addNewBooks(books);
                }
                List<Book> newBooks = BookController.searchBooksFromPremadeList(books, editText.getText().toString());
                booksAdapter.addNewBooks(newBooks);
                return true;
            }
            return false;
        });
    }

    @Override
    public void onItemClick(Book book) {
        Intent intent = new Intent(this, BookDetailsActivity.class);
        intent.putExtra("book", book);
        startActivity(intent);
    }
}