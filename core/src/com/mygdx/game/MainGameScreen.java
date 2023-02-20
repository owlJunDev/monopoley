package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.actors.ActorField;
import com.mygdx.game.actors.ActorPlayer;

import org.w3c.dom.Text;

import java.util.Random;

import jdk.nashorn.internal.ir.LabelNode;

public class MainGameScreen extends BaseScreen {

    private Stage stage;
    private Skin skin;

    private ActorField fields[];
    private ActorPlayer player[];


    private Texture texturaField[];
    private Texture textureInfoPl[];
    private Texture textureCheckPlFi[];
    private Texture playDice[];
    private Texture texturaPlayer[];

    private Image imgDice[];
    private Image infoPl[];
    private Image checkedPlFi[];
    private Image backGround;
    private Image info;

    private ImageButton dice;
    private TextButton exit;
    private TextButton help;

    private Label money[];
    private Label test;
    private Label bank;

    private int sizeX = 80, sizeY = 60;
    private int players;
    private int bankMoney = 0;
    private int iteration = 0;
    private int testInt;
    private int buyFl = 0;
    private int itPl;
    private int paramPl;
    private int kPl[] = new int[4];
    private int lPl[] = new int[4];
    private Random rn;

    private void fieldConfig() {
        fields[0] = new ActorField(0, 0, 8);
        fields[1] = new ActorField(1, 50, 0);
        fields[2] = new ActorField(1, 60, 0);
        fields[3] = new ActorField(9, 0, 5);
        fields[4] = new ActorField(1, 70, 0);
        fields[5] = new ActorField(13, 0, 6);
        fields[6] = new ActorField(2, 90, 0);
        fields[7] = new ActorField(2, 100, 0);
        fields[8] = new ActorField(11, 0, 7);
        fields[9] = new ActorField(2, 110, 0);

        fields[10] = new ActorField(15, 0, 10);
        fields[11] = new ActorField(3, 130, 0);
        fields[12] = new ActorField(3, 140, 0);
        fields[13] = new ActorField(10, 0, 5);
        fields[14] = new ActorField(3, 150, 0);
        fields[15] = new ActorField(14, 0, 9);
        fields[16] = new ActorField(4, 170, 0);
        fields[17] = new ActorField(4, 180, 0);
        fields[18] = new ActorField(12, 0, 7);
        fields[19] = new ActorField(4, 190, 0);

        fields[20] = new ActorField(16, 0, 8);
        fields[21] = new ActorField(5, 210, 0);
        fields[22] = new ActorField(9, 0, 5);
        fields[23] = new ActorField(5, 220, 0);
        fields[24] = new ActorField(5, 230, 0);
        fields[25] = new ActorField(13, 0, 6);
        fields[26] = new ActorField(6, 250, 0);
        fields[27] = new ActorField(11, 0, 7);
        fields[28] = new ActorField(6, 260, 0);
        fields[29] = new ActorField(6, 270, 0);

        fields[30] = new ActorField(17, 0, 11);
        fields[31] = new ActorField(7, 290, 0);
        fields[32] = new ActorField(10, 0, 5);
        fields[33] = new ActorField(7, 300, 0);
        fields[34] = new ActorField(7, 310, 0);
        fields[35] = new ActorField(14, 0, 9);
        fields[36] = new ActorField(8, 330, 0);
        fields[37] = new ActorField(12, 0, 7);
        fields[38] = new ActorField(8, 340, 0);
        fields[39] = new ActorField(8, 350, 0);
        //*/
    }

