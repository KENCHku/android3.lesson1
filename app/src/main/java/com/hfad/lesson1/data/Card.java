package com.hfad.lesson1.data;

import java.util.Objects;

public class Card<CardContent> {

    private boolean isFaceUp;
    private boolean isMatched;
    private CardContent content;
    private int id;

    public Card(CardContent content) {
        this.content = content;
    }

    public Card(boolean isFaceUp,
                boolean isMatched,
                CardContent content,
                int id) {
        this.isFaceUp = isFaceUp;
        this.isMatched = isMatched;
        this.content = content;
        this.id = id;
    }


    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public CardContent getContent() {
        return content;
    }

    public void setContent(CardContent content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card<?> card = (Card<?>) o;
        return Objects.equals(content, card.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isFaceUp, isMatched, content, id);
    }

    @Override
    public String toString() {
        return "Card{" +
                "isFacedUp=" + isFaceUp +
                ", isMatched=" + isMatched +
                ", content=" + content +
                ", id=" + id +
                '}';
    }
}
