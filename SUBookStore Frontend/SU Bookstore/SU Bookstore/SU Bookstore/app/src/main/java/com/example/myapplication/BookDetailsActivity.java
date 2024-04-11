package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class BookDetailsActivity extends AppCompatActivity {

    ImageView image;
    TextView title;
    TextView author;
    TextView publisher;
    TextView year;
    TextView price;
    Book book = null;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        image = findViewById(R.id.image);
        title = findViewById(R.id.title);
        btn = findViewById(R.id.btn_buy);
        author = findViewById(R.id.author);
        publisher = findViewById(R.id.publisher);
        year = findViewById(R.id.year);
        price = findViewById(R.id.price);

        if (android.os.Build.VERSION.SDK_INT >= 33) {
            book = getIntent().getSerializableExtra("book", Book.class);
        }else{
            book = (Book) getIntent().getSerializableExtra("book");
        }

        if(book != null){
            title.setText(book.getTitle());
            author.setText(book.getAuthor());
            publisher.setText(book.getPublisher());
            year.setText(book.getYear());
            price.setText(book.getPrice());
            Glide.with(this)
                    .load(book.getImage())
                    .centerCrop()
                    .into(image);
        }

        btn.setOnClickListener(v-> {
            BookController.addToCart(book);
            Toast.makeText(this, "Added to cart", Toast.LENGTH_LONG).show();
        });


    }
}