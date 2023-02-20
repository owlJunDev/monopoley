package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MenuScreen extends BaseScreen {
    private final Stage stage;
    private final Skin skin;

    private final TextButton play;
    private final TextButton help;
    private final TextButton min;
    private final TextButton max;

    private final Label qty;
    private final Label title;

    private final int buttonWhite = Gdx.graphics.getWidth() / 3;
    private final int buttonHeight = Gdx.graphics.getHeight() / 5;
    private int sizePlayer = 2;

    public MenuScreen(final MainGame game) {
        super(game);
        stage = new Stage();
        skin = new Skin(Gdx.files.internal(game.skinStr));

        play = new TextButton("Play", skin, game.buttonStyle);
        play.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.gameScreen = new MainGameScreen(game, sizePlayer);
                game.setScreen(game.gameScreen);
            }
        });
        play.setSize(buttonWhite, buttonHeight);
        play.setPosition((Gdx.graphics.getWidth() / 2) - (play.getWidth() / 2),
                (Gdx.graphics.getHeight() / 3) - (play.getHeight() / 2));
        stage.addActor(play);

        min = new TextButton("<", skin, game.buttonStyle);
        min.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (sizePlayer > 2) {
                    sizePlayer--;
                    qty.setText("Players: " + sizePlayer);
                }
            }
        });
        min.setSize(buttonHeight / 2, buttonHeight / 2);
        min.setPosition(Gdx.graphics.getWidth() / 30, Gdx.graphics.getWidth() / 30);
        stage.addActor(min);

        qty = new Label("Players: " + sizePlayer, skin, game.styleName);
        qty.setPosition(min.getX() + min.getWidth() * 1.5f, min.getY() * 1.25f);
        stage.addActor(qty);

        max = new TextButton(">", skin, game.buttonStyle);
        max.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (sizePlayer < 4) {
                    sizePlayer++;
                    qty.setText("Players: " + sizePlayer);
                }

            }
        });
        max.setSize(buttonHeight / 2, buttonHeight / 2);
        max.setPosition(play.getX(), min.getY());
        stage.addActor(max);

        help = new TextButton("Help", skin);
        help.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.helpScreen = new HelpScreen(game, 2);
                game.setScreen(game.helpScreen);
            }
        });
        help.setSize(200,100);
        help.setPosition(Gdx.graphics.getWidth() - help.getWidth(), Gdx.graphics.getHeight() - help.getHeight());
        stage.addActor(help);


        title = new Label("Monopoly(KP)", skin, game.styleName);
        title.setPosition(play.getX(), (Gdx.graphics.getHeight() / 4) * 3);
        stage.addActor(title);


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