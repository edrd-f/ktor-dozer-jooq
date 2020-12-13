package edrd.explore.util

import com.fasterxml.jackson.module.kotlin.convertValue
import edrd.explore.data.HasuraActionRequest
import io.ktor.application.ApplicationCall
import io.ktor.request.receive

suspend inline fun <reified T : Any> getHasuraActionRequest(
  applicationCall: ApplicationCall
): HasuraActionRequest<T> {
  return applicationCall.receive<HasuraActionRequest<T>>().let { request ->
    request.copy(input = defaultObjectMapper.convertValue(request.input))
  }
}
