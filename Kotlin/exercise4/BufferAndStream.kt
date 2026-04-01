import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.client.j2se.MatrixToImageWriter
import java.io.ByteArrayOutputStream

fun saveQRCode(content: String) : ByteArrayOutputStream  {
    val matrix = QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, 512, 512)
    val outputStream = ByteArrayOutputStream()

    MatrixToImageWriter.writeToStream(matrix, "PNG", outputStream)
    return outputStream
}

fun main() {
    val email = "judd.allen@lc.cuny.edu"
    saveQRCode(email)
}
