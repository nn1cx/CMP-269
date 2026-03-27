package com.example

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/grade/{studentId}") {
            val grades = mapOf("123" to 95, "456" to 82)
            val studentId = call.parameters["studentId"]
            val grade = grades[studentId]

            if (grade != null) {
                call.respondText("Student $studentId: $grade")
            }
            else {
                call.respond(HttpStatusCode.NotFound, "Student not found")
            }
        }
    }
}

fun main() {
    embeddedServer(Netty, 8080) {
        configureRouting()
    }.start(wait = true)
}
