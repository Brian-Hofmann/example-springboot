package org.example.sboot.service;

import org.example.sboot.domain.MyEntity;
import org.example.sboot.domain.repo.MyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntityService {

    private final MyEntityRepository myEntityRepository;

    @Autowired
    public MyEntityService(MyEntityRepository myEntityRepository) {
        this.myEntityRepository = myEntityRepository;
    }

    public MyEntity saveEntity(MyEntity entityToSave) {
        return this.myEntityRepository.save(entityToSave);
    }

}
