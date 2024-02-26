package com.genshin.genshinrolls.controllers.EverbloomViolet;

import com.genshin.genshinrolls.entity.Card.CardEntity;
import com.genshin.genshinrolls.service.CardServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EverbloomVioletController {

//    private CardServiceImpl cardService;
//
//    public EverbloomVioletController(CardServiceImpl cardService) {
//        this.cardService = cardService;
//    }
//
//    @GetMapping("/")
//    ArrayList<CardEntity> getAllCards(){
//        return this.cardService.getAll();
//    }
//
//    @PostMapping("/")
//    CardEntity save(@RequestBody CardEntity card){
//        return this.cardService.save(card);
//    }
//
//    @PutMapping("/{id}")
//    CardEntity update(@RequestBody CardEntity card, @PathVariable Long id){
//        return this.cardService.update(card, id);
//    }
//
//    @DeleteMapping("/{id}")
//    CardEntity delete(@PathVariable Long id){
//        return this.cardService.delete(id);
//    }
//
//    @GetMapping("/ten-roll")
//    CardEntity[] getTenCards(){
//        return this.cardService.getTen();
//    }


}