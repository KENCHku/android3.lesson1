package com.hfad.lesson1.data;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game<Content> {

    private List<Card<Content>> cards = new ArrayList<>();

    private boolean isGameOver = false;

    public Game(List<Content> contents) {
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>(false, false, contents.get(i), i + 1));
            cards.add(new Card<>(false, false, contents.get(i), i * (2 + 1)));
        }
        Collections.shuffle(cards);
    }

    public void choose(Card<Content> card) {

        card.setFaceUp(!card.isFaceUp());
        checkPair(card);
        gameFinished();
    }

    private void gameFinished() {
        if (cards.isEmpty()) {
            setGameOver(true);
        }

    }

    private void checkPair(Card<Content> card) {
        for (Card<Content> secondCard : cards) {
            Log.e("TAG", "for each is running: ");

            if (card.isFaceUp() && secondCard.isFaceUp()
                    && secondCard.getId() != card.getId()
                    && secondCard.equals(card)) {

                card.setMatched(true);
                secondCard.setMatched(true);

                removeCard();
                Log.e("TAG", "MATCH!");
                return;

            } else if (card.isFaceUp() && secondCard.isFaceUp()
                    && secondCard.getId() != card.getId()
                    && !secondCard.equals(card)) {

                android.os.Handler handler = new Handler();
                handler.postDelayed(() -> {

                    card.setFaceUp(false);
                    secondCard.setFaceUp(false);
                    Log.e("TAG", "we are in else if");

                }, 300);
            }
        }
    }

    private void removeCard() {
        Log.e("TAG", "removeCard: method is working  ");

        List<Card<Content>> resultCards = new ArrayList<>(cards);
        for (Card<Content> c : cards) {
            if (c.isMatched()) {
                resultCards.remove(c);
            }
        }
        cards.clear();
        cards.addAll(resultCards);

        if (cards.size() == 0) {
            //   isGameOver(context);
        }

    }


    public List<Card<Content>> getCard() {
        return cards;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }
}