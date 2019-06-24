import java.util.*

private const val broadcastMessage = "hello to you!!"

class BroadcastTask : TimerTask() {
    override fun run() {
        broadcastUdp(broadcastMessage)
    }

    override fun cancel(): Boolean {
        closeSocket()
        return super.cancel()
    }
}