package com.grobocop.tetris.pieces;

import com.badlogic.gdx.utils.Array;
import com.grobocop.tetris.Block;
import com.grobocop.tetris.Board;

import static com.grobocop.tetris.BlockType.NONE;
import static com.grobocop.tetris.GameConstants.*;
import static com.grobocop.tetris.pieces.Rotation.CLOCKWISE;

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
        rotateAroundPoint(board, center.x, center.y, CLOCKWISE);
    }

    protected boolean rotateAroundPoint(final Board board, int centerX, int centerY, Rotation r) {
        for (Block block : blocks) {
            int newX = r.xSign * (block.y - centerY) + centerX;
            int newY = r.ySign * (block.x - centerX) + centerY;
            if (newX < MIN_X || newX > MAX_X || newY < MIN_Y) {
                return false;
            }
            if (board.blockAt(newX, newY) != NONE) {
                return false;
            }
        }
        for (Block block : blocks) {
            int newX = r.xSign * (block.y - centerY) + centerX;
            int newY = r.ySign * (block.x - centerX) + centerY;
            block.x = newX;
            block.y = newY;
        }
        return true;
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
