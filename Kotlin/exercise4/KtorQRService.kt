import io.ktor.server.routing.*
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.common.BitMatrix
import io.ktor.http.HttpHeaders
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import java.io.ByteArrayOutputStream
import java.nio.file.Paths


fun saveQRCode(content: String, fileName: String) {
    val matrix = QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, 512, 512)
    val path = Paths.get(fileName)
    MatrixToImageWriter.writeToPath(matrix,"PNG",path)
}


fun Application.configureRouting() {
    routing {
        get("/qr") {
            val text = call.request.queryParameters["text"]
            if (text != null) {
                val matrix = QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, 512, 512)
                call.response.header(HttpHeaders.ContentType, "image/png")
                val outputStream = ByteArrayOutputStream()
                MatrixToImageWriter.writeToStream(matrix,"PNG", outputStream)
                call.respond(outputStream.toByteArray())
            }
        }
    }
}

fun main() {
    embeddedServer(Netty, 8080) {
        configureRouting()
    }.start(wait = true)
}
