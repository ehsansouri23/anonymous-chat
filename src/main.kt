import java.util.*

val timer = Timer()

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