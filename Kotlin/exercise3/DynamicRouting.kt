package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/greet/{name}") {
            val name = call.parameters["name"]
            call.respondText("Hello, $name! Welcome to CMP 269.")
        }
    }
}

fun main() {
    embeddedServer(Netty, port = 8080) {
        configureRouting()
    }
}
