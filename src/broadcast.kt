import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

fun broadcastUdp(message: String) {
    println("Broadcasting ($message) udp message...")
    val socket = DatagramSocket()
    socket.broadcast = true
    val bytes = message.toByteArray()
    val packet = DatagramPacket(bytes, bytes.size, InetAddress.getByName("255.255.255.255"), 4400)
    socket.send(packet)
}