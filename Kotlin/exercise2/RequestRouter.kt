fun routeRequest(path: String, user: String?) : String{
    return when (path) {
        "/home" -> "Welcome to the Lehman Homepage, ${user ?: "Guest"}!"
        "/grades" ->
            if (user == null) {
                "Error: Unauthorized access to grades."
            }
            else {
                "Loading grades for $user..."
            }
        else -> "404: Path $path not found."
    }
}

fun main(){
    val path1 = "/home"
    println(routeRequest(path1, "Judd"))
    println(routeRequest(path1, null))

    val path2 = "/grades"
    println(routeRequest(path2, "Judd"))
    println(routeRequest(path2, null))

    val path3 = "/desk"
    println(routeRequest(path3, null))
}
