package com.grobocop.tetris;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.grobocop.tetris.input.GameInputHandler;
import com.grobocop.tetris.input.TitleScreenInputHandler;

public class TetrisGame extends Game {
    public SpriteBatch batch;
    public BitmapFont font;
    public OrthographicCamera camera;
    private TitleScreen titleScreen;
    private GameScreen gameScreen;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        camera = new OrthographicCamera();
        Gdx.input.setInputProcessor(new TitleScreenInputHandler(this));
        titleScreen = new TitleScreen(batch, font, camera);
        setScreen(titleScreen);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        titleScreen.dispose();
        gameScreen.dispose();
        super.dispose();
    }

    public void showGameScreen() {
        final BoardController boardController = new BoardController();
        Gdx.input.setInputProcessor(new GameInputHandler(boardController));
        gameScreen = new GameScreen(batch, camera, boardController);
        setScreen(gameScreen);
        titleScreen.dispose();
    }
}
