package io.alpha.metastore.web.service

import io.alpha.metastore.web.domain.MetaTable

trait MetaTableService {

  def save(metaTable: MetaTable)

  def query(): Iterable[MetaTable]

}
