package tcp

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket

class ReadThread(private val socket: Socket) : Thread("tcp.ReadThread") {
    private val reader = BufferedReader(InputStreamReader(socket.getInputStream()))

    override fun run() {
        println("Start Read Thread")
        while (true) {
            println("> ${reader.readLine()}")
        }
    }
}