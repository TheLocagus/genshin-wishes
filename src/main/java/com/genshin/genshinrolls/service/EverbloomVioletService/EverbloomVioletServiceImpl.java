package com.genshin.genshinrolls.service.EverbloomVioletService;

import com.genshin.genshinrolls.RollImpl;
import com.genshin.genshinrolls.entity.Card.CardEntity;
import com.genshin.genshinrolls.entity.Events.EverbloomViolet.EverbloomVioletEntity;
import com.genshin.genshinrolls.interfaces.Roll;
import com.genshin.genshinrolls.repository.EverbloomVioletRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EverbloomVioletServiceImpl implements EverbloomVioletService {

    private final EverbloomVioletRepository everbloomVioletRepository;

    public EverbloomVioletServiceImpl(EverbloomVioletRepository everbloomVioletRepository) {
        this.everbloomVioletRepository = everbloomVioletRepository;
    }

    @Override
    public EverbloomVioletEntity getOne(Long id) {
        return this.everbloomVioletRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public ArrayList<EverbloomVioletEntity> getAll() {
        try {
            this.everbloomVioletRepository.findAll();
        } catch(NullPointerException e){
            System.out.println(e);
        }
        return (ArrayList<EverbloomVioletEntity>) this.everbloomVioletRepository.findAll();
    }

    @Override
    public ArrayList<EverbloomVioletEntity> getTen() {
        Roll<EverbloomVioletEntity> rollsUtils = new RollImpl<>();
        return rollsUtils.getTen((ArrayList<EverbloomVioletEntity>) this.everbloomVioletRepository.findAll());
    }

    @Override
    public EverbloomVioletEntity save(EverbloomVioletEntity card) {
        try{
            this.everbloomVioletRepository.save(card);
        } catch(Exception e){
            System.out.println(e);
            return null;
        }
        return card;
    }

    @Override
    public EverbloomVioletEntity update(EverbloomVioletEntity card, Long id) {
        EverbloomVioletEntity changedCard = this.everbloomVioletRepository.findById(id).orElseThrow(NullPointerException::new);
        changedCard.setName(card.getName());
        changedCard.setCategory(card.getCategory());
        changedCard.setChance(card.getChance());
        changedCard.setRarity(card.getRarity());
        changedCard.setWeapon(card.getWeapon());
        changedCard.setElement(card.getElement());
        this.everbloomVioletRepository.save(changedCard);
        return changedCard;
    }

    @Override
    public EverbloomVioletEntity delete(Long id) {
        final EverbloomVioletEntity removedCard = this.everbloomVioletRepository.findById(id).orElseThrow(NullPointerException::new);
        this.everbloomVioletRepository.deleteById(id);
        return removedCard;
    }
}
