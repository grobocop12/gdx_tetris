package com.grobocop.tetris.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.grobocop.tetris.GameScreen;
import com.grobocop.tetris.TetrisGame;


public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = (int) GameScreen.HEIGHT;
        config.width = (int) GameScreen.WIDTH;
        config.forceExit = false;
        new LwjglApplication(new TetrisGame(), config);
    }
}
