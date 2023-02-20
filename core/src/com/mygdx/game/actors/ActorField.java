package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorField extends Actor {

    private Texture jugator;
    public int info;

    public int price;
    public int states;
    public int check = 0;

    public ActorField(int info, int price, int states) {
        this.info = info;
        this.price = price;
        this.states = states;

    }

    public void setTexture(Texture jugator) {
        this.jugator = jugator;
        setSize(jugator.getWidth(), jugator.getHeight());
    }

    public void draw(Batch batch, float parentAlpha) {
        batch.draw(jugator, getX(), getY());
    }
}