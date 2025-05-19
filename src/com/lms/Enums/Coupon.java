package com.lms.Enums;

public enum Coupon {
    DIWALI25(10),
    SUMMER25(15),
    BLACK_FRIDAY(20);

    private int discount;

    Coupon(int discount){
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

}
