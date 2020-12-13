package edrd.explore

import edrd.explore.database.Database
import edrd.explore.handler.CreateLinkHandler
import edrd.explore.util.post
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

class Server(private val database: Database) {
  private val server = embeddedServer(Netty, port = 8888) {
    install(ContentNegotiation) {
      jackson()
    }

    routing {
      post("/links", CreateLinkHandler(database))
    }
  }

  fun start() = server.start(wait = true)
}
