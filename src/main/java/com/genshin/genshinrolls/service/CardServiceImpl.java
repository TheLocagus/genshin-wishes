package com.genshin.genshinrolls.service;

import com.genshin.genshinrolls.RollImpl;
import com.genshin.genshinrolls.entity.Card.CardEntity;
import com.genshin.genshinrolls.enums.Rarity;
import com.genshin.genshinrolls.interfaces.Roll;
import com.genshin.genshinrolls.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.*;

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
        Roll rollsUtils = new RollImpl();
        return rollsUtils.getTen((ArrayList<CardEntity>) this.cardRepository.findAll());
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
