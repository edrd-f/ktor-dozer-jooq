package edrd.explore.data

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class HasuraActionRequest<InputType>(
  val sessionVariables: Map<String, String?>,
  val input: InputType,
  val action: Action
)
