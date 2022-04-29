package controllers

import com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length
import models.Movie
import sun.jvm.hotspot.runtime.BasicObjectLock.size
import java.nio.file.Files.size

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
                if (movies[i].movieGenre.equals(genre))
                    listOfMovies += "${i}: ${movies[i]} \n"
            }
            listOfMovies
        }
    }
    fun numberOfMovies(): Int {
        return movies.size
    }

        fun findMovie(index: Int): Movie? {
            return if (isValidListIndex(index, movies)) {
                movies[index]
            } else null
        }

        //utility method to determine if an index is valid in a list.
        fun isValidListIndex(index: Int, list: List<Any>): Boolean {
            return (index >= 0 && index < list.size)
        }
    }




