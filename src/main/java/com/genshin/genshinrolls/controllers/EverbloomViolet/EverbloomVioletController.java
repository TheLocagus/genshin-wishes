package com.genshin.genshinrolls.controllers.EverbloomViolet;

import com.genshin.genshinrolls.entity.Card.CardEntity;
import com.genshin.genshinrolls.entity.Events.EverbloomViolet.EverbloomVioletEntity;
import com.genshin.genshinrolls.service.EverbloomVioletService.EverbloomVioletService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/everbloom-violet")
public class EverbloomVioletController {

    private final EverbloomVioletService everbloomVioletService;

    public EverbloomVioletController(EverbloomVioletService everbloomVioletService) {
        this.everbloomVioletService = everbloomVioletService;
    }

    @GetMapping("/api/")
    ArrayList<EverbloomVioletEntity> getAllCards(){
        return this.everbloomVioletService.getAll();
    }

    @PostMapping("/api/")
    EverbloomVioletEntity save(@RequestBody EverbloomVioletEntity card){
        return this.everbloomVioletService.save(card);
    }

    @GetMapping("/api/{id}")
    EverbloomVioletEntity getOne(@PathVariable Long id){
        return this.everbloomVioletService.getOne(id);
    }

    @PutMapping("/api/{id}")
    EverbloomVioletEntity update(@RequestBody EverbloomVioletEntity card, @PathVariable Long id){
        return this.everbloomVioletService.update(card, id);
    }

    @DeleteMapping("/api/{id}")
    EverbloomVioletEntity delete(@PathVariable Long id){
        return this.everbloomVioletService.delete(id);
    }

    @GetMapping("/api/ten-roll")
    ArrayList<EverbloomVioletEntity> getTenCards(){
        return this.everbloomVioletService.getTen();
    }


}