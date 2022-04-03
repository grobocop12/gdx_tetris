package com.grobocop.tetris;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.grobocop.tetris.input.TitleScreenInputHandler;

public class TetrisGame extends Game {
    public SpriteBatch batch;
    public BitmapFont font;
    public OrthographicCamera camera;
    private MainMenu mainMenu;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        camera = new OrthographicCamera();
        Gdx.input.setInputProcessor(new TitleScreenInputHandler(this));
        mainMenu = new MainMenu(batch, font, camera);
        setScreen(mainMenu);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        mainMenu.dispose();
        super.dispose();
    }

    public void showGameScreen() {
        setScreen(new GameScreen(batch, camera));
        mainMenu.dispose();
    }
}
