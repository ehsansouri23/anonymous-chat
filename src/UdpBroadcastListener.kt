import tcp.TcpServer
import java.net.DatagramPacket
import java.net.DatagramSocket
import kotlin.random.Random

class UdpBroadcastListener : Thread("UdpBroadcastListener") {
    private val socket = DatagramSocket(broadcastPort)
    private val buffer = ByteArray(1024)
    private val packet = DatagramPacket(buffer, buffer.size)
    override fun run() {
        println("Waiting for broadcaster ...")
        socket.receive(packet)
        val message = String(buffer)
        println(message)
        val m = Random.nextInt(1024, 65000).toString()
        val sendPacket = DatagramPacket(m.toByteArray(), m.toByteArray().size, packet.address, udpAcceptPort)
        socket.send(sendPacket) //send accept message when receiving udp broadcast
        socket.close()
        TcpServer(port).start()
        println("Stop listening to broadcasts")
    }
}