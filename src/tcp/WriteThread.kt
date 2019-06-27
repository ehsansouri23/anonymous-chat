package tcp

import java.io.PrintWriter
import java.net.Socket

class WriteThread(private val socket: Socket) : Thread("tcp.WriteThread") {
    private val writer = PrintWriter(socket.getOutputStream(), true)

    override fun run() {
        println("Start Write Thread")
        while (true) {
            print("> ")
            val message = readLine()
            writer.println(message)
        }
    }
}