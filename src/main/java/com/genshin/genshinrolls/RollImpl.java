package com.genshin.genshinrolls;

import com.genshin.genshinrolls.entity.Card.CardEntity;
import com.genshin.genshinrolls.enums.Rarity;
import com.genshin.genshinrolls.interfaces.Card;
import com.genshin.genshinrolls.interfaces.Roll;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class RollImpl<T extends Card> implements Roll<T>  {

    ArrayList<T> allCards;

    public RollImpl(){};

    @Override
    public T roll(ArrayList<T> cardsWithRarityThree, ArrayList<T> cardsWithRarityFour, ArrayList<T> cardsWithRarityFive, Set<Map.Entry<Rarity, Double>> raritySetSorted) {
        double rand = new Random().nextDouble() * 100;
        System.out.println(rand);
        double acc = 0;

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
    public ArrayList<T> getCardsDividedByRarity(Rarity rarity, ArrayList<T> allCards) {
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

    public Set<Map.Entry<Rarity, Double>> getRaritySetSorted(ArrayList<T> cardsWithRarityThree, ArrayList<T> cardsWithRarityFour, ArrayList<T> cardsWithRarityFive){
        HashMap<Rarity, Double> rarityMap = new HashMap<>();
        rarityMap.put(Rarity.THREE, cardsWithRarityThree.get(0).getChance());
        rarityMap.put(Rarity.FOUR, cardsWithRarityFour.get(0).getChance());
        rarityMap.put(Rarity.FIVE, cardsWithRarityFive.get(0).getChance());

        Set<Map.Entry<Rarity, Double>> raritySet = rarityMap.entrySet();

        return raritySet.stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }



    public ArrayList<T> getTen(ArrayList<T> allCards){

        ArrayList<T> result = new ArrayList();

        ArrayList<T> cardsWithRarityThree = this.getCardsDividedByRarity(Rarity.THREE, allCards);
        ArrayList<T> cardsWithRarityFour = this.getCardsDividedByRarity(Rarity.FOUR, allCards);
        ArrayList<T> cardsWithRarityFive = this.getCardsDividedByRarity(Rarity.FIVE, allCards);

        Set<Map.Entry<Rarity, Double>> raritySetSorted = this.getRaritySetSorted(cardsWithRarityThree, cardsWithRarityFour, cardsWithRarityFive);

        for (int i = 0; i < 10; i++) {
           T oneRoll = (this.roll(cardsWithRarityThree, cardsWithRarityFour, cardsWithRarityFive, raritySetSorted));
            System.out.println(oneRoll.toString());
            result.add(oneRoll);
        }
        return result;
    }

}
