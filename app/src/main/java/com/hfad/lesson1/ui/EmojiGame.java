package com.hfad.lesson1.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.hfad.lesson1.data.Card;
import com.hfad.lesson1.data.Game;

import java.util.List;

import kg.geektech.android3.lesson1.R;

public class EmojiGame {

    private final Game<String> game;
    private final Context context;

    @RequiresApi(api = Build.VERSION_CODES.R)

    public EmojiGame(Context context) {
        this.context=context;
        List<String> content = List.of("❤", "🎃", "👹", "😎", "👽");
        game = new Game<>(content);
    }

    public void choose(Card<String> card) {
        game.choose(card);
        if (game.isGameOver()) {
            txtGameOver();
        }
    }
    private void txtGameOver() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(R.layout.alert_game_over_text).show();
    }

    public List<Card<String>> getCards() {
        return game.getCard();
    }
}
