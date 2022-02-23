package mcm.edu.ph.testturnbasedgame.Controller;
import java.util.Random;

import mcm.edu.ph.testturnbasedgame.Model.GameUnit;
import mcm.edu.ph.testturnbasedgame.R;

public class Game_Behavior extends GameUnit {
    Random randomizer = new Random();
    public int attack(int atkMin,int atkMax){
        return randomizer.nextInt(atkMax-atkMin)+atkMin;

        }
    }
