package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class HelpScreen extends BaseScreen {

    private Stage stage;
    private Skin skin;
    private TextButton back;


    public HelpScreen(final MainGame game, final int check) {
        super(game);

        stage = new Stage();
        skin = new Skin(Gdx.files.internal(game.skinStr));

        back = new TextButton("Back", skin, game.buttonStyle);
        {
            back.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    switch (check){
                        case 1:game.setScreen(game.gameScreen);break;
                        case 2:game.setScreen(game.menuScreen);break;
                    }


                }
            });
            back.setSize(200, 100);
            back.setPosition(Gdx.graphics.getWidth() - back.getWidth(), 0);
            stage.addActor(back);
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
