fun main (){
    val studentName: String = "Judd"
    val middleName: String? = null

    println("Welcome, $studentName " + (middleName ?: "No Middle Name"))
}
