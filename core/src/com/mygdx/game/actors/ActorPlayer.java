package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorPlayer extends Actor {
    private Texture player;
    public int fiel;
    public int money;
    public boolean close;
    public int stClose;

    public ActorPlayer(Texture player) {
        this.player = player;
        close = false;
        stClose = 0;
        money = 2000;
        fiel = 0;
        setSize(this.player.getWidth(), this.player.getHeight());
    }

    public void act(float delta) {

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(player, getX(), getY());
    }
}