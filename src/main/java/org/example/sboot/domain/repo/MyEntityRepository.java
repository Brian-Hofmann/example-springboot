package org.example.sboot.domain.repo;

import io.ebean.DB;
import org.example.sboot.domain.MyEntity;
import org.springframework.stereotype.Repository;

@Repository
public class MyEntityRepository {

    public MyEntity save(MyEntity entity) {
        DB.save(entity);
        return entity;
    }

}
