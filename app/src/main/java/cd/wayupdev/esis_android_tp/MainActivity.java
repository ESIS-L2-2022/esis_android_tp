package cd.wayupdev.esis_android_tp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.playBtn);
        imageView = findViewById(R.id.ic_dice);

        Random ran = new Random();

        int[] dices = {
                R.drawable.dice_1,
                R.drawable.dice_2,
                R.drawable.dice_3,
                R.drawable.dice_4,
                R.drawable.dice_5,
                R.drawable.dice_6,
        };
        button.setOnClickListener(v -> {
            int i = ran.nextInt(6);
            imageView.setImageResource(dices[i]);
            Toast.makeText(this, "" + (i+1), Toast.LENGTH_SHORT).show();
        });
    }
}