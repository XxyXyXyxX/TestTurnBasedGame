package mcm.edu.ph.testturnbasedgame.View;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.Random;

import mcm.edu.ph.testturnbasedgame.Controller.Game_Behavior;
import mcm.edu.ph.testturnbasedgame.Model.GameUnit;
import mcm.edu.ph.testturnbasedgame.Model.Hero;
import mcm.edu.ph.testturnbasedgame.Model.Monster;
import mcm.edu.ph.testturnbasedgame.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Game_Behavior g1 = new Game_Behavior();
    Hero Hero = new Hero("Nathan", 5000, 100, 5000,200, 200, 10, 10, 10, 1);
    Monster Boss = new Monster("Boss", "Scary", 4000, 100, 4000, 200, 100, 1,1);
    int gameCounter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /** any code here in onCreate executes only once: during the start of an app **/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** button is declared here so that we can set an onClickListener **/
        Button endTurn = findViewById(R.id.btnEndTurn);

        /** TextViews are declared here so that text displays are updated during the start of the app **/
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

        endTurn.setOnClickListener(this);
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
        // the switch for the button/s starts here.
        switch (v.getId()) {
            case R.id.btnEndTurn:

                if (gameCounter % 2 == 1) {
                    Boss.setCurrentHealthPoint(Boss.getCurrentHealthPoint() - heroDPT);
                    gameCounter++;
                    txtBattleLog.setText("The Player dealt " + heroDPT + " damage to the Enemy.");
                    txtMonsHP.setText(String.valueOf(Boss.getCurrentHealthPoint()));
                    endTurn.setText("Enemy's Turn (" + gameCounter + ")");
                    if (Boss.getCurrentHealthPoint() < 0) {
                        txtBattleLog.setText("The Player dealt " + heroDPT + " damage to the Enemy. The Player wins");
                        Hero.setCurrentHealthPoint(Hero.getMaxHealthPoint());
                        Boss.setCurrentHealthPoint(Boss.getMaxHealthPoint());
                        gameCounter = 1;
                        endTurn.setText("Reset Game");
                    } // end of the resetting condition
                } // end of player's turn condition
                else if (gameCounter % 2 != 1) {
                    Hero.setCurrentHealthPoint(Hero.getCurrentHealthPoint() - monsDPT);
                    gameCounter++;
                    txtBattleLog.setText("The Monster dealt " + monsDPT + " damage to the Player");
                    txtHeroHP.setText(String.valueOf(Hero.getCurrentHealthPoint()));
                    endTurn.setText("Player's Turn (" + gameCounter + ")");
                    if (Hero.getCurrentHealthPoint() < 0) {
                        txtBattleLog.setText("The Monster dealt " + monsDPT + " damage to the Player. The Player Died");
                        Hero.setCurrentHealthPoint(Hero.getMaxHealthPoint());
                        Boss.setCurrentHealthPoint(Boss.getMaxHealthPoint());
                        gameCounter = 1;
                        endTurn.setText("Reset Game");
                    }// end of the resetting condition
                }   // end of the monsters turn condition
                break;  // switch breaker for the button function.
        }
    }
}
