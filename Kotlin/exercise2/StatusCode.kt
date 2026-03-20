fun describeStatus(code: Int) : String {
    return when (code) {
        in 200..299 -> "Success: Your request was fulfilled."
        in 400..499 -> "Client Error: Check your URL or parameters."
        in 500..599 -> "The Lehman Server is having trouble."
        else -> "Unknown status code"
    }
}

fun main() {
    val code1 = 201
    val status1 = describeStatus(code1)
    println("Status code $code1 - $status1")

    val code2 = 404
    val status2 = describeStatus(code2)
    println("Status code $code2 - $status2")

    val code3 = 503
    val status3 = describeStatus(code3)
    println("Status code $code3 - $status3")
}
