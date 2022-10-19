package com.example.moviegetter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DBAdapter dbAdapter;
    RecyclerView rvMovies;
    MoviesAdapter contactsAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Movies> movieList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}