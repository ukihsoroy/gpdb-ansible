package io.alpha.metastore.web.service;

import io.alpha.metastore.web.domain.MetaDatabase;

public interface MetaDatabaseService {

    void save (MetaDatabase metaDatabase);

    Iterable<MetaDatabase> query();


}
