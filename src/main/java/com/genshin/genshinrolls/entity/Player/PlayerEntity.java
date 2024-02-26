package com.genshin.genshinrolls.entity.Player;

import com.genshin.genshinrolls.enums.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class PlayerEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int rollsWithoutRarityFive;
    private int rollsWithoutRarityFour;
    private HeroGuaranteeType heroGuaranteeType;
    private WeaponGuaranteeType weaponGuaranteeType;
    private Long chosenWeaponId; //one-to-one
    private int rollsWithoutRarityFiveWeaponBanner;
    private int rollsWithoutRarityFourWeaponBanner;

    public PlayerEntity(){}
}

