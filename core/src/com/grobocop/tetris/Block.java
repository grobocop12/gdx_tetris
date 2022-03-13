package com.grobocop.tetris;

public class Block {
    public int x;
    public int y;
    public BlockType blockType;

    public Block(int x, int y, BlockType blockType) {
        this.x = x;
        this.y = y;
        this.blockType = blockType;
    }
}
