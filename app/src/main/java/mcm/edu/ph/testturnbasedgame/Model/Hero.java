package mcm.edu.ph.testturnbasedgame.Model;

public class Hero extends GameUnit{
    //Attributes
    private double experience;
    private int strength;
    private int agility;
    private int intelligence;
    private int constitution;
    private int luck;

    //Inventory
    private int goldValue;

    //Borrowed Variables
    String unitNames;
    double healthPoint;
    double manaPoint;
    int atkMax;
    int atkMin;
    int lvl;
    double armour;

    // Default Constructor
    public Hero(String name,double currentHp,double mp,double maxHp,int str,int agi, int intelli,int consti, int luck,int lvl){
        super.setCurrentHealthPoint(maxHp);
        super.setUnitNames(name);
        super.setLevel(lvl);
        super.setMaxHealthPoint(currentHp);
        super.setManaPoint(mp);
        strength = str;
        agility = agi;
        intelligence = intelli;
        constitution = consti;
        this.luck = luck;

    }

    @Override
    public int getAtkMax() {
        this.atkMax = super.getAtkMax();
        this.atkMax = 100;
        this.atkMax += strength * 2; // for every point of str, it gains 2 max atk.
        return this.atkMax;
    }
    @Override
    public int getAtkMin() {
        this.atkMin = super.getAtkMin();
        this.atkMin = 50;
        this.atkMin += agility * 2; // for every point of str, it gains 2 max atk.
        return this.atkMin;
    }
        /*
     @Override
    public double getHealthPoint() {
        this.healthPoint = super.getHealthPoint(); // from super to global
        this.healthPoint += constitution * 20; // for every point of const it adds 20 hp to base hp
        return this.healthPoint;
    }
    @Override
    public double getManaPoint() {
        this.manaPoint = super.getManaPoint(); // from super to global
        this.manaPoint += intelligence * 12; // for every point of int it adds 12 mp to base mp
        return this.manaPoint;
    } */
    //Getters

    public double getExperience() { return experience; }
    public int getStrength() { return strength; }
    public int getAgility() { return agility; }
    public int getIntelligence() { return intelligence; }
    public int getConstitution() { return constitution; }
    public int getLuck() { return luck; }
    public int getGoldValue() { return goldValue; }

    //Setters


    public void setExperience(double experience) { this.experience = experience; }
    public void setStrength(int strength) { this.strength = strength; }
    public void setAgility(int agility) { this.agility = agility; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }
    public void setLuck(int luck) { this.luck = luck; }
    public void setConstitution(int constitution) { this.constitution = constitution; }
    public void setGoldValue(int goldValue) { this.goldValue = goldValue; }
}

