package edrd.explore.config

import edrd.explore.Server
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import org.postgresql.ds.PGSimpleDataSource

class Module(config: Config) {
  private val dataSource = PGSimpleDataSource().apply {
    setUrl(config.databaseUrl)
    user = config.databaseUser
    password = config.databasePassword
  }

  private val dslContext: DSLContext = DSL.using(dataSource, SQLDialect.POSTGRES)

  val server by lazy {
    Server(database = dslContext)
  }
}
