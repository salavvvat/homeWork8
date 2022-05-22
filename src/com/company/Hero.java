package com.company;

public abstract class Hero extends GameEntity implements HavingSuperPower {
    private SuperAbility superAbility;

    public Hero(String name, int health, int damage, SuperAbility superAbility) {
        super(name, health, damage);
        this.superAbility = superAbility;
    }

    public SuperAbility getSuperAbility() {
        return superAbility;
    }

    public void setSuperAbility(SuperAbility superAbility) {
        this.superAbility = superAbility;
    }

    public void hit(Boss boss, Aleksey aleksey) {
        if (boss.getHealth() > 0) {
            boss.setHealth(boss.getHealth() - this.getDamage());
        }
        else if (aleksey.getHealth() > 1) {
            aleksey.setHealth(aleksey.getHealth() - this.getDamage());
        }
    }
}
