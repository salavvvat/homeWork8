package com.company;

public class Aleksey extends Boss {

    public Aleksey(String name, int health, int damage) {
        super(name, health, damage);
    }

    public void hit(Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
            }
        }
    }
}
