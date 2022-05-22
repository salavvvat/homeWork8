package com.company;

public class Thor extends Hero {
    public Thor (String name, int health, int damage) {
        super(name, health, damage, SuperAbility.STAN);
        }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes, Aleksey aleksey){
        boolean coeff = RPG_Game.random.nextBoolean();
        if(coeff){
            boss.setDamage(0);
            System.out.println("Boss has stan");
        }else{
            boss.setDamage(50);
        }
    }
}
