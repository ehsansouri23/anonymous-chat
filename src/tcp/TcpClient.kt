package tcp

import address
import java.io.DataOutputStream
import java.net.Socket
import java.util.*

class TcpClient(private val port: Int) : Thread("tcp.TcpClient") {

    override fun run() {
        println("Connecting to $address and port $port")
        val socket = Socket(address, port)
        while (true) {
            val out = DataOutputStream(socket.getOutputStream())
            println("Sending tcp")
            val scanner = Scanner(System.`in`)
            val s = scanner.next()
            println("send $s")
            out.writeUTF(s)
        }
    }
}