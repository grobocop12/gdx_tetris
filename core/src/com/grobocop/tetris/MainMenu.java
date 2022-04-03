package com.grobocop.tetris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.grobocop.tetris.GameConstants.HEIGHT;
import static com.grobocop.tetris.GameConstants.WIDTH;

public class MainMenu implements Screen {
    private final OrthographicCamera camera;
    private final SpriteBatch batch;
    private final BitmapFont font;

    public MainMenu(SpriteBatch batch, BitmapFont font, OrthographicCamera camera) {
        this.batch = batch;
        this.font = font;
        this.camera = camera;
        camera.setToOrtho(false, WIDTH, HEIGHT);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        font.draw(batch, "Welcome to Tetris ", 100, 150);
        font.draw(batch, "Press space to begin!", 100, 100);
        batch.end();
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

    }
}
