package com.genshin.genshinrolls;

import com.genshin.genshinrolls.interfaces.Card;
import com.genshin.genshinrolls.interfaces.Roll;

public class RollImpl implements Roll {

    @Override
    public Card roll() {
        return null;
    }

    @Override
    public Card[] tenRoll() {
        Card[] resultArray = new Card[10];
        return resultArray;
    }
}
