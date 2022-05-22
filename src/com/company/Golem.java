package com.company;

public class Golem extends Hero {


    public Golem(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.GREAT_WALL);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes, Aleksey aleksey) {
        int pieceOfDamage = boss.getDamage()/5;
        int amountOfHeroes = 0;
        for (int i = 0; i <heroes.length ; i++) {
            if (heroes[i].getHealth() > 0){
                amountOfHeroes++;
                heroes[i].setHealth(heroes[i].getHealth() + pieceOfDamage);
                this.setHealth(this.getHealth() - pieceOfDamage * amountOfHeroes);
            }
        }
        System.out.println("Golem ate damage: " + pieceOfDamage * amountOfHeroes);
    }

}
