package com.genshin.genshinrolls.service;

import com.genshin.genshinrolls.RollImpl;
import com.genshin.genshinrolls.entity.CardEntity;
import com.genshin.genshinrolls.enums.Rarity;
import com.genshin.genshinrolls.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public CardEntity getOne(Long id) {
        return this.cardRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public ArrayList<CardEntity> getAll() {
        try {
           this.cardRepository.findAll();
        } catch(NullPointerException e){
            System.out.println(e);
        }
        return (ArrayList<CardEntity>) this.cardRepository.findAll();
    }

    @Override
    public CardEntity[] getTen() {
        CardEntity[] result = new CardEntity[10];

        ArrayList<CardEntity> allCards = (ArrayList<CardEntity>) this.cardRepository.findAll();

        ArrayList<CardEntity> cardsWithRarityThree = allCards.stream().filter((cardEntity -> cardEntity.getRarity() == Rarity.THREE)).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<CardEntity> cardsWithRarityFour = allCards.stream().filter((cardEntity -> cardEntity.getRarity() == Rarity.FOUR)).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<CardEntity> cardsWithRarityFive = allCards.stream().filter((cardEntity -> cardEntity.getRarity() == Rarity.FIVE)).collect(Collectors.toCollection(ArrayList::new));

        HashMap<Rarity, Double> rarityMap = new HashMap<>();
        rarityMap.put(Rarity.THREE, cardsWithRarityThree.get(0).getChance());
        rarityMap.put(Rarity.FOUR, cardsWithRarityFour.get(0).getChance());
        rarityMap.put(Rarity.FIVE, cardsWithRarityFive.get(0).getChance());

        Set<Map.Entry<Rarity, Double>> raritySet = rarityMap.entrySet();
        Set<Map.Entry<Rarity, Double>> raritySetSorted = raritySet.stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (int i = 0; i < 10; i++) {
            result[i] = new RollImpl(raritySetSorted, cardsWithRarityThree, cardsWithRarityFour, cardsWithRarityFive).roll();
        }

        return result;
    }

    @Override
    public CardEntity save(CardEntity card) {
        try{
            this.cardRepository.save(card);
        } catch(Exception e){
            System.out.println(e);
            return null;
        }
        return card;
    }

    @Override
    public CardEntity update(CardEntity card, Long id) {

        CardEntity changedCard = this.cardRepository.findById(id).orElseThrow(NullPointerException::new);
        changedCard.setName(card.getName());
        changedCard.setCategory(card.getCategory());
        changedCard.setChance(card.getChance());
        changedCard.setRarity(card.getRarity());
        changedCard.setWeapon(card.getWeapon());
        changedCard.setElement(card.getElement());
        this.cardRepository.save(changedCard);
        return changedCard;
    }

    @Override
    public CardEntity delete(Long id) {
        final CardEntity removedCard = this.cardRepository.findById(id).orElseThrow(NullPointerException::new);
        this.cardRepository.deleteById(id);
        return removedCard;
    }
}
