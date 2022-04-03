package com.grobocop.tetris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.grobocop.tetris.input.InputHandler;

import static com.grobocop.tetris.GameConstants.*;


public class GameScreen implements Screen {
    private final SpriteBatch batch;
    private Texture redBlock;
    private Texture blueBlock;
    private Texture yellowBlock;
    private Texture greenBlock;
    private Texture purpleBlock;
    private Texture whiteBlock;
    private Texture darkBlueBlock;
    private Texture emptyBlockTexture;
    private final OrthographicCamera camera;
    private final Tetris tetris;
    private final TextureResolver textureResolver;
    private long lastFallTime = 0L;

    public GameScreen(SpriteBatch batch, OrthographicCamera camera) {
        this.batch = batch;
        loadTextures();
        textureResolver = new TextureResolver(emptyBlockTexture,
                redBlock,
                blueBlock,
                yellowBlock,
                greenBlock,
                purpleBlock,
                whiteBlock,
                darkBlueBlock);
        this.camera = camera;
        camera.setToOrtho(false, WIDTH, HEIGHT);
        tetris = new Tetris();
        Gdx.input.setInputProcessor(new InputHandler(tetris));
    }

    @Override
    public void render(float delta) {
        draw();
        fall();
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        emptyBlockTexture.dispose();
        redBlock.dispose();
        blueBlock.dispose();
        yellowBlock.dispose();
        greenBlock.dispose();
        purpleBlock.dispose();
        whiteBlock.dispose();
        darkBlueBlock.dispose();
    }

    private void loadTextures() {
        emptyBlockTexture = new Texture("empty_block.png");
        redBlock = new Texture("red_block.png");
        blueBlock = new Texture("blue_block.png");
        yellowBlock = new Texture("yellow_block.png");
        greenBlock = new Texture("green_block.png");
        purpleBlock = new Texture("purple_block.png");
        whiteBlock = new Texture("white_block.png");
        darkBlueBlock = new Texture("dark_blue_block.png");
    }

    private void fall() {
        if (TimeUtils.millis() - lastFallTime > 500) {
            if (tetris.tryMove(0, -1)) {
                lastFallTime = TimeUtils.millis();
            } else {
                tetris.spawnNewPiece();
            }
        }
    }

    private void draw() {
        camera.update();
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        tetris.drawBoardAndFallingPiece(batch, textureResolver, BLOCK_HEIGHT, BLOCK_WIDTH);
        batch.end();
    }
}
