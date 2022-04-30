import controllers.MovieAPI
import models.Movie
import mu.KotlinLogging
import utils.ScannerInput
import utils.ScannerInput.readNextDouble
import utils.ScannerInput.readNextInt
import utils.ScannerInput.readNextLine
import java.lang.System.exit

private val logger = KotlinLogging.logger {}
private var movieAPI = MovieAPI()


fun main(args: Array<String>) {
    runMenu()
}

fun runMenu() {
    do {
        val option = mainMenu()
        when (option) {
            1  -> addMovie()
            2  -> listMovies()
            3  -> selectGenre()
            4  -> selectDuration()
            5  -> giveRating()
            0  -> exitApp()
            else -> System.out.println("Invalid option entered: ${option}")
        }
    } while (true)
}

fun mainMenu() : Int {
    return ScannerInput.readNextInt(""" 
         > ----------------------------------
         > |        NOTE KEEPER APP         |
         > ----------------------------------
         > | NOTE MENU                      |
         > |   1) Add Movie                 |
         > |   2) List Movies               |
         > |   3) Select a Genre            |
         > |   4) Select a Director         |
         > |   5) Select a Duration         |
         > |   6) Give a a Rating           |
         > ----------------------------------
         > |   0) Exit                      |
         > ----------------------------------
         > ==>> """.trimMargin(">"))
}

fun addMovie(){
    val movieGenre = readNextLine("Enter a genre for the movie: ")
    val movieName = readNextLine("Enter a name for the movie: ")
    val movieDirector = readNextLine("Enter a director for the movie: ")
    val movieDur = readNextInt("Enter a length (mins) for the movie: ")
    val movieR = readNextDouble("Enter a rating for the movie: ")
    val isAdd = movieAPI.add(Movie(movieGenre, movieName, movieDirector, movieDur, movieR))

}
fun listMovies(){
    print(movieAPI.listAllMovies())
}
fun selectGenre(){
    //logger.info { "addNote() function invoked" }
    val movieGenre = readNextLine("Enter a genre to check for: ")
    print(movieAPI.listAllMoviesByGenre(movieGenre))
}

fun selectDirector(){
    //logger.info { "Select a Director" }
    val movieDirector= readNextLine("Enter a genre to check for: ")
    print(movieAPI.listAllMoviesByDirector(movieDirector))
}

fun selectDuration(){
    logger.info { "Select a Duration" }
}

fun giveRating(){
    logger.info { "Give a Rating" }
}

fun exitApp(){
    logger.info { "Exit" }
    exit(0)
}