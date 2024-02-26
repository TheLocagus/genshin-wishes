package com.genshin.genshinrolls.interfaces;

import com.genshin.genshinrolls.entity.Card.CardEntity;
import com.genshin.genshinrolls.enums.Rarity;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public interface Roll {
    CardEntity roll(ArrayList<CardEntity> cardsWithRarityThree,
                           ArrayList<CardEntity> cardsWithRarityFour,
                           ArrayList<CardEntity> cardsWithRarityFive,
                           Set<Map.Entry<Rarity, Double>> raritySetSorted
    );
    Set<Map.Entry<Rarity, Double>> getRaritySetSorted(
            ArrayList<CardEntity> cardsWithRarityThree,
            ArrayList<CardEntity> cardsWithRarityFour,
            ArrayList<CardEntity> cardsWithRarityFive
    );
    ArrayList<CardEntity> getCardsDividedByRarity(Rarity rarity, ArrayList<CardEntity> allCards);
    CardEntity[] getTen(ArrayList<CardEntity> allCards);
}
