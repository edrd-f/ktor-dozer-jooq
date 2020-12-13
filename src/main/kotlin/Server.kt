package edrd.explore

import edrd.explore.handlers.CreateLinkHandler
import edrd.explore.handlers.Handler
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import io.ktor.routing.Routing
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.jooq.DSLContext

class Server(private val database: DSLContext) {
  private val server = embeddedServer(Netty, port = 8888) {
    install(ContentNegotiation) {
      jackson()
    }

    routing {
      post("/links", CreateLinkHandler(database))
    }
  }

  private fun Routing.post(path: String, handler: Handler) {
    post(path) {
      with(handler) { handle() }
    }
  }

  fun start() = server.start(wait = true)
}
