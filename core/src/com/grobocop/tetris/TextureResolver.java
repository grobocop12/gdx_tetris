package com.grobocop.tetris;

import com.badlogic.gdx.graphics.Texture;
import com.grobocop.tetris.BlockType;

public class TextureResolver {
    private final Texture none;
    private final Texture red;
    private final Texture blue;
    private final Texture yellow;
    private final Texture green;
    private final Texture purple;
    private final Texture white;
    private final Texture darkBlue;

    public TextureResolver(Texture none, Texture red, Texture blue, Texture yellow, Texture green, Texture purple, Texture white, Texture darkBlue) {
        this.none = none;
        this.red = red;
        this.blue = blue;
        this.yellow = yellow;
        this.green = green;
        this.purple = purple;
        this.white = white;
        this.darkBlue = darkBlue;
    }

    public Texture findTexture(BlockType type) {
        switch (type) {
            case RED:
                return red;
            case BLUE:
                return blue;
            case YELLOW:
                return yellow;
            case GREEN:
                return green;
            case PURPLE:
                return purple;
            case WHITE:
                return white;
            case DARK_BLUE:
                return darkBlue;
            default:
                return none;
        }
    }
}
