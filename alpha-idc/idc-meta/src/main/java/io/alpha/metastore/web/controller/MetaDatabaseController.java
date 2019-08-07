package io.alpha.metastore.web.controller;

import io.alpha.metastore.support.Response;
import io.alpha.metastore.support.Response;
import io.alpha.metastore.web.domain.MetaDatabase;
import io.alpha.metastore.web.service.MetaDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meta/database")
public class MetaDatabaseController {

    @Autowired
    private MetaDatabaseService metaDatabaseService;

    @PostMapping
    public Response save(@ModelAttribute MetaDatabase metaDatabase) {
        metaDatabaseService.save(metaDatabase);
        return new Response(true);
    }

    @GetMapping
    public Response<Iterable<MetaDatabase>> query() {
        return new Response<>(metaDatabaseService.query());
    }
}
