package edrd.explore.util

import com.github.dozermapper.core.DozerBeanMapperBuilder
import com.github.dozermapper.core.Mapper

inline fun <reified T> mapTo(obj: Any): T {
  return dozerObjectMapper.map(obj, T::class.java)
}

val dozerObjectMapper: Mapper = DozerBeanMapperBuilder.buildDefault()