    private void fieldPosition() {
        //down
        fields[0].setPosition(sizeY * 9 + sizeX, Gdx.graphics.getHeight() - (sizeY * 9 + sizeX * 2));

        fields[1].setPosition(fields[0].getX() - sizeY * 1, fields[0].getY());
        fields[2].setPosition(fields[0].getX() - sizeY * 2, fields[0].getY());
        fields[3].setPosition(fields[0].getX() - sizeY * 3, fields[0].getY());
        fields[4].setPosition(fields[0].getX() - sizeY * 4, fields[0].getY());
        fields[5].setPosition(fields[0].getX() - sizeY * 5, fields[0].getY());
        fields[6].setPosition(fields[0].getX() - sizeY * 6, fields[0].getY());
        fields[7].setPosition(fields[0].getX() - sizeY * 7, fields[0].getY());
        fields[8].setPosition(fields[0].getX() - sizeY * 8, fields[0].getY());
        fields[9].setPosition(fields[0].getX() - sizeY * 9, fields[0].getY());

        //left
        fields[10].setPosition(fields[0].getX() - (sizeY * 9 + sizeX), fields[0].getY());

        fields[11].setPosition(fields[10].getX(), fields[10].getY() + fields[10].getHeight() + fields[11].getHeight() * 0);
        fields[12].setPosition(fields[10].getX(), fields[10].getY() + fields[10].getHeight() + fields[12].getHeight() * 1);
        fields[13].setPosition(fields[10].getX(), fields[10].getY() + fields[10].getHeight() + fields[13].getHeight() * 2);
        fields[14].setPosition(fields[10].getX(), fields[10].getY() + fields[10].getHeight() + fields[14].getHeight() * 3);
        fields[15].setPosition(fields[10].getX(), fields[10].getY() + fields[10].getHeight() + fields[15].getHeight() * 4);
        fields[16].setPosition(fields[10].getX(), fields[10].getY() + fields[10].getHeight() + fields[16].getHeight() * 5);
        fields[17].setPosition(fields[10].getX(), fields[10].getY() + fields[10].getHeight() + fields[17].getHeight() * 6);
        fields[18].setPosition(fields[10].getX(), fields[10].getY() + fields[10].getHeight() + fields[18].getHeight() * 7);
        fields[19].setPosition(fields[10].getX(), fields[10].getY() + fields[10].getHeight() + fields[19].getHeight() * 8);

        //up
        fields[20].setPosition(fields[10].getX(), fields[10].getY() + fields[10].getHeight() + fields[19].getHeight() * 9);

        fields[21].setPosition(fields[20].getX() + sizeX + sizeY * 0, fields[20].getY());
        fields[22].setPosition(fields[20].getX() + sizeX + sizeY * 1, fields[20].getY());
        fields[23].setPosition(fields[20].getX() + sizeX + sizeY * 2, fields[20].getY());
        fields[24].setPosition(fields[20].getX() + sizeX + sizeY * 3, fields[20].getY());
        fields[25].setPosition(fields[20].getX() + sizeX + sizeY * 4, fields[20].getY());
        fields[26].setPosition(fields[20].getX() + sizeX + sizeY * 5, fields[20].getY());
        fields[27].setPosition(fields[20].getX() + sizeX + sizeY * 6, fields[20].getY());
        fields[28].setPosition(fields[20].getX() + sizeX + sizeY * 7, fields[20].getY());
        fields[29].setPosition(fields[20].getX() + sizeX + sizeY * 8, fields[20].getY());

        //right
        fields[30].setPosition(fields[20].getX() + sizeX + sizeY * 9, fields[20].getY());

        fields[31].setPosition(fields[30].getX(), fields[30].getY() - sizeY);
        fields[32].setPosition(fields[30].getX(), fields[31].getY() - sizeY);
        fields[33].setPosition(fields[30].getX(), fields[32].getY() - sizeY);
        fields[34].setPosition(fields[30].getX(), fields[33].getY() - sizeY);
        fields[35].setPosition(fields[30].getX(), fields[34].getY() - sizeY);
        fields[36].setPosition(fields[30].getX(), fields[35].getY() - sizeY);
        fields[37].setPosition(fields[30].getX(), fields[36].getY() - sizeY);
        fields[38].setPosition(fields[30].getX(), fields[37].getY() - sizeY);
        fields[39].setPosition(fields[30].getX(), fields[38].getY() - sizeY);
        //*/
    }

