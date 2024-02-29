package com.genshin.genshinrolls.service.EverbloomVioletService;

import com.genshin.genshinrolls.entity.Card.CardEntity;
import com.genshin.genshinrolls.entity.Events.EverbloomViolet.EverbloomVioletEntity;
import com.genshin.genshinrolls.service.CardService.CardService;

import java.util.ArrayList;

public interface EverbloomVioletService {

    EverbloomVioletEntity getOne(Long id);

    ArrayList<EverbloomVioletEntity> getAll();

    ArrayList<EverbloomVioletEntity> getTen();

    EverbloomVioletEntity save(EverbloomVioletEntity card);

    EverbloomVioletEntity update(EverbloomVioletEntity card, Long id);

    EverbloomVioletEntity delete(Long id);
}
