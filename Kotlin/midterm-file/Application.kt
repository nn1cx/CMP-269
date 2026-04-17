package com.example

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.http.content.*
import kotlinx.serialization.Serializable
import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import java.io.ByteArrayOutputStream
import java.util.concurrent.ConcurrentHashMap

// 1. DATA MODELING (Kotlin Fundamentals)
@Serializable
data class Student(
    val id: String,
    val name: String,
    val major: String?, // Nullable as per requirements
    val accessLevel: Int
)

fun main() {
    // 2. THREAD-SAFE DATABASE
    val studentDb = ConcurrentHashMap<String, Student>().apply {
        put("12345", Student("12345", "Alice Smith", "Computer Science", 5))
        put("67890", Student("67890", "Bob Jones", null, 3)) // Will test Elvis operator
    }

    embeddedServer(Netty, port = 8080) {
      module(studentDb)
    }.start(wait = true)
}

fun Application.module(studentDb: ConcurrentHashMap<String, Student>) {

    // 3. CONTENT NEGOTIATION (JSON API)
    install(ContentNegotiation) {
        json()
    }

    routing {
        // A. STATIC PORTAL
        staticResources("/", "static")

        // B. STUDENT API (Path Parameters & Null Safety)
        get("/api/student/{id}") {
            val id = call.parameters["id"] ?: return@get call.respond(HttpStatusCode.BadRequest, "Missing student ID")
            val student = studentDb[id] ?: return@get call.respond(HttpStatusCode.NotFound, "Student with id $id not found")
            call.respond(student)
          // NOT IMPLEMENTED:
          // This endpoint would retrieve student information based on the ID provided in the path parameter.
          // It would demonstrate null safety by using the Elvis operator to handle cases where the major is null.
          // Example response:
          // {
            // "id": "12345",
            // "name": "Alice Smith",
            // "major": "Computer Science",
            // "accessLevel": 5
          // }
           //call.respond(HttpStatusCode.NotImplemented, "Student API not implemented yet.")
        }

        // C. QR GENERATOR (Query Parameters & Image Response)
        get("/generate-id") {
            val sid = call.request.queryParameters["sid"]
            if (sid != null) {
                val matrix = QRCodeWriter().encode(sid, BarcodeFormat.QR_CODE, 600, 600)
                call.response.header(HttpHeaders.ContentType, "image/png")
                val outputStream = ByteArrayOutputStream()
                MatrixToImageWriter.writeToStream(matrix, "PNG", outputStream)
                call.respond(outputStream.toByteArray())
            }
          // NOT IMPLEMENTED: 
          //
          // This endpoint would generate a QR code for the student ID, 
          // demonstrating query parameters and image response handling.
          // Example usage: 
          // 1. Visit: http://localhost:8080/
          // 2. Enter a student ID in the input field and click "Generate Digital ID".
           //call.respond(HttpStatusCode.NotImplemented, "Generate Digital ID not implemented yet.")
        }
    }
}
