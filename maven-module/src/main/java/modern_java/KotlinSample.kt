package modern_java

fun main() {

    val str = "123"
    val obj = 3

    println("Hi")
    println(sum(1, 5))
    println(difference(num1 = 7))

    val res = listOf(1, 3, 4, 5)
        .filter { x -> x > 2 }
        .map { x -> x.toString() }

    println(res)
}

fun sum(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun difference(num1: Int, num2: Int = 0) = num1 - num2