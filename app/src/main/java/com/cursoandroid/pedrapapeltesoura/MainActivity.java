package com.cursoandroid.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cursoandroid.pedrapapeltesoura.enums.Item;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void paperSelected(View view) {
        selectedItem(Item.PAPER);
    }

    public void rockSelected(View view) {
        selectedItem(Item.ROCK);
    }

    public void scissorsSelected(View view) {
        selectedItem(Item.SCISSORS);
    }

    public void selectedItem(Item userChoice) {
        int number = new Random().nextInt(3);
        Item[] choices = {Item.ROCK, Item.PAPER, Item.SCISSORS};
        Item appChoice = choices[number];

        executeGame(userChoice, appChoice);
    }

    public void executeGame(Item userChoice, Item appChoice) {
        ImageView resultImage = findViewById(R.id.resultImage);
        TextView text = findViewById(R.id.resultText);

        switch (appChoice) {
            case ROCK:
                resultImage.setImageResource(R.drawable.pedra);
                break;
            case PAPER:
                resultImage.setImageResource(R.drawable.papel);
                break;
            case SCISSORS:
                resultImage.setImageResource(R.drawable.tesoura);
        }

        if ((Item.ROCK.equals(userChoice) && Item.SCISSORS.equals(appChoice)) ||
                (Item.PAPER.equals(userChoice)&& Item.ROCK.equals(appChoice)) ||
                (Item.SCISSORS.equals(userChoice)&& Item.PAPER.equals(appChoice))) {

            text.setText("Você ganhou! :)");
        } else if ((Item.ROCK.equals(appChoice) && Item.SCISSORS.equals(userChoice)) ||
                (Item.PAPER.equals(appChoice)&& Item.ROCK.equals(userChoice)) ||
                (Item.SCISSORS.equals(appChoice)&& Item.PAPER.equals(userChoice))) {

            text.setText("Você perdeu! :(");
        } else {
            text.setText("Empatamos! ;)");
        }
    }
}
