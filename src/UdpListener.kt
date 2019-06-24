import java.net.DatagramPacket
import java.net.DatagramSocket

const val udpAcceptPort = 5000

class UdpListener : Thread() {
    private val socket = DatagramSocket(udpAcceptPort)
    override fun run() {
        println("listening")
        val bytes = ByteArray(512)
        val packet = DatagramPacket(bytes, bytes.size)
        socket.receive(packet)
        println("Received ${String(bytes)}")
        println("---------------------")
        stopBroadcasting()
    }
}