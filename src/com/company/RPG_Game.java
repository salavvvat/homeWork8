package com.company;

import java.util.Random;

public class RPG_Game {

    private static int roundNumber;
    public static Random random = new Random();

    public static void startGame() {
        Boss boss = new Boss("Bolot", 2000, 50);
        Aleksey aleksey = new Aleksey("Aleksey", 1000, 20);
        Warrior warrior = new Warrior("Hercules", 270, 10);
        Medic doctor = new Medic("Aibolit", 250, 5, 15);
        Magic magic = new Magic("Gendelf", 260, 20);
        Berserk berserk = new Berserk("Viking", 280, 15);
        Medic assistant = new Medic("Strange", 290, 10, 5);
        Thor hemsvort = new Thor("Kris", 250, 15);
        Golem golem = new Golem("BigBoy", 400, 15);
        Hero[] heroes = {warrior, doctor, magic, berserk, assistant, hemsvort, golem};

        printStatistics(boss, heroes, aleksey);
        while (!isGameFinished(boss, heroes, aleksey)) {
            round(boss, heroes, aleksey);
        }
    }

    private static void round(Boss boss, Hero[] heroes, Aleksey aleksey) {
        roundNumber++;
        boss.hit(heroes);
        aleksey.hit(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].hit(boss, aleksey);
                heroes[i].applySuperPower(boss, heroes, aleksey);
            }
        }
        printStatistics(boss, heroes,  aleksey);
    }

    private static void printStatistics(Boss boss, Hero[] heroes, Aleksey aleksey) {
        System.out.println(roundNumber + " ROUND ______________");
        System.out.println("BOSS " + boss);
        if (boss.getHealth() <= 0){
            System.out.println("Aleksey " + aleksey);
        }
        for (int i = 0; i < heroes.length; i++) {
            /*System.out.println(heroes[i].getClass().getSimpleName() +
                    " health: " + heroes[i].getHealth() + " [" +
                    heroes[i].getDamage() + "]");*/
            System.out.println(heroes[i]);
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes, Aleksey aleksey) {
        if (boss.getHealth() <= 0) {
            boss.setDamage(0);
            return true;
        }
        else if (boss.getHealth() <= 0 && aleksey.getHealth() <= 1) {
            boss.setDamage(0);
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
}