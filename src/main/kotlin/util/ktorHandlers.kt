package edrd.explore.util

import edrd.explore.handler.Handler
import io.ktor.application.call
import io.ktor.routing.Routing
import io.ktor.routing.post

fun Routing.post(path: String, handler: Handler) {
  post(path) { handler.handle(call) }
}
