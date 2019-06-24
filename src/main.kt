import java.util.*

val timer = Timer()

fun main() {
    val broadcastTask = BroadcastTask()
    timer.schedule(broadcastTask, 0, 2000)
    UdpListener().start()
}

fun stopBroadcasting() {
    timer.cancel()
}