import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

val socket = DatagramSocket()
const val broadcastAddress = "255.255.255.255"
const val broadcastPort = 4400

fun broadcastUdp(message: String) {
    println("Broadcasting ($message) udp message...")
    socket.broadcast = true
    val bytes = message.toByteArray()
    val packet = DatagramPacket(bytes, bytes.size, InetAddress.getByName(broadcastAddress), broadcastPort)
    socket.send(packet)
}

fun closeSocket() {
    socket.close()
}