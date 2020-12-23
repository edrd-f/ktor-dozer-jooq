package edrd.explore.database

import org.jooq.UpdatableRecord

interface Database {
  // TODO: oops. must abstract this too
  fun store(record: UpdatableRecord<*>)
}
