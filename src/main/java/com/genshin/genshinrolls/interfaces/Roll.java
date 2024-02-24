package com.genshin.genshinrolls.interfaces;

import com.genshin.genshinrolls.entity.CardEntity;

public interface Roll {
    public CardEntity roll();
    public CardEntity[] tenRoll();
}
