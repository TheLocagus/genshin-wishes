package com.genshin.genshinrolls.repository;

import com.genshin.genshinrolls.entity.Card.CardEntity;
import com.genshin.genshinrolls.entity.Events.EverbloomViolet.EverbloomVioletEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EverbloomVioletRepository extends CrudRepository<EverbloomVioletEntity, Long> {
}
