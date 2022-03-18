package com.grobocop.tetris.pieces;

public enum Rotation {
    CLOCKWISE(1, -1),
    COUNTER_CLOCKWISE(-1, 1);

    public final int xSign;
    public final int ySign;

    Rotation(int xSign, int ySign) {
        this.xSign = xSign;
        this.ySign = ySign;
    }
}
