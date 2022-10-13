package com.proyecto.parcialtres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.proyecto.parcialtres.R;
import com.proyecto.parcialtres.bean.Movie;
import com.proyecto.parcialtres.bean.MovieIndividual;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<MovieIndividual> mMovie;
    private Context context;

    public MovieAdapter(List<MovieIndividual> mMovie) {
        this.mMovie = mMovie;
    }

    public void reloadData(List<MovieIndividual> movies) {
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
        MovieIndividual movie = mMovie.get(position);
        holder.title.setText(movie.title);
        holder.year.setText(movie.year);
        holder.runtime.setText(movie.runtime);
        String generos = "";
        for (String x:
             movie.genres) {
            generos += x +", ";

        }
        holder.genres.setText(generos);
        holder.director.setText(movie.director);
        holder.actors.setText(movie.actors);
        holder.plot.setText(movie.plot);

        Glide.with(this.context).load(movie.posterUrl).into(holder.poster);

    }

    @Override
    public int getItemCount() {
        return mMovie.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView poster;
        private TextView title;
        private TextView year;
        private TextView runtime;
        private TextView genres;
        private TextView director;
        private TextView actors;
        private TextView plot;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.image_poster);
            title = itemView.findViewById(R.id.title);
            year = itemView.findViewById(R.id.year);
            runtime = itemView.findViewById(R.id.runtime);
            genres = itemView.findViewById(R.id.genres);
            director = itemView.findViewById(R.id.director);
            actors = itemView.findViewById(R.id.actors);
            plot = itemView.findViewById(R.id.plot);







        }


    }
}



