package com.genshin.genshinrolls.repository;

import com.genshin.genshinrolls.entity.CardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<CardEntity, Long> {
}
