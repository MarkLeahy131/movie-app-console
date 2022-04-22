import java.util.*

val scanner = Scanner(System.`in`)

fun runMenu() {
    do {
        val option = mainMenu()
        when (option) {
            1  -> selectGenre()
            2  -> selectDirector()
            3  -> selectDuration()
            4  -> giveRating()
            0  -> exitApp()
            else -> System.out.println("Invalid option entered: " + option)
        }
    } while (true)
}

fun mainMenu() : Int {
    println("")
    println("--------------------")
    println("NOTE KEEPER APP")
    println("--------------------")
    println("NOTE MENU")
    println("  1) Select a Genre")
    println("  2) Select a Director")
    println("  3) Select a Duration")
    println("  4) Give a Rating")
    println("--------------------")
    println("  0) Exit")
    println("--------------------")
    print("==>> ")
    return scanner.nextInt()
}
fun addNote(){
    println("You chose Add Note")
}

fun listNotes(){
    println("You chose List Notes")
}

fun updateNote(){
    println("You chose Update Note")
}

fun deleteNote(){
    println("You chose Delete Note")
}

fun exitApp(){
    println("Exiting...bye")
    exit(0)
}