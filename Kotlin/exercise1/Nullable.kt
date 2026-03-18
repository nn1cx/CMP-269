fun main() {
    val studentName: String = "Judd"
    val middleName: String? = null
    var noMiddleName = middleName?: "No Middle Name"

    println("Welcome, $studentName $noMiddleName")
}
