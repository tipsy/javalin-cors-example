package app

import io.javalin.Javalin
import org.json.JSONObject
import java.util.*

fun main(args: Array<String>) {

    val corsApp = Javalin.create().apply {
        port(80)
        enableCorsForAllOrigins()
        enableDebugLogging()
        get("/") { ctx ->
            val res = JSONObject()
            res.put("version", "1.0.0")
            res.put("date", Date().toString())
            res.put("contact", "admin@domain.com")
            ctx.result(res.toString()).contentType("application/json")
        }
    }.start()

    val frontendApp = Javalin.create().apply {
        port(8081)
        enableStaticFiles("/public")
    }.start()

}
