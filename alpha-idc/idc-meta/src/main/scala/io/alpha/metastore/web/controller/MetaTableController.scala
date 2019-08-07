package io.alpha.metastore.web.controller

import io.alpha.metastore.support.Response
import io.alpha.metastore.web.domain.MetaTable
import io.alpha.metastore.web.service.MetaTableService
import org.ko.metastore.support.Response
import org.ko.metastore.web.domain.MetaTable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("/meta/table"))
class MetaTableController @Autowired()(metaTableService: MetaTableService) {

  @PostMapping
  def save (@ModelAttribute metaTable: MetaTable): Unit = {
    metaTableService.save(metaTable)
    new Response[String](true)
  }

  @GetMapping
  def query(): Unit = {
    new Response[Iterable[MetaTable]](metaTableService.query())
  }




}
