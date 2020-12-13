package edrd.explore.util

fun json(vararg pairs: Pair<String, Any?>): String {
  return defaultObjectMapper.writeValueAsString(mapOf(*pairs))
}

