package mcm.edu.ph.testturnbasedgame.View;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;



import mcm.edu.ph.testturnbasedgame.Controller.Game_Behavior;
import mcm.edu.ph.testturnbasedgame.Model.GameUnit;
import mcm.edu.ph.testturnbasedgame.Model.Hero;
import mcm.edu.ph.testturnbasedgame.Model.Monster;
import mcm.edu.ph.testturnbasedgame.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Game_Behavior g1 = new Game_Behavior();
    // Characters
    Hero Hero = new Hero("Nathan", 5000, 100, 5000,200, 200, 10, 10, 10, 1);
    Monster Boss = new Monster("Boss", "Scary", 4000, 100, 4000, 200, 100, 1,1);
    // Game turn;
    boolean disabledstatus = false;
    int gameCounter = 1;
    int statuscounter = 0;
    int skillCD1 = 0;
    int skillCD2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button endTurn = findViewById(R.id.btnEndTurn);

        TextView txtMonsName = findViewById(R.id.txtMonsName);
        TextView txtHeroName = findViewById(R.id.txtHeroName);
        TextView txtMonsHP = findViewById(R.id.txtMonsHp);
        TextView txtHeroHP = findViewById(R.id.txtHeroHp);
        TextView txtHeroDPT = findViewById(R.id.txtHeroDpt);
        TextView txtMonsDPT = findViewById(R.id.txtMonsDpt);

        txtHeroName.setText(Hero.getUnitNames());
        txtMonsName.setText(Boss.getUnitNames());

        txtHeroHP.setText(String.valueOf(Hero.getCurrentHealthPoint()));
        txtMonsHP.setText(String.valueOf(Boss.getCurrentHealthPoint()));

        txtHeroDPT.setText(Hero.getAtkMin() + " ~ " + Hero.getAtkMax());
        txtMonsDPT.setText(Boss.getAtkMin() + " ~ " + Boss.getAtkMax());

        ImageButton skill1 = findViewById(R.id.btnSkill1);
        ImageButton skill2 = findViewById(R.id.btnSkill2);


        //button onClick Listener
        endTurn.setOnClickListener(this);
        skill1.setOnClickListener(this);
        skill2.setOnClickListener(this);
}

    @Override
    public void onClick(View v) {
        Button endTurn = findViewById(R.id.btnEndTurn);
        TextView txtMonsHP = findViewById(R.id.txtMonsHp);
        TextView txtHeroHP = findViewById(R.id.txtHeroHp);
        TextView txtBattleLog = findViewById(R.id.txtBattleLog);

        // We displayed the HP values here to reset the display every time the button is clicked

        txtHeroHP.setText(String.valueOf(Hero.getCurrentHealthPoint()));
        txtMonsHP.setText(String.valueOf(Boss.getCurrentHealthPoint()));

        //Randomizer
        int heroDPT = g1.attack(Hero.getAtkMin(), Hero.getAtkMax());
        int monsDPT = g1.attack(Boss.getAtkMin(), Boss.getAtkMax());

        ImageButton skill1 = findViewById(R.id.btnSkill1);
        ImageButton skill2 = findViewById(R.id.btnSkill2);

        // For skills
        if(gameCounter % 2 != 1){ //if it is enemy's turn, disable button
            skill1.setEnabled(false);
            skill2.setEnabled(false);
        }
        else if(gameCounter%2 == 1){
            skill1.setEnabled(true);
            skill2.setEnabled(true);
        }
        if(skillCD1>0){
            skill1.setVisibility(View.GONE);
            skill1.setEnabled(false);
            // buttoncounter--;
        }
        else if(skillCD1==0){
            skill1.setEnabled(true);
            skill1.setVisibility(View.VISIBLE);
        }
        if(skillCD2>0){
            skill2.setVisibility(View.GONE);
            skill2.setEnabled(false);
            // buttoncounter--;
        }
        else if(skillCD2==0){
            skill2.setEnabled(true);
            skill2.setVisibility(View.VISIBLE);
        }
        // the switch for the button/s starts here.
        switch (v.getId()) {
            case R.id.btnSkill1:

                Boss.setCurrentHealthPoint(Boss.getCurrentHealthPoint()-heroDPT*1.25);
                gameCounter++;
                txtMonsHP.setText(String.valueOf(Boss.getCurrentHealthPoint()));
                endTurn.setText("Next Turn ("+ String.valueOf(gameCounter)+")");
                txtBattleLog.setText("Our Hero "+String.valueOf(Hero.getUnitNames()) +" used stun!. It dealt "+String.valueOf(heroDPT*1.25) + " damage to the enemy. The enemy is stunned for 4 turns");
                disabledstatus = true;
                statuscounter = 4;
                skillCD1=3;
                skillCD1--;
                skillCD2--;
                break;
            case R.id.btnSkill2:

                Boss.setCurrentHealthPoint(Boss.getCurrentHealthPoint()-heroDPT*1.5);
                gameCounter++;
                txtMonsHP.setText(String.valueOf(Boss.getCurrentHealthPoint()));
                endTurn.setText("Next Turn ("+ String.valueOf(gameCounter)+")");
                txtBattleLog.setText("Our Hero "+String.valueOf(Hero.getUnitNames()) +" used stun!. It dealt "+String.valueOf(heroDPT*1.5) + " damage to the enemy. The enemy is stunned for 4 turns");
                disabledstatus = true;
                statuscounter = 4;
                skillCD2=4w;
                skillCD1--;
                skillCD2--;
                break;
            case R.id.btnEndTurn:

                if (gameCounter % 2 == 1) {
                    Boss.setCurrentHealthPoint(Boss.getCurrentHealthPoint() - heroDPT);
                    gameCounter++;
                    txtBattleLog.setText("The Player dealt " + heroDPT + " damage to the Enemy.");
                    txtMonsHP.setText(String.valueOf(Boss.getCurrentHealthPoint()));
                    endTurn.setText("Enemy's Turn (" + gameCounter + ")");
                    skillCD1--;
                    skillCD2--;
                } // end of player's turn condition
                else if (gameCounter % 2 != 1) {
                    Hero.setCurrentHealthPoint(Hero.getCurrentHealthPoint() - monsDPT);
                    gameCounter++;
                    txtBattleLog.setText("The Monster dealt " + monsDPT + " damage to the Player");
                    txtHeroHP.setText(String.valueOf(Hero.getCurrentHealthPoint()));
                    endTurn.setText("Player's Turn (" + gameCounter + ")");

                }   // end of the monsters turn condition
                break;  // switch breaker for the button function.
        }
        if (Hero.getCurrentHealthPoint() < 0) {
            txtBattleLog.setText("The Monster dealt " + monsDPT + " damage to the Player. The Player Died");
            Hero.setCurrentHealthPoint(Hero.getMaxHealthPoint());
            Boss.setCurrentHealthPoint(Boss.getMaxHealthPoint());
            gameCounter = 1;
            disabledstatus = false;
            statuscounter = 0;
            skillCD1=0;
            skillCD2=0;
            endTurn.setText("Reset Game");
        }
        if (Boss.getCurrentHealthPoint() < 0) {
            txtBattleLog.setText("The Player dealt " + heroDPT + " damage to the Enemy. The Player wins");
            Hero.setCurrentHealthPoint(Hero.getMaxHealthPoint());
            Boss.setCurrentHealthPoint(Boss.getMaxHealthPoint());
            gameCounter = 1;
            disabledstatus = false;
            statuscounter = 0;
            skillCD1=0;
            skillCD2=0;
            endTurn.setText("Reset Game");
        }
    }
}
