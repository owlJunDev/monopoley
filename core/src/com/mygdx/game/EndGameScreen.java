package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class EndGameScreen extends BaseScreen {

    private Stage stage;
    private Skin skin;
    private TextButton retry, menu;

    public EndGameScreen(final MainGame game) {
        super(game);

        stage = new Stage();
        skin = new Skin(Gdx.files.internal(game.skinStr));

        retry = new TextButton("Back", skin, game.buttonStyle);
        {
            retry.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    game.setScreen(game.gameScreen);

                }
            });
            retry.setSize(200, 100);
            retry.setPosition((Gdx.graphics.getWidth() / 2) - (retry.getWidth() * 1.5f), 200);
            stage.addActor(retry);
        }

        menu = new TextButton("Menu", skin, game.buttonStyle);
        {
            menu.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    game.setScreen(game.menuScreen);

                }
            });
            menu.setSize(200, 100);
            menu.setPosition((Gdx.graphics.getWidth() / 2) + (retry.getWidth() * 0.5f), 200);
            stage.addActor(menu);
        }
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }


    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }
}
