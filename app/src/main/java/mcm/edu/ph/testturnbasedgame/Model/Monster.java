package mcm.edu.ph.testturnbasedgame.Model;

public class Monster extends GameUnit {
    //Borrowed Variables
    String unitNames;
    String title;
    double healthPoint;
    double manaPoint;
    int atkMax;
    int atkMin;
    double armourPoint;
    int lvl;

    public Monster(String name,String title,double currentHp,double mp,double maxHp,int atkMax,int atkMin,double armour,int lvl){
        super.setUnitNames(name);
        super.setMaxHealthPoint(maxHp);
        super.setCurrentHealthPoint(currentHp);
        super.setManaPoint(mp);
        super.setAtkMax(atkMax);
        super.setAtkMin(atkMin);
        super.setArmourPoint(armour);
        super.setLevel(lvl);
        super.setAtkMin(atkMin);
        super.setAtkMax(atkMax);
    }
}
