package com.grobocop.tetris;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor {
    private final Tetris tetris;

    public InputHandler(Tetris tetris) {
        this.tetris = tetris;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
                tetris.rotate();
                break;
            case Input.Keys.DOWN:
                tetris.tryMove(0, -1);
                break;
            case Input.Keys.LEFT:
                tetris.tryMove(-1, 0);
                break;
            case Input.Keys.RIGHT:
                tetris.tryMove(1, 0);
                break;
            case Input.Keys.SPACE:
                tetris.hardDrop();
                break;
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
