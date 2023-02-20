package com.mygdx.game;

import com.badlogic.gdx.Game;

public class MainGame extends Game {

    public MainGameScreen gameScreen;
    public EndGameScreen endGameScreen;
    public MenuScreen menuScreen;
    public HelpScreen helpScreen;
    public String skinStr = "skin/craftacular-ui.json";
    public String buttonStyle = "default";
    public String styleName = "default";

    @Override
    public void create() {
        menuScreen = new MenuScreen(this);
        endGameScreen = new EndGameScreen(this);
        setScreen(menuScreen);
    }

}