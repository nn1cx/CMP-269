import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.client.j2se.MatrixToImageWriter
import java.nio.file.Paths

fun saveQRCode(content: String, fileName: String) {
    val matrix = QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, 512, 512)
    val path = Paths.get(fileName)
    MatrixToImageWriter.writeToPath(matrix,"PNG",path)
}

fun main() {
    val email = "judd.allen@lc.cuny.edu"
    saveQRCode(email, "my_email.png")
}
