package com.genshin.genshinrolls;

import com.genshin.genshinrolls.entity.CardEntity;
import com.genshin.genshinrolls.enums.Rarity;
import com.genshin.genshinrolls.interfaces.Card;
import com.genshin.genshinrolls.interfaces.Roll;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RollImpl implements Roll {

    Set<Map.Entry<Rarity, Double>> raritySetSorted;
    ArrayList<CardEntity> cardsWithRarityThree;
    ArrayList<CardEntity> cardsWithRarityFour;
    ArrayList<CardEntity> cardsWithRarityFive;

    public RollImpl(Set<Map.Entry<Rarity, Double>> raritySetSorted, ArrayList<CardEntity> cardsWithRarityThree, ArrayList<CardEntity> cardsWithRarityFour, ArrayList<CardEntity> cardsWithRarityFive) {
        this.raritySetSorted = raritySetSorted;
        this.cardsWithRarityThree = cardsWithRarityThree;
        this.cardsWithRarityFour = cardsWithRarityFour;
        this.cardsWithRarityFive = cardsWithRarityFive;
    }

    @Override
    public CardEntity roll() {
        double rand = new Random().nextDouble() * 100;
        int acc = 0;

        for (Map.Entry<Rarity, Double> rarity : raritySetSorted) {
            acc += rarity.getValue();

            if (rand < acc) {

                if (rarity.getKey() == Rarity.THREE) {
                    Random random = new Random();
                    final int arrLength = cardsWithRarityThree.size();
                    return cardsWithRarityThree.get((int) (random.nextDouble() * arrLength));
                }
                if (rarity.getKey() == Rarity.FOUR) {
                    Random random = new Random();
                    final int arrLength = cardsWithRarityFour.size();
                    return cardsWithRarityFour.get((int) (random.nextDouble() * arrLength));

                }
                if (rarity.getKey() == Rarity.FIVE) {
                    Random random = new Random();
                    final int arrLength = cardsWithRarityFive.size();
                    return cardsWithRarityFive.get((int) (random.nextDouble() * arrLength));
                }
            }
        }
        return null;
    }

    @Override
    public CardEntity[] tenRoll() {
        CardEntity[] resultArray = new CardEntity[10];
        return resultArray;
    }
}
