package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class CartListActivity extends AppCompatActivity implements BooksAdapter.OnItemClickListener {

    private BooksAdapter booksAdapter;
    private List<Book> books;
    private RecyclerView recyclerView;
    private TextView error;
    private Button buyNow;
    private TextView totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list_adapter);
    recyclerView = findViewById(R.id.recyclerView);
    totalPrice = findViewById(R.id.totalPrice);
    buyNow = findViewById(R.id.buy_now);
    error = findViewById(R.id.error);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    books = BookController.getShoppingCart();
    if(books.isEmpty()){
        error.setVisibility(View.VISIBLE);
    }else{
        error.setVisibility(View.GONE);
    }
    totalPrice.setText("Total price is $" + BookController.getTotalPrice(books));
    booksAdapter = new BooksAdapter(books, this);
        recyclerView.setAdapter(booksAdapter);
        booksAdapter.setOnItemClickListener(this);

        buyNow.setOnClickListener(v -> startActivity(new Intent(this, BuyNowActivity.class)));

}

    @Override
    public void onItemClick(Book book) {
        Intent intent = new Intent(this, BookDetailsActivity.class);
        intent.putExtra("book", book);
        startActivity(intent);
    }
}