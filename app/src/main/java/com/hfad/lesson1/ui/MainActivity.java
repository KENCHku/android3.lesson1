package com.hfad.lesson1.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.hfad.lesson1.data.Card;
import com.hfad.lesson1.data.Game;
import com.hfad.lesson1.ui.adapter.EmojiAdapter;

import kg.geektech.android3.lesson1.R;

public class MainActivity extends AppCompatActivity implements EmojiAdapter.Listener {

    private static final String TAG = "KKU";
    private RecyclerView recyclerView;
    private EmojiAdapter emojiAdapter;
    private EmojiGame emojiGame;
    private TextView tvGameOver;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvGameOver = findViewById(R.id.tvGameOver);
        recyclerView = findViewById(R.id.rv_card);
        emojiGame = new EmojiGame(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        emojiAdapter = new EmojiAdapter(emojiGame, this);
        recyclerView.setAdapter(emojiAdapter);
    }


    @Override
    public void cardClick(Card<String> card) {
        emojiGame.choose(card);
        Log.e(TAG, "cardClick: "+ card.getId());
        emojiAdapter.notifyDataSetChanged();

     /*   if (game.getCard().size()==0){
            tvGameOver.setVisibility(View.VISIBLE);
            tvGameOver.setText("Game Over!");
        }*/
    }
}