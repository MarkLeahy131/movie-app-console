import utils.ScannerInput
import java.lang.System.exit



fun main(args: Array<String>) {
    runMenu()
}

fun runMenu() {
    do {
        val option = mainMenu()
        when (option) {
            1  -> selectGenre()
            2  -> selectDirector()
            3  -> selectDuration()
            4  -> giveRating()
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
         > |   1) Select a Genre            |
         > |   2) Select a Director         |
         > |   3) Select a Duration         |
         > |   4) Give a a Rating           |
         > ----------------------------------
         > |   0) Exit                      |
         > ----------------------------------
         > ==>> """.trimMargin(">"))
}

fun selectGenre(){
    println("You chose Add Note")
}

fun selectDirector(){
    println("You chose List Notes")
}

fun selectDuration(){
    println("You chose Update Note")
}

fun giveRating(){
    println("You chose Delete Note")
}

fun exitApp(){
    println("Exiting...bye")
    exit(0)
}