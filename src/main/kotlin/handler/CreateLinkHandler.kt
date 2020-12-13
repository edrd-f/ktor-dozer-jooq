package edrd.explore.handler

import edrd.explore.data.CreateLinkData
import edrd.explore.database.Database
import edrd.explore.util.getHasuraActionRequest
import edrd.explore.util.json
import edrd.explore.util.mapTo
import io.ktor.application.ApplicationCall
import io.ktor.http.ContentType
import io.ktor.response.respondText
import org.jooq.generated.tables.records.LinksRecord

class CreateLinkHandler(private val database: Database) : Handler {
  override suspend fun handle(call: ApplicationCall) {
    val request = getHasuraActionRequest<CreateLinkData>(call)

    val record = mapTo<LinksRecord>(request.input)

    database.store(record)

    call.respondText(json("id" to record.id), ContentType.Application.Json)
  }
}
