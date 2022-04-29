package controllers

import models.Movie

class MovieAPI {

    private var movies = ArrayList<Movie>()

    fun add(movie: Movie): Boolean {
        return movies.add(movie)
    }

    fun listAllMovies(): String {
        return if (movies.isEmpty()) {
            "No notes stored"
        } else {
            var listOfMovies = ""
            for (i in movies.indices) {
                listOfMovies += "${i}: ${movies[i]} \n"
            }
            listOfMovies
        }
    }

    fun listAllMoviesByGenre(genre:String): String {
        return if (movies.isEmpty()) {
            "No movies stored"
        } else {
            var listOfMovies = ""
            for (i in movies.indices) {
                if(movies[i].movieGenre.equals(genre))
                    listOfMovies += "${i}: ${movies[i]} \n"
            }
            listOfMovies
        }
    }



}