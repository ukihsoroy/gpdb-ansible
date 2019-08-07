package io.alpha.metastore.web.repository

import io.alpha.metastore.web.domain.MetaTable
import org.springframework.data.repository.CrudRepository

trait MetaTableRepository extends CrudRepository[MetaTable, Integer]{

}
