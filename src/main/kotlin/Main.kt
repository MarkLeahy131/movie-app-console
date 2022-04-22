import java.util.*

val scanner = Scanner(System.`in`)

fun mainMenu() : Int {
    println("")
    println("--------------------")
    println("NOTE KEEPER APP")
    println("--------------------")
    println("NOTE MENU")
    println("  1) Add a note")
    println("  2) List all notes")
    println("  3) Update a note")
    println("  4) Delete a note")
    println("--------------------")
    println("  0) Exit")
    println("--------------------")
    print("==>> ")
    return scanner.nextInt()
}