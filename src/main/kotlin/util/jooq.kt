package edrd.explore.util

import org.jooq.DSLContext
import org.jooq.UpdatableRecord

fun DSLContext.store(record: UpdatableRecord<*>) {
  this.attach(record)
  record.store()
}
