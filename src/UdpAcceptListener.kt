import tcp.TcpClient
import java.net.DatagramPacket
import java.net.DatagramSocket

const val udpAcceptPort = 5000


/**
 * listening for accept of broadcasted udp message
 */
class UdpAcceptListener : Thread("UdpAcceptListener") {
    private val socket = DatagramSocket(udpAcceptPort)
    override fun run() {
        println("Listening for accept message...")
        val bytes = ByteArray(512)
        val packet = DatagramPacket(bytes, bytes.size)
        socket.receive(packet)
        address = packet.address
        port = String(bytes, 0, packet.length).toInt()//todo put a random port
        println("---------------------")
        stopBroadcasting()
        sleep(2000)
        TcpClient(port).start()
    }
}