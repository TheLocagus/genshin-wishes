package com.genshin.genshinrolls.service.CardService;

import com.genshin.genshinrolls.entity.Card.CardEntity;
import java.util.ArrayList;

public interface CardService {

    CardEntity getOne(Long id);

    ArrayList<CardEntity> getAll();

    ArrayList<CardEntity> getTen();

    CardEntity save(CardEntity card);

    CardEntity update(CardEntity card, Long id);

    CardEntity delete(Long id);
}
