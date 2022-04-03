package com.grobocop.tetris.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.grobocop.tetris.TetrisGame;

public class TitleScreenInputHandler implements InputProcessor {
    private final TetrisGame tetrisGame;

    public TitleScreenInputHandler(TetrisGame tetrisGame) {
        this.tetrisGame = tetrisGame;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.SPACE) {
            this.tetrisGame.showGameScreen();
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
