import java.util.*

val scanner = Scanner(System.`in`)

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