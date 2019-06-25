import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

const val udpAcceptPort = 5000
lateinit var address: InetAddress
var port = 0

/**
 * listening for accept of broadcasted udp message
 */
class UdpAcceptListener : Thread("UdpAcceptListener") {
    private val socket = DatagramSocket(udpAcceptPort)
    override fun run() {
        println("listening")
        val bytes = ByteArray(512)
        val packet = DatagramPacket(bytes, bytes.size)
        socket.receive(packet)
        address = packet.address
        port = String(bytes, 0, packet.length).toInt()
        println("Received ${String(bytes)}")
        println("---------------------")
        stopBroadcasting()
        TcpClient().start()
    }
}