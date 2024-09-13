package com.solvd.enums;

public enum PromotionsNames {

    SUPERSAVINGSRATE(0.30F),
    LOWCREDITRATE(0.2F);

    public final float percentPromo;

    PromotionsNames (float percentPromo) {
        this.percentPromo = percentPromo;
    }
}
