package com.genshin.genshinrolls;

import com.genshin.genshinrolls.entity.Card.CardEntity;
import com.genshin.genshinrolls.enums.Rarity;
import com.genshin.genshinrolls.interfaces.Roll;

import java.util.*;
import java.util.stream.Collectors;

public class RollImpl implements Roll {

    ArrayList<CardEntity> allCards;

    public RollImpl(){};

    @Override
    public CardEntity roll(ArrayList<CardEntity> cardsWithRarityThree, ArrayList<CardEntity> cardsWithRarityFour, ArrayList<CardEntity> cardsWithRarityFive, Set<Map.Entry<Rarity, Double>> raritySetSorted) {
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
    public ArrayList<CardEntity> getCardsDividedByRarity(Rarity rarity, ArrayList<CardEntity> allCards) {
        if(rarity == Rarity.THREE){
            return allCards.stream().filter((cardEntity -> cardEntity.getRarity() == Rarity.THREE)).collect(Collectors.toCollection(ArrayList::new));
        }
        if(rarity == Rarity.FOUR){
            return allCards.stream().filter((cardEntity -> cardEntity.getRarity() == Rarity.FOUR)).collect(Collectors.toCollection(ArrayList::new));
        }
        if(rarity == Rarity.FIVE){
            return allCards.stream().filter((cardEntity -> cardEntity.getRarity() == Rarity.FIVE)).collect(Collectors.toCollection(ArrayList::new));
        }
        return null;
    }

    public Set<Map.Entry<Rarity, Double>> getRaritySetSorted(ArrayList<CardEntity> cardsWithRarityThree, ArrayList<CardEntity> cardsWithRarityFour, ArrayList<CardEntity> cardsWithRarityFive){
        HashMap<Rarity, Double> rarityMap = new HashMap<>();
        rarityMap.put(Rarity.THREE, cardsWithRarityThree.get(0).getChance());
        rarityMap.put(Rarity.FOUR, cardsWithRarityFour.get(0).getChance());
        rarityMap.put(Rarity.FIVE, cardsWithRarityFive.get(0).getChance());

        Set<Map.Entry<Rarity, Double>> raritySet = rarityMap.entrySet();

        return raritySet.stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public CardEntity[] getTen(ArrayList<CardEntity> allCards){
        CardEntity[] result = new CardEntity[10];

        ArrayList<CardEntity> cardsWithRarityThree = this.getCardsDividedByRarity(Rarity.THREE, allCards);
        ArrayList<CardEntity> cardsWithRarityFour = this.getCardsDividedByRarity(Rarity.FOUR, allCards);
        ArrayList<CardEntity> cardsWithRarityFive = this.getCardsDividedByRarity(Rarity.FIVE, allCards);

        Set<Map.Entry<Rarity, Double>> raritySetSorted = this.getRaritySetSorted(cardsWithRarityThree, cardsWithRarityFour, cardsWithRarityFive);

        for (int i = 0; i < 10; i++) {
            result[i] = this.roll(cardsWithRarityThree, cardsWithRarityFour, cardsWithRarityFive, raritySetSorted);
        }
        return result;
    }

}
