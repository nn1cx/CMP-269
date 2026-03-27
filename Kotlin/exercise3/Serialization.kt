package com.example

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.http.content.*
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class Stock (val symbol: String, val price: Double)

fun Application.configureRouting() {
    install(ContentNegotiation) {
        json()
    }
    
    routing {
        get("/api/stock/{symbol}") {
            val symbol = call.parameters["symbol"]!!
            val stockObject = Stock(symbol, 150.25)
            call.respond(stockObject)
        }
    }
}

fun main() {
    embeddedServer(Netty, 8080) {
        configureRouting()
    }.start(wait = true)
}
