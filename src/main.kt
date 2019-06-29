import java.net.InetAddress
import java.util.*

val timer = Timer()
lateinit var address: InetAddress
var port = 0

fun main(args: Array<String>) {
    if (args.contains("-b")) {
        val broadcastTask = BroadcastTask()
        timer.schedule(broadcastTask, 0, 2000)
        UdpAcceptListener().start()
    } else if (args.contains("-l")) {
        UdpBroadcastListener().start()
    }
}

fun stopBroadcasting() {
    timer.cancel()
}