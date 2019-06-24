import java.io.BufferedInputStream
import java.io.DataInputStream
import java.net.ServerSocket

class TcpServer : Thread("TcpServer") {
    val socket = ServerSocket(port)

    override fun run() {
        while (true) {
            val recievedSocket = socket.accept()
            val inputStream = DataInputStream(BufferedInputStream(recievedSocket.getInputStream()))
            println(inputStream.readLine())
        }
    }
}