    private void playerPosition(int i) {
        switch (i) {
            case 0: {
                player[0].setPosition(fields[player[0].fiel].getX() + fields[player[0].fiel].getWidth() / 6,
                        fields[player[0].fiel].getY() + fields[player[0].fiel].getHeight() / 6 * 4);
            }
            break;
            case 1: {
                player[1].setPosition(fields[player[1].fiel].getX() + fields[player[1].fiel].getWidth() / 6,
                        fields[player[1].fiel].getY() + fields[player[1].fiel].getHeight() / 6);
            }
            break;
            case 2: {
                player[2].setPosition(fields[player[2].fiel].getX() + fields[player[2].fiel].getWidth() / 6 * 4,
                        fields[player[2].fiel].getY() + fields[player[2].fiel].getHeight() / 6 * 4);
            }
            break;
            case 3: {
                player[3].setPosition(fields[player[3].fiel].getX() + fields[player[3].fiel].getWidth() / 6 * 4,
                        fields[player[3].fiel].getY() + fields[player[3].fiel].getHeight() / 6);
            }
            break;
        }

    }

    private void buy() {

        fields[paramPl].states = itPl + 1;
        checkedPlFi[fields[paramPl].check - 1] = new Image(textureCheckPlFi[itPl]);
        checkedPlFi[fields[paramPl].check - 1].setPosition(fields[paramPl].getX(), fields[paramPl].getY());
        stage.addActor(checkedPlFi[fields[paramPl].check - 1]);

        player[itPl].money -= fields[paramPl].price;
        fields[paramPl].price = ((fields[paramPl].price / 10) + 15);
        buyFl = 0;

    }

