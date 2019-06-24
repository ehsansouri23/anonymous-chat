import java.io.DataOutputStream
import java.net.Socket
import java.util.*

class TcpClient : Thread("TcpClient") {
    private val socket = Socket(address, port)

    override fun run() {
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