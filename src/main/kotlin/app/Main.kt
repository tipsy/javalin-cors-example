package app

import io.javalin.Javalin
import org.json.JSONObject
import java.util.*

fun main(args: Array<String>) {

    Javalin.create().apply {
        enableCorsForAllOrigins()
        enableDebugLogging()
        get("/") { ctx ->
            val res = JSONObject()
            res.put("version", "1.0.0")
            res.put("date", Date().toString())
            res.put("contact", "admin@domain.com")
            ctx.result(res.toString()).contentType("application/json")
        }
    }.start(80)

    Javalin.create().apply {
        enableStaticFiles("/public")
    }.start(8081)

}
