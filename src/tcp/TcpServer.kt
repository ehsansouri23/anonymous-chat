package tcp

import java.net.ServerSocket

class TcpServer(private val port: Int) : Thread("tcp.TcpServer") {

    override fun run() {
        println("Establishing server on port $port")
        val serverSocket = ServerSocket(port)
        val socket = serverSocket.accept();
        println("Socket accepted")
        WriteThread(socket).start()
        ReadThread(socket).start()
    }
}