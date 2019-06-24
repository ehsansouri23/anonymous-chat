import java.util.*

class BroadcastTask : TimerTask() {
    override fun run() {
        broadcastUdp("hello to you!!")
    }
}