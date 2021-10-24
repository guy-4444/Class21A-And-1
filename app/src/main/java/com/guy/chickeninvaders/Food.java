package com.guy.chickeninvaders;

public class Food {
    private int res = 0;
    private boolean isChicken = false;

    public Food() { }

    public int getRes() {
        return res;
    }

    public Food setRes(int res) {
        this.res = res;
        return this;
    }

    public boolean isChicken() {
        return isChicken;
    }

    public Food setChicken(boolean chicken) {
        isChicken = chicken;
        return this;
    }
}
