package com.genshin.genshinrolls.repository;

import com.genshin.genshinrolls.entity.Player.PlayerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayerRepository extends CrudRepository<PlayerEntity, Long> {
    Optional<PlayerEntity> findByName(String name);
}
