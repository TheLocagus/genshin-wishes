package com.genshin.genshinrolls;

import com.genshin.genshinrolls.enums.Category;
import com.genshin.genshinrolls.enums.Rarity;
import com.genshin.genshinrolls.enums.Weapon;
import com.genshin.genshinrolls.interfaces.Card;

import java.util.Objects;

public class CardImpl implements Card {

    public String name;
    public Category category;
    public Weapon weapon;
    public Rarity rarity;
    public double chance;

    public CardImpl(String name,Category category, Weapon weapon, Rarity rarity, double chance){
        this.name = name;
        this.category = category;
        this.weapon = weapon;
        this.rarity = rarity;
        this.chance = chance;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

}
