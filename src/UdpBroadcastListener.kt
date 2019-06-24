import java.net.DatagramPacket
import java.net.DatagramSocket
import kotlin.random.Random

class UdpBroadcastListener : Thread("UdpBroadcastListener") {
    val socket = DatagramSocket(broadcastPort)
    val buffer = ByteArray(1024)
    val packet = DatagramPacket(buffer, buffer.size)
    override fun run() {
        socket.receive(packet)
        val message = String(buffer)
        println(message)
        val m = Random.nextInt(1024, 65000).toString()
        val sendPacket = DatagramPacket(m.toByteArray(), m.toByteArray().size, packet.address, udpAcceptPort)
        socket.send(sendPacket) //send accept message when receiving udp broadcast
    }
}