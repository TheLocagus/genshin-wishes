package com.genshin.genshinrolls.entity;


import com.genshin.genshinrolls.enums.Category;
import com.genshin.genshinrolls.enums.Element;
import com.genshin.genshinrolls.enums.Rarity;
import com.genshin.genshinrolls.enums.Weapon;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CardEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Category category;
    private Weapon weapon;
    private Rarity rarity;
    private double chance;
    private Element element;

    public CardEntity(){};

    public CardEntity(Long id, String name, Category category, Weapon weapon, Rarity rarity, double chance, Element element) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.weapon = weapon;
        this.rarity = rarity;
        this.chance = chance;
        this.element = element;
    }

    public Long getId(){return id;}

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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
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

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "CardEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", weapon=" + weapon +
                ", rarity=" + rarity +
                ", chance=" + chance +
                ", element=" + element +
                '}';
    }
}
