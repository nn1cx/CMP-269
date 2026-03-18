sealed class EnrollmentStatus {
    class Success(val courseCode: String) : EnrollmentStatus()
    class Error(val message: String) : EnrollmentStatus()
    class Loading : EnrollmentStatus()
}

fun printStatus(status: EnrollmentStatus) {
    when (status) {
        is EnrollmentStatus.Success -> println("Enrollment in ${status.courseCode} was successful")
        is EnrollmentStatus.Error -> println("Enrollment failed: ${status.message}")
        is EnrollmentStatus.Loading -> println("Enrollment still processing")
    }
}

fun main() {
    val classCode : String = "CMP269"
    val success = EnrollmentStatus.Success(classCode)
    val error = EnrollmentStatus.Error("$classCode is full")
    val loading = EnrollmentStatus.Loading()

    printStatus(success)
    printStatus(error)
}
