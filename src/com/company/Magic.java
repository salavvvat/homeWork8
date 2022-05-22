package com.company;

public class Magic extends Hero {
    public Magic(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes, Aleksey aleksey) {
        int coeff = RPG_Game.random.nextInt(20);
        for (int i = 0; i < heroes.length ; i++) {
            boss.setHealth(boss.getHealth() - (this.getDamage() + coeff));
        }
        System.out.println("Heroes hits with magic power: " + (this.getDamage() + coeff));
    }
}

