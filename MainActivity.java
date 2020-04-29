package sg.edu.np.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button ButtonLeft;
    private Button ButtonMiddle;
    private Button ButtonRight;
    private Button[] ButtonList = new Button[3];
    private int Score = 0;
    private TextView ScoreView;
    private static final String TAG = "Whack-A-Mole";

    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonLeft = (Button) findViewById(R.id.ButtonLeft);
        ButtonMiddle = (Button) findViewById(R.id.ButtonMiddle);
        ButtonRight  = (Button) findViewById(R.id.ButtonRight);
        ButtonList[0] = ButtonLeft;
        ButtonList[1] = ButtonMiddle;
        ButtonList[2] = ButtonRight;
        ScoreView = (TextView) findViewById(R.id.ScoreView);

        ButtonLeft.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                if (ButtonLeft.getText() == "*"){
                    hit("Left");
                }
                else{
                    miss("Left");
                }
                ScoreView.setText(Integer.toString(Score));
                setNewMole();
            }
        });

        ButtonMiddle.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                if (ButtonMiddle.getText() == "*"){
                    hit("Middle");
                }
                else{
                    miss("Middle");
                }
                ScoreView.setText(Integer.toString(Score));
                setNewMole();
            }
        });

        ButtonRight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                if (ButtonRight.getText() == "*"){
                    hit("Right");
                }
                else{
                    miss("Right");
                }
                ScoreView.setText(Integer.toString(Score));
                setNewMole();
            }
        });

        Log.v(TAG, "Finished Pre-Initialisation!");
    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Starting GUI!");
    }


    public void setNewMole()
    {
        for (Button button : ButtonList){
            if (button.getText() == "*"){
                button.setText("O");
            }
        }

        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        ButtonList[randomLocation].setText("*");
    }

    public void hit(String buttonClicked)
    {
        Score += 1;
        Log.v(TAG, buttonClicked + " Button Clicked!\nHit, score added!");
    }

    public void miss(String buttonClicked)
    {
        if (Score > 0){
            Score -= 1;
        }
        Log.v(TAG, buttonClicked + " Button Clicked!\nMissed, point deducted!");
    }
}
