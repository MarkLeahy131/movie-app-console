package controllers

import models.Movie
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MovieAPITest {
    private var learnKotlin: Movie? = null
    private var summerHoliday: Movie? = null
    private var codeApp: Movie? = null
    private var testApp: Movie? = null
    private var swim: Movie? = null
    private var populatedMovies: MovieAPI? = MovieAPI()
    private var emptyMovies: MovieAPI? = MovieAPI()

    @BeforeEach
    fun setup(){
        learnKotlin = Movie("Horror", "Scream", "College", 100,4.1)
        summerHoliday = Movie("Comedy", "Jackass", "Holiday", 130,2.2)
        codeApp = Movie("Comedy", "Jackass 2", "Work", 115,3.2)
        testApp = Movie("Comedy", "Jackass 3", "Work", 130,2.1)
        swim = Movie("Sci-fi", "The Matrix", "Hobby", 1,1.1)

        //adding 5 Movies to the movies api
        populatedMovies!!.add(learnKotlin!!)
        populatedMovies!!.add(summerHoliday!!)
        populatedMovies!!.add(codeApp!!)
        populatedMovies!!.add(testApp!!)
        populatedMovies!!.add(swim!!)
    }

    @AfterEach
    fun tearDown(){
        learnKotlin = null
        summerHoliday = null
        codeApp = null
        testApp = null
        swim = null
        populatedMovies = null
        emptyMovies = null
    }

    @Test
    fun `adding a Note to a populated list adds to ArrayList`(){
        val newMovie = Movie("Romance", "The Notebook", "College", 120,movieRating = 2.5)
        assertTrue(populatedMovies!!.add(newMovie))
    }

    @Test
    fun `adding a Note to an empty list adds to ArrayList`(){
        val newNote = Movie("Action", "Rocky", "College", 112,2.3)
        assertTrue(emptyMovies!!.add(newNote))
    }
}
