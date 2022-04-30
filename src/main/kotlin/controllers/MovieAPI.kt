package controllers


import models.Movie
import persistence.Serializer
import persistence.XMLSerializer
import java.io.File



    class MovieAPI(serializerType: Serializer){

        private var serializer: Serializer = serializerType


    private var movies = ArrayList<Movie>()

    fun add(movie: Movie): Boolean {
        return movies.add(movie)
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
        fun listAllMoviesByDirector(director:String): String {
            return if (movies.isEmpty()) {
                "No movies stored"
            } else {
                var listOfMovies = ""
                for (i in movies.indices) {
                    if (movies[i].movieDirector.equals(director))
                        listOfMovies += "${i}: ${movies[i]} \n"
                }
                listOfMovies
            }
        }
            fun listAllMoviesByDuration(duration:String): String {
                return if (movies.isEmpty()) {
                    "No movies stored"
                } else {
                    var listOfMovies = ""
                    for (i in movies.indices) {
                        if (movies[i].movieDuration.equals(duration))
                            listOfMovies += "${i}: ${movies[i]} \n"
                    }
                    listOfMovies
                }

    }
    @Throws(Exception::class)
    fun load() {
        movies = serializer.read() as ArrayList<Movie>
    }

    @Throws(Exception::class)
    fun store() {
        serializer.write(movies)
    }
    }




