package com.genshin.genshinrolls.interfaces;

import com.genshin.genshinrolls.enums.Rarity;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public interface Roll<T> {
    T roll(ArrayList<T> cardsWithRarityThree,
                           ArrayList<T> cardsWithRarityFour,
                           ArrayList<T> cardsWithRarityFive,
                           Set<Map.Entry<Rarity, Double>> raritySetSorted
    );
    Set<Map.Entry<Rarity, Double>> getRaritySetSorted(
            ArrayList<T> cardsWithRarityThree,
            ArrayList<T> cardsWithRarityFour,
            ArrayList<T> cardsWithRarityFive
    );
    ArrayList<T> getCardsDividedByRarity(Rarity rarity, ArrayList<T> allCards);
    ArrayList<T> getTen(ArrayList<T> allCards);
}
