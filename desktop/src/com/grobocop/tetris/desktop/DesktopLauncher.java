package com.grobocop.tetris.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.grobocop.tetris.TetrisGame;

import static com.grobocop.tetris.GameConstants.HEIGHT;
import static com.grobocop.tetris.GameConstants.WIDTH;


public class DesktopLauncher {
    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setWindowedMode((int) WIDTH, (int) HEIGHT);
        new Lwjgl3Application(new TetrisGame(), config);
    }
}
