package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class SearchBookActivity extends AppCompatActivity implements BooksAdapter.OnItemClickListener  {

    private BooksAdapter booksAdapter;
    private List<Book> books;
    private RecyclerView recyclerView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_book);
        String query = getIntent().getStringExtra("key");
        editText = findViewById(R.id.searchEditText);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        if(query == null || query.isEmpty()){
            books = BookController.getAllBooks();
        }else{
            books = BookController.searchBooksFromAll(query);
        }
        booksAdapter = new BooksAdapter(books, this);
        recyclerView.setAdapter(booksAdapter);
        booksAdapter.setOnItemClickListener(this);
        editText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if(editText.getText().toString().isEmpty()){
                    booksAdapter.addNewBooks(books);
                }
                List<Book> newBooks = BookController.searchBooksFromAll(editText.getText().toString());
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