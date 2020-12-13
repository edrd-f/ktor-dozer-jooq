package edrd.explore.database

import org.jooq.UpdatableRecord

interface Database {
  fun store(record: UpdatableRecord<*>)
}
