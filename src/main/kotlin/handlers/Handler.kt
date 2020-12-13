package edrd.explore.handlers

import io.ktor.application.ApplicationCall
import io.ktor.util.pipeline.PipelineContext

interface Handler {
  suspend fun PipelineContext<Unit, ApplicationCall>.handle()
}
