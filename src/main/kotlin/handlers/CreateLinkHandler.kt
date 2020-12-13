package edrd.explore.handlers

import edrd.explore.data.CreateLinkData
import edrd.explore.util.getHasuraActionRequest
import edrd.explore.util.json
import edrd.explore.util.mapTo
import edrd.explore.util.store
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.util.pipeline.PipelineContext
import org.jooq.DSLContext
import org.jooq.generated.tables.records.LinksRecord

class CreateLinkHandler(private val database: DSLContext) : Handler {
  override suspend fun PipelineContext<Unit, ApplicationCall>.handle() {
    val request = getHasuraActionRequest<CreateLinkData>(call)

    val record = mapTo<LinksRecord>(request.input)

    database.store(record)

    call.respondText(json("id" to record.id), ContentType.Application.Json)
  }
}
