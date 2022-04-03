package com.grobocop.tetris.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.grobocop.tetris.BoardController;

public class GameInputHandler implements InputProcessor {
    private final BoardController boardController;

    public GameInputHandler(BoardController boardController) {
        this.boardController = boardController;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
                boardController.rotate();
                break;
            case Input.Keys.DOWN:
                boardController.tryMove(0, -1);
                break;
            case Input.Keys.LEFT:
                boardController.tryMove(-1, 0);
                break;
            case Input.Keys.RIGHT:
                boardController.tryMove(1, 0);
                break;
            case Input.Keys.SPACE:
                boardController.hardDrop();
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
