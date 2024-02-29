package com.genshin.genshinrolls.interfaces;

import com.genshin.genshinrolls.enums.Category;
import com.genshin.genshinrolls.enums.Element;
import com.genshin.genshinrolls.enums.Rarity;
import com.genshin.genshinrolls.enums.Weapon;

public interface Card {
    public Long getId();

    public String getName();

    public void setName(String name);

    public Category getCategory();

    public void setCategory(Category category);

    public Weapon getWeapon();

    public void setWeapon(Weapon weapon);

    public Rarity getRarity();

    public void setRarity(Rarity rarity);

    public double getChance();

    public void setChance(double chance);

    public Element getElement();

    public void setElement(Element element);
}
