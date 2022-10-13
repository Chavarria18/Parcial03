package com.proyecto.parcialtres.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {


   @SerializedName("movies")
   public  List<MovieIndividual> mMovies;

   public Movie(List<MovieIndividual> mMovies) {
      this.mMovies = mMovies;
   }




}
