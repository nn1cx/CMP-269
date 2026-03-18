data class Laptop(val brand: String, val ramGB: Int)

fun Int.toLehmanStandard(): String {
    if (this == 16) return "16 GB (Lehman Standard)"
    else if (this > 16) return "$this GB (exceeds Lehman Standard)"
    else return "$this GB (below Lehman Standard)"
}

fun main() {
    val laptop1 = Laptop("Lenovo", 16)
    val laptop2 = Laptop("ASUS", 12)

    println("${laptop1.ramGB.toLehmanStandard()}")
    println("${laptop2.ramGB.toLehmanStandard()}")
}
