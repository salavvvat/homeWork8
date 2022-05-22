package com.company;

public class Berserk extends Hero {
    private int savedDamage;
    public Berserk(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes, Aleksey aleksey) {
        int coeff = RPG_Game.random.nextInt(20);
        boss.setHealth(boss.getHealth() - (this.getDamage() + coeff));
        System.out.println("Berserk hits back: " + (this.getDamage() + coeff));
    }
}

