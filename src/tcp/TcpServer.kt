package tcp

import java.io.BufferedInputStream
import java.io.DataInputStream
import java.net.ServerSocket

class TcpServer(private val port: Int) : Thread("tcp.TcpServer") {

    override fun run() {
        println("Establishing server on port $port")
        val socket = ServerSocket(port)
        while (true) {
            val recievedSocket = socket.accept()
            val inputStream = DataInputStream(BufferedInputStream(recievedSocket.getInputStream()))
            println(inputStream.readLine())
        }
    }
}