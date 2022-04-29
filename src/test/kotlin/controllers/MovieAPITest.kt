package controllers


import models.Movie
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
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
    fun setup() {
        learnKotlin = Movie("Horror", "Scream", "College", 100, 4.1)
        summerHoliday = Movie("Comedy", "Jackass", "Holiday", 130, 2.2)
        codeApp = Movie("Comedy", "Jackass 2", "Work", 115, 3.2)
        testApp = Movie("Comedy", "Jackass 3", "Work", 130, 2.1)
        swim = Movie("Sci-fi", "The Matrix", "Hobby", 1, 1.1)

        //adding 5 Movies to the movies api
        populatedMovies!!.add(learnKotlin!!)
        populatedMovies!!.add(summerHoliday!!)
        populatedMovies!!.add(codeApp!!)
        populatedMovies!!.add(testApp!!)
        populatedMovies!!.add(swim!!)
    }

    @AfterEach
    fun tearDown() {
        learnKotlin = null
        summerHoliday = null
        codeApp = null
        testApp = null
        swim = null
        populatedMovies = null
        emptyMovies = null
    }

    @Nested
    inner class AddMovies {
        @Test
        fun `adding a Movie to a populated list adds to ArrayList`() {
            val newMovie = Movie("Action", "Justice League", "Liz", 100, 5.1)
            assertEquals(5, populatedMovies!!.numberOfMovies())
            assertTrue(populatedMovies!!.add(newMovie))
            assertEquals(6, populatedMovies!!.numberOfMovies())
            assertEquals(newMovie, populatedMovies!!.findMovie(populatedMovies!!.numberOfMovies() - 1))
        }

        @Test
        fun `adding a Movie to an empty list adds to ArrayList`() {
            val newMovie = Movie("Action", "James Bond", "Mark", 100, 3.3)
            assertEquals(0, emptyMovies!!.numberOfMovies())
            assertTrue(emptyMovies!!.add(newMovie))
            assertEquals(1, emptyMovies!!.numberOfMovies())
            assertEquals(newMovie, emptyMovies!!.findMovie(emptyMovies!!.numberOfMovies() - 1))
        }

        @Test
        fun `listAllMovies returns No Movies Stored message when ArrayList is empty`() {
            assertEquals(0, emptyMovies!!.numberOfMovies())
            assertTrue(emptyMovies!!.listAllMovies().lowercase().contains("no movies"))
        }

        @Nested
        inner class ListMovies {

            @Test
            fun `listAllMovies returns Movies when ArrayList has Movies stored`() {
                assertEquals(5, populatedMovies!!.numberOfMovies())
                val movieString = populatedMovies!!.listAllMovies().lowercase()
                assertTrue(movieString.contains("learning kotlin"))
                assertTrue(movieString.contains("code app"))
                assertTrue(movieString.contains("test app"))
                assertTrue(movieString.contains("swim"))
                assertTrue(movieString.contains("summer holiday"))
            }
        }
    }
}




