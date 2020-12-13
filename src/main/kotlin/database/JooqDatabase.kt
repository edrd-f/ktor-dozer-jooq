package edrd.explore.database

import org.jooq.DSLContext
import org.jooq.UpdatableRecord

class JooqDatabase(private val dslContext: DSLContext) : Database {
  override fun store(record: UpdatableRecord<*>) {
    dslContext.attach(record)
    record.store()
  }
}
