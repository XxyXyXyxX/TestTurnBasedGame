package mcm.edu.ph.testturnbasedgame.Model;

import java.util.Random;

public class GameUnit {
    //Private Variables
    private double currentHealthPoint;
    private double maxHealthPoint;
    private double manaPoint;
    private String unitNames;
    private String title;
    private double armourPoint;
    private double unitTitle;
    private int atkMin;
    private int atkMax;
    private int level;
    private int gameCounter;
    //Methods
    int baseDamage(int atkMin, int atkMax){
        Random randomizer = new Random();
        return (randomizer.nextInt(atkMax-atkMin)+atkMin);
    }
    int baseDamage(){
        return 0;
    }
    //Getters

    public double getCurrentHealthPoint() { return currentHealthPoint; }
    public double getMaxHealthPoint() { return maxHealthPoint; }
    public double getManaPoint() { return manaPoint; }
    public String getUnitNames() { return unitNames; }
    public double getArmourPoint() { return armourPoint; }
    public double getUnitTitle() { return unitTitle; }
    public int getAtkMax() { return atkMax; }
    public int getAtkMin() { return atkMin; }
    public int getLevel() { return level; }
    public int getGameCounter() { return gameCounter; }
    public String getTitle() { return title; }
    //Setters


    public void setCurrentHealthPoint(double currentHealthPoint) { this.currentHealthPoint = currentHealthPoint; }
    public void setMaxHealthPoint(double maxHealthPoint) { this.maxHealthPoint = maxHealthPoint; }
    public void setManaPoint(double manaPoint) { this.manaPoint = manaPoint; }
    public void setUnitNames(String unitNames) { this.unitNames = unitNames; }
    public void setArmourPoint(double armourPoint) { this.armourPoint = armourPoint; }
    public void setUnitTitle(double unitTitle) { this.unitTitle = unitTitle; }
    public void setAtkMin(int atkMin) { this.atkMin = atkMin; }
    public void setAtkMax(int atkMax) { this.atkMax = atkMax; }
    public void setLevel(int level) { this.level = level; }
    public void setGameCounter(int gameCounter) { this.gameCounter = gameCounter; }
    public void setTitle(String title) { this.title = title; }
    //Constructors



}