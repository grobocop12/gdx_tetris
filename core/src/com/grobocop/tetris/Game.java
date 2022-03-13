package com.grobocop.tetris;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

import static com.grobocop.tetris.Tetris.BOARD_HEIGHT;
import static com.grobocop.tetris.Tetris.BOARD_WIDTH;


public class Game extends ApplicationAdapter {
    public static final float WIDTH = 400.0f;
    public static final float HEIGHT = 800.0f;
    public static final float BLOCK_HEIGHT = 40;
    public static final float BLOCK_WIDTH = 40;

    private SpriteBatch batch;
    private Texture redBlock;
    private Texture blueBlock;
    private Texture yellowBlock;
    private Texture greenBlock;
    private Texture purpleBlock;
    private Texture whiteBlock;
    private Texture darkBlueBlock;
    private Texture emptyBlockTexture;
    private OrthographicCamera camera;
    private Tetris tetris;
    private TextureResolver textureResolver;
    private long lastFallTime = 0L;

    @Override
    public void create() {
        batch = new SpriteBatch();
        loadTextures();
        textureResolver = new TextureResolver(emptyBlockTexture,
                redBlock,
                blueBlock,
                yellowBlock,
                greenBlock,
                purpleBlock,
                whiteBlock,
                darkBlueBlock);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, WIDTH, HEIGHT);
        tetris = new Tetris();
        Gdx.input.setInputProcessor(new InputHandler(tetris));
    }

    @Override
    public void render() {
        camera.update();
        draw();
        fall();
    }

    @Override
    public void dispose() {
        batch.dispose();
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
                spawnNewPiece();
            }
        }
    }

    private void draw() {
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        final Array<Block> blocks = tetris.getFallingBlocks();
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                batch.draw(textureResolver.findTexture(tetris.blockAt(j, i)),
                        j * BLOCK_HEIGHT,
                        i * BLOCK_WIDTH);
            }
        }
        for (Block block : blocks) {
            batch.draw(textureResolver.findTexture(block.blockType),
                    block.x * BLOCK_HEIGHT,
                    block.y * BLOCK_WIDTH);
        }
        batch.end();
    }

    private void spawnNewPiece() {
        tetris.stopFallingPiece();
        tetris.removeFullRows();
        tetris.trySpawnNewPiece();
    }
}
