package io.alpha.metastore.web.controller

import org.springframework.web.bind.annotation.{GetMapping, RestController}


@RestController
class ScalaHelloBoot {

  @GetMapping(Array("/sayScalaHello"))
  def sayScalaHello (): String = {
    "Hello, Scala boot..."
  }

}
