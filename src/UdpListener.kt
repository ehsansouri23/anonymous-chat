import java.net.DatagramPacket
import java.net.DatagramSocket

class UdpListener : Thread() {
    private val socket = DatagramSocket(5000)
    override fun run() {
        println("listening")
        val bytes = ByteArray(512)
        val packet = DatagramPacket(bytes, bytes.size)
        socket.receive(packet)
        println("Received ${String(bytes)}")
        println("---------------------")
    }
}