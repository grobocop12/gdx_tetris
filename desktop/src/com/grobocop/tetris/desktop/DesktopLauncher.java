package com.grobocop.tetris.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.grobocop.tetris.TetrisGame;

import static com.grobocop.tetris.GameConstants.HEIGHT;
import static com.grobocop.tetris.GameConstants.WIDTH;


public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = (int) HEIGHT;
        config.width = (int) WIDTH;
        config.forceExit = false;
        new LwjglApplication(new TetrisGame(), config);
    }
}
