package edrd.explore.handler

import io.ktor.application.ApplicationCall

interface Handler {
  suspend fun handle(call: ApplicationCall)
}
