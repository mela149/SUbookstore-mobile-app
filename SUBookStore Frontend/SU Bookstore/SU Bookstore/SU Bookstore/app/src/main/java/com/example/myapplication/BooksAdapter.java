package com.example.myapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.NewsViewHolder> {
    private List<Book> bookList;
    private Context context;
    private OnItemClickListener onItemClickListener;


    public BooksAdapter(List<Book> bookList, Context context) {
        this.bookList = bookList;
        this.context = context;
    }


    void addNewBooks(List<Book> book){
        bookList = book;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_book_list_item, parent, false);
        return new NewsViewHolder(view);
    }


    public interface OnItemClickListener {
        void onItemClick(Book book);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }


    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.bind(book);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView titleTextView;
        private TextView authorTextView;
        private TextView tlTv;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            titleTextView = itemView.findViewById(R.id.title);
            tlTv = itemView.findViewById(R.id.tl);
            authorTextView = itemView.findViewById(R.id.author);

            itemView.setOnClickListener(v -> {
                if (onItemClickListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Book book = bookList.get(position);
                        onItemClickListener.onItemClick(book);
                    }
                }
            });
        }

        public void bind(Book book) {
            Glide.with(context)
                    .load(book.getImage())
                    .into(imageView);
            titleTextView.setText(book.getTitle());
            authorTextView.setText(book.getAuthor());
            tlTv.setText("$" + book.getPrice());
        }
    }
}
