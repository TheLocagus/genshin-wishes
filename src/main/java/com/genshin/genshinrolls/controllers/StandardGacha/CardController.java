package com.genshin.genshinrolls.controllers.StandardGacha;

import com.genshin.genshinrolls.entity.Card.CardEntity;
import com.genshin.genshinrolls.service.CardService.CardServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("")
public class CardController {

    private final CardServiceImpl cardService;

    public CardController(CardServiceImpl cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/api/")
    ArrayList<CardEntity> getAllCards(){
        return this.cardService.getAll();
    }

    @PostMapping("/api/")
    CardEntity save(@RequestBody CardEntity card){
        return this.cardService.save(card);
    }

    @GetMapping("/api/{id}")
    CardEntity getOne(@PathVariable Long id){
        return this.cardService.getOne(id);
    }

    @PutMapping("/api/{id}")
    CardEntity update(@RequestBody CardEntity card, @PathVariable Long id){
        return this.cardService.update(card, id);
    }

    @DeleteMapping("/api/{id}")
    CardEntity delete(@PathVariable Long id){
        return this.cardService.delete(id);
    }

    @GetMapping("/api/ten-roll")
    ArrayList<CardEntity> getTenCards(){
        return this.cardService.getTen();
    }


}
