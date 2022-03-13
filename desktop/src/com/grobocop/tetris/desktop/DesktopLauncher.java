package com.grobocop.tetris.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.grobocop.tetris.Game;


public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = (int) Game.HEIGHT;
        config.width = (int) Game.WIDTH;
        config.forceExit = false;
        new LwjglApplication(new Game(), config);
    }
}
