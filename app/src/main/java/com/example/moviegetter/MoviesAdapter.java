package com.example.moviegetter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    Context ctx;
    List<Movies> moviesList;
    RecyclerView rvMovies;
    final View.OnClickListener onClickListener = new OnClickListener();
    public static class ViewHolder extends  RecyclerView.ViewHolder{
        TextView rowID;
        TextView rowTitle;
        TextView rowYear;
        TextView rowDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowID = itemView.findViewById(R.id.movie_id);
            rowTitle = itemView.findViewById(R.id.movie_title);
            rowYear = itemView.findViewById(R.id.movie_year);
            rowDescription = itemView.findViewById(R.id.movie_description);
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
        holder.rowID.setText(""+movie.getId());
        holder.rowYear.setText(""+movie.getYear());
        holder.rowTitle.setText(""+movie.getTitle());
        holder.rowDescription.setText(""+movie.getDescription());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    private class OnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int itemPosition = rvMovies.getChildLayoutPosition(view);
            long item = moviesList.get(itemPosition).getId();
            /// navigate to new page and display same info, but with the description
        }
    }
}