    private void tick(final int i) {
        int k = 0, l = -1, f;
        Dialog d;
        rn = new Random();

        if (player[i].close == false) {
            {
                k = rn.nextInt(500) % 6 + 1;
                imgDice[0] = new Image(playDice[k - 1]);
                imgDice[0].setPosition(fields[5].getX() - imgDice[0].getWidth(), (fields[15].getY() + fields[15].getHeight() / 2) - imgDice[0].getWidth() / 2);
                stage.addActor(imgDice[0]);
                rn = new Random();
            }
            {
                l = rn.nextInt(500) % 6 + 1;
                imgDice[1] = new Image(playDice[l - 1]);
                imgDice[1].setPosition(fields[4].getX(), (fields[15].getY() + fields[15].getHeight() / 2) - imgDice[0].getWidth() / 2);
                stage.addActor(imgDice[1]);
            }
            player[i].fiel += k + l;
        }
        if (player[i].fiel > 39) {
            player[i].fiel -= 40;
            player[i].money += 200;
        }
        f = player[i].fiel;
        paramPl = f;
        itPl = i;

        /*v*/
        if (fields[f].states == 0) {
            dice.setVisible(false);
            new Dialog("", skin) {
                {
                    text(" Buy or No\nFant: " + fields[player[i].fiel].price);
                    button("\t\tyes", 1);
                    button("no\t\t\t", 0);
                }

                @Override
                public void setPosition(float x, float y) {
                    super.setPosition(dice.getX(), dice.getY() + dice.getHeight());
                }

                @Override
                public void setSize(float width, float height) {
                    super.setSize(360, 240);
                }

                @Override
                protected void result(Object object) {
                    super.result(object);
                    buyFl = (int) object;
                    dice.setVisible(true);
                    if (buyFl == 1)
                        buy();
                }
            }.show(stage);
        }
        /*v*/
        if (fields[f].states > 0 && fields[f].states < 5 && (fields[f].states - 1) != i) {

            dice.setVisible(false);
            new Dialog("", skin) {
                {
                    text("You lost " + fields[player[i].fiel].price + " Fant");
                    button("ok");
                }

                @Override
                public void setPosition(float x, float y) {
                    super.setPosition(dice.getX(), dice.getY() + dice.getHeight());
                }

                @Override
                public void setSize(float width, float height) {
                    super.setSize(360, 240);
                }

                @Override
                protected void result(Object object) {
                    super.result(object);
                    player[i].money -= fields[player[i].fiel].price;
                    player[fields[player[i].fiel].states - 1].money += fields[player[i].fiel].price;
                    dice.setVisible(true);
                }
            }.show(stage);
        }
        /*v*/
        if (fields[f].states == 6) {
            //WhileBisnes
            player[i].money += bankMoney;
            bankMoney = 0;
            bank.setText("Bank: " + bankMoney);
        }
        /*v*/
        if (fields[f].states == 9) {
            //DarkBisnes
            player[i].money -= 50;
            bankMoney += 50;
            bank.setText("Bank: " + bankMoney);
        }
        /*x*/
        if (fields[f].states == 5) {
            //Shans
            String strName = new String();
            String strFirst = new String();
            String strSecond = new String();
            final int n = rn.nextInt(500) % 3;
            final int per = (rn.nextInt(500) % 5 + 1) * 10;
            final int percent = player[i].money / 100 * per;
            switch (n) {
                case 0:
                    strName = "bad credit";
                    strFirst = "you have lost\n";
                    strSecond = "% of your capital";
                    player[i].money -= percent;
                    break;
                case 1:
                    strName = "good credit";
                    strFirst = "you have acquired\n";
                    strSecond = "% of your capital";
                    player[i].money += percent;
                    break;
                case 2:
                    strName = "bet";
                    strFirst = "  you won the bet";
                    strSecond = "\n  you acquired " + (100 * (players - 1)) + "Fant";
                    for(int j = 0; j < players; j++)
                    {
                        player[j].money -= 100;
                    }
                    player[i].money += 100 * players;
                    break;
            }
            final String finalStrFirst = strFirst;
            final String finalStrSecond = strSecond;
            new Dialog(strName + "", skin) {
                {
                    if(n != 2)
                    text(finalStrFirst + per + finalStrSecond);
                    else text(finalStrFirst + finalStrSecond);
                    button("ok");
                }

                @Override
                public void setPosition(float x, float y) {
                    super.setPosition(dice.getX(), dice.getY() + dice.getHeight());
                }

                @Override
                public void setSize(float width, float height) {
                    super.setSize(480, 240);
                }

                @Override
                protected void result(Object object) {
                    super.result(object);
                }
            }.show(stage);
        }
        /*x*/
        if (fields[f].states == 7) {
            //Move
            test.setText("Move");
        }
        /*v*/
        if (fields[f].states == 11) {
            //Car
            player[i].fiel = 10;
            player[i].close = true;
            new Dialog("", skin) {
                {
                    text("You got to the\n police station");
                    button("ok");
                }

                @Override
                public void setPosition(float x, float y) {
                    super.setPosition(dice.getX(), dice.getY() + dice.getHeight());
                }

                @Override
                public void setSize(float width, float height) {
                    super.setSize(360, 240);
                }

                @Override
                protected void result(Object object) {
                    super.result(object);
                }
            }.show(stage);
        }
        /*v*/
        if (fields[f].states == 10) {
            //Men
            if (player[i].close == true) {
                new Dialog("", skin) {
                    {
                        text("Double or 50 Fant");
                        button("\t\tdouble", 0);
                        button("50 Fant\t\t\t", 1);
                    }

                    @Override
                    public void setPosition(float x, float y) {
                        super.setPosition(dice.getX(), dice.getY() + dice.getHeight());
                    }

                    @Override
                    public void setSize(float width, float height) {
                        super.setSize(360, 240);
                    }

                    @Override
                    protected void result(Object object) {
                        super.result(object);
                        dice.setVisible(true);
                        if ((int) object == 1 || player[i].stClose >= 3) {
                            player[i].close = false;
                            player[i].stClose = 0;
                            player[i].money -= 50;
                            if (player[i].stClose >= 3)
                                text("Oops, try end");
                        } else {
                            int a, b;
                            {
                                a = rn.nextInt(500) % 6 + 1;
                                imgDice[0] = new Image(playDice[a - 1]);
                                imgDice[0].setPosition(fields[5].getX() - imgDice[0].getWidth(), (fields[15].getY() + fields[15].getHeight() / 2) - imgDice[0].getWidth() / 2);
                                stage.addActor(imgDice[0]);
                                rn = new Random();
                            }
                            {
                                b = rn.nextInt(500) % 6 + 1;
                                imgDice[1] = new Image(playDice[b - 1]);
                                imgDice[1].setPosition(fields[4].getX(), (fields[15].getY() + fields[15].getHeight() / 2) - imgDice[0].getWidth() / 2);
                                stage.addActor(imgDice[1]);
                            }
                            if (a == b) {
                                player[i].close = false;
                                player[i].fiel += a + b;
                                playerPosition(i);
                            } else player[i].stClose++;
                        }
                    }
                }.show(stage);
            } else {
                player[i].close = true;
                new Dialog("", skin) {
                    {
                        text("You got to the\n police station");
                        button("ok");
                    }

                    @Override
                    public void setPosition(float x, float y) {
                        super.setPosition(dice.getX(), dice.getY() + dice.getHeight());
                    }

                    @Override
                    public void setSize(float width, float height) {
                        super.setSize(360, 240);
                    }

                    @Override
                    protected void result(Object object) {
                        super.result(object);
                    }
                }.show(stage);
            }
        }

        if (k != l || player[i].close == true) {
            iteration++;
            if (iteration >= players) iteration = 0;
        }
        info.setPosition(infoPl[iteration].getX() - info.getWidth(), infoPl[iteration].getY());
        playerPosition(i);

    }

