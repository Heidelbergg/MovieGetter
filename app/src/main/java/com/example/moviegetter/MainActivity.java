package com.example.moviegetter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DBAdapter dbAdapter;
    RecyclerView rvMovies;
    MoviesAdapter moviesAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Movies> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PopulateDB.copyDB(this);
        dbAdapter = new DBAdapter(this);
        movieList = dbAdapter.getAllMovies();
        rvMovies = findViewById(R.id.rvMovies);
        layoutManager = new LinearLayoutManager(this);
        rvMovies.setLayoutManager(layoutManager);
        moviesAdapter = new MoviesAdapter(this, movieList, rvMovies);
        rvMovies.setAdapter(moviesAdapter);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.mainFrameLayout, MovieFragment.class, null)
                .setReorderingAllowed(true)
                .commit();
    }
}