package controllers


import models.Movie
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import persistence.XMLSerializer
import java.io.File

import kotlin.test.assertEquals

class MovieAPITest {
    private var learnKotlin: Movie? = null
    private var summerHoliday: Movie? = null
    private var codeApp: Movie? = null
    private var testApp: Movie? = null
    private var swim: Movie? = null
    private var populatedMovies: MovieAPI? = MovieAPI(XMLSerializer(File("movies.xml")))
    private var emptyMovies: MovieAPI? = MovieAPI(XMLSerializer(File("movies.xml")))

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
        @Nested
        inner class PersistenceTests {

            @Test
            fun `saving and loading an empty collection in XML doesn't crash app`() {
                // Saving an empty notes.XML file.
                val storingMovies = MovieAPI(XMLSerializer(File("movies.xml")))
                storingMovies.store()

                //Loading the empty notes.xml file into a new object
                val loadedMovies = MovieAPI(XMLSerializer(File("notes.xml")))
                loadedMovies.load()

                //Comparing the source of the notes (storingNotes) with the XML loaded notes (loadedNotes)
                assertEquals(0, storingMovies.numberOfMovies())
                assertEquals(0, loadedMovies.numberOfMovies())
                assertEquals(storingMovies.numberOfMovies(), loadedMovies.numberOfMovies())
            }

            @Test
            fun `saving and loading and loaded collection in XML doesn't loose data`() {
                // Storing 3 notes to the movies.XML file.
                val storingMovies = MovieAPI(XMLSerializer(File("movies.xml")))
                storingMovies.add(testApp!!)
                storingMovies.add(swim!!)
                storingMovies.add(summerHoliday!!)
                storingMovies.store()

                //Loading movies.xml into a different collection
                val loadedMovie = MovieAPI(XMLSerializer(File("movies.xml")))
                loadedMovie.load()

                //Comparing the source of the notes (storingMovies) with the XML loaded notes (loadedNotes)
                assertEquals(3, storingMovies.numberOfMovies())
                assertEquals(3, loadedMovie.numberOfMovies())
                assertEquals(storingMovies.numberOfMovies(), loadedMovie.numberOfMovies())
                assertEquals(storingMovies.findMovie(0), loadedMovie.findMovie(0))
                assertEquals(storingMovies.findMovie(1), loadedMovie.findMovie(1))
                assertEquals(storingMovies.findMovie(2), loadedMovie.findMovie(2))
            }
        }
    }
}




