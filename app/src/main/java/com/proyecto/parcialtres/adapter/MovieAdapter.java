package com.proyecto.parcialtres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.parcialtres.R;
import com.proyecto.parcialtres.bean.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<Movie> mMovie;
    private Context context;

    public MovieAdapter(List<Movie> mMovie) {
        this.mMovie = mMovie;
    }

    public void reloadData(List<Movie> movies) {
        this.mMovie = movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(this.context);

        View contactView = inflater.inflate(R.layout.movie_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mMovie.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

       private ImageView poster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.image_poster);





        }


    }
}