    public MainGameScreen(final MainGame game, int players) {
        super(game);
        this.players = players;
        stage = new Stage();

        {
            texturaField = new Texture[]{
                    new Texture("field/fieldStart.png"),
                    new Texture("field/C1.png"),
                    new Texture("field/C2.png"),
                    new Texture("field/C3.png"),
                    new Texture("field/C4.png"),
                    new Texture("field/C5.png"),
                    new Texture("field/C6.png"),
                    new Texture("field/C7.png"),
                    new Texture("field/C8.png"),
                    new Texture("field/fieldShansDown.png"),//9
                    new Texture("field/fieldShansLeft.png"),//10
                    new Texture("field/fieldMoveDown.png"),//11
                    new Texture("field/fieldMoveLeft.png"),//12
                    new Texture("field/fieldWhileBisnes.png"),//13
                    new Texture("field/fieldDarkBisnes.png"),//14
                    new Texture("field/fieldMen.png"),//15
                    new Texture("field/field.png"),//16
                    new Texture("field/fieldCar.png"),//17
            };
            playDice = new Texture[]{
                    new Texture("dice/d1.png"),
                    new Texture("dice/d2.png"),
                    new Texture("dice/d3.png"),
                    new Texture("dice/d4.png"),
                    new Texture("dice/d5.png"),
                    new Texture("dice/d6.png"),
            };
            textureInfoPl = new Texture[]{
                    new Texture("menInf/menInf1.png"),
                    new Texture("menInf/menInf2.png"),
                    new Texture("menInf/menInf3.png"),
                    new Texture("menInf/menInf4.png"),
            };

            texturaPlayer = new Texture[]{
                    new Texture("plF/pl1.png"),
                    new Texture("plF/pl2.png"),
                    new Texture("plF/pl3.png"),
                    new Texture("plF/pl4.png"),
            };

            textureCheckPlFi = new Texture[]{
                    new Texture("cF/pl1.png"),
                    new Texture("cF/pl2.png"),
                    new Texture("cF/pl3.png"),
                    new Texture("cF/pl4.png"),
            };
        }

        infoPl = new Image[]{
                new Image(textureInfoPl[0]),
                new Image(textureInfoPl[1]),
                new Image(textureInfoPl[2]),
                new Image(textureInfoPl[3]),
        };

        for (int i = 0; i < players; i++) {

            infoPl[i].setPosition(Gdx.graphics.getWidth() / 5 * 3,
                    Gdx.graphics.getHeight() - infoPl[i].getHeight() * (i + 1));
            stage.addActor(infoPl[i]);
        }

        info = new Image(new Texture("inf.png"));
        info.setPosition(infoPl[0].getX() - info.getWidth(), infoPl[0].getY());
        stage.addActor(info);

        fields = new ActorField[40];
        {
            fieldConfig();
            for (int i = 0; i < fields.length; i++)
                fields[i].setTexture(texturaField[fields[i].info]);
            fieldPosition();
            for (int i = 0, j = 0; i < fields.length; i++) {
                stage.addActor(fields[i]);
                if (fields[i].states == 0) {
                    j++;
                    fields[i].check = j;
                }
            }
        }

        player = new ActorPlayer[4];
        for (int i = 0; i < players; i++) {
            player[i] = new ActorPlayer(texturaPlayer[i]);
            stage.addActor(player[i]);
            playerPosition(i);
        }
        checkedPlFi = new Image[24];
        for (int i = 0; i < 24; i++)
            checkedPlFi[i] = new Image(textureCheckPlFi[0]);

        backGround = new Image(new Texture("backGround.jpg"));
        backGround.setPosition(fields[10].getX() + fields[10].getWidth(),
                fields[10].getY() + fields[10].getHeight());
        stage.addActor(backGround);

        imgDice = new Image[2];

        skin = new Skin(Gdx.files.internal(game.skinStr));
        dice = new ImageButton(skin);
        {
            dice.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("dice.png"))));
            dice.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("dice.png"))));
            dice.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    tick(iteration);
                }
            });
            dice.setSize(100, 100);
            dice.setPosition(sizeX * 10, fields[0].getY());
            stage.addActor(dice);
        }

        exit = new TextButton("Pause", skin);
        {
            exit.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    game.setScreen(game.endGameScreen);
                }
            });
            exit.setSize(dice.getWidth() * 2, dice.getHeight());
            exit.setPosition(Gdx.graphics.getWidth() - exit.getWidth(), Gdx.graphics.getHeight() - exit.getHeight());
            stage.addActor(exit);
        }

        help = new TextButton("Help", skin);
        {
            help.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    game.helpScreen = new HelpScreen(game, 1);
                    game.setScreen(game.helpScreen);
                }
            });
            help.setSize(dice.getWidth() * 2, dice.getHeight());
            help.setPosition(Gdx.graphics.getWidth() - exit.getWidth(), exit.getY() - help.getHeight());
            stage.addActor(help);
        }

        test = new Label("", skin, game.styleName);
        test.setPosition(dice.getX() + dice.getWidth() * 2, dice.getY());
        stage.addActor(test);

        money = new Label[4];
        {
            money[0] = new Label("Fant 2000", skin, game.styleName);
            money[1] = new Label("Fant 2000", skin, game.styleName);
            money[2] = new Label("Fant 2000", skin, game.styleName);
            money[3] = new Label("Fant 2000", skin, game.styleName);
        }
        for (int i = 0; i < players; i++) {
            money[i].setPosition(infoPl[i].getX() + infoPl[i].getWidth() + 10, infoPl[i].getY());
            stage.addActor(money[i]);
        }

        bank = new Label("Bank" + bankMoney, skin, game.styleName);
        bank.setPosition(fields[5].getX(), fields[0].getY() + fields[0].getHeight());
        stage.addActor(bank);

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    private void updateLabel(){
        for(int i = 0; i < players; i++)
            money[i].setText("Fant " + player[i].money);
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);//255 102 0
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        updateLabel();
        stage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}