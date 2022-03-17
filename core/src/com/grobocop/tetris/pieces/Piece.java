package com.grobocop.tetris.pieces;

import com.badlogic.gdx.utils.Array;
import com.grobocop.tetris.Block;
import com.grobocop.tetris.Board;

import static com.grobocop.tetris.BlockType.NONE;
import static com.grobocop.tetris.Tetris.*;

public abstract class Piece {
    protected Array<Block> blocks;

    public Piece(Array<Block> blocks) {
        this.blocks = blocks;
    }

    public Array<Block> getBlocks() {
        return blocks;
    }

    public abstract Block getRotationCenter();

    public void rotate(Board board) {
        final Block center = this.getRotationCenter();
        for (int i = 0; i < blocks.size; i++) {
            int relativeX = blocks.get(i).x - center.x;
            int relativeY = blocks.get(i).y - center.y;
            int newX = relativeY + center.x;
            int newY = -relativeX + center.y;
            if (newX < MIN_X || newX > MAX_X || newY < MIN_Y) {
                return;
            }
            if (board.blockAt(newX, newY) != NONE) {
                return;
            }
        }
        for (int i = 0; i < blocks.size; i++) {
            int relativeX = blocks.get(i).x - center.x;
            int relativeY = blocks.get(i).y - center.y;
            int newX = relativeY + center.x;
            int newY = -relativeX + center.y;
            blocks.get(i).x = newX;
            blocks.get(i).y = newY;
        }
    }

    public boolean tryMove(int deltaX, int deltaY, Board board) {
        for (int i = 0; i < blocks.size; i++) {
            int newX = blocks.get(i).x + deltaX;
            int newY = blocks.get(i).y + deltaY;
            if (newX < MIN_X || newX > MAX_X || newY < MIN_Y) {
                return false;
            }
            if (board.blockAt(newX, newY) != NONE) {
                return false;
            }
        }
        for (Block block : blocks) {
            block.x += deltaX;
            block.y += deltaY;
        }
        return true;
    }
}
