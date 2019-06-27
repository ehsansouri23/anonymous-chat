package tcp

import address
import java.net.Socket

class TcpClient(private val port: Int) : Thread("tcp.TcpClient") {

    override fun run() {
        println("Connecting to $address and port $port")
        val socket = Socket(address, port)
        WriteThread(socket).start()
        ReadThread(socket).start()
    }
}