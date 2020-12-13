package edrd.explore

import edrd.explore.config.DevelopmentConfig
import edrd.explore.config.Module
import org.slf4j.LoggerFactory

fun main() {
  logger.info("Starting")

  val module = Module(DevelopmentConfig)

  module.server.start()
}

private val logger = LoggerFactory.getLogger("main")
