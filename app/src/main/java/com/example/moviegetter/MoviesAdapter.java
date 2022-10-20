package com.example.moviegetter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    Context ctx;
    List<Movies> moviesList;
    RecyclerView rvMovies;
    final View.OnClickListener onClickListener = new OnClickListener();
    public static class ViewHolder extends  RecyclerView.ViewHolder{
        TextView id;
        TextView title;
        TextView year;
        TextView description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.movie_id);
            title = itemView.findViewById(R.id.movie_title);
            year = itemView.findViewById(R.id.movie_year);
        }
    }

    public MoviesAdapter(Context ctx, List<Movies> moviesList, RecyclerView rvMovies){
        this.ctx = ctx;
        this.moviesList = moviesList;
        this.rvMovies = rvMovies;
    }

    @NonNull
    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.movie_item, parent, false);
        view.setOnClickListener(onClickListener);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.ViewHolder holder, int position) {
        Movies movie = moviesList.get(position);
        holder.id.setText(""+movie.getId());
        holder.title.setText(""+movie.getYear());
        holder.year.setText(""+movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


    private class OnClickListener extends AppCompatActivity implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int itemPosition = rvMovies.getChildLayoutPosition(view);
            long year = moviesList.get(itemPosition).getYear();
            String title = moviesList.get(itemPosition).getTitle();
            String description = moviesList.get(itemPosition).getDescription();

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            bundle.putString("year", String.valueOf(year));
            bundle.putString("description", description);
            
            MovieFragment movieFragment = new MovieFragment();
            movieFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.mainFrameLayout, movieFragment).commit();

            //fragmentTransaction.replace(R.id.mainFrameLayout, movieFragment).commit();
        }
    }
}
