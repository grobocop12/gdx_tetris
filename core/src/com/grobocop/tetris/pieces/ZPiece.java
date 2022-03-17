package com.grobocop.tetris.pieces;

import com.badlogic.gdx.utils.Array;
import com.grobocop.tetris.Block;
import com.grobocop.tetris.Board;

import static com.grobocop.tetris.BlockType.NONE;
import static com.grobocop.tetris.Tetris.*;
import static com.grobocop.tetris.pieces.Orientation.HORIZONTAL;
import static com.grobocop.tetris.pieces.Orientation.VERTICAL;

public class ZPiece extends Piece {
    private Orientation orientation;

    public ZPiece(Array<Block> blocks, Orientation orientation) {
        super(blocks);
        this.orientation = orientation;
    }

    @Override
    public Block getRotationCenter() {
        return blocks.get(1);
    }

    @Override
    public void rotate(final Board board) {
        Block rotationCenter = getRotationCenter();
        int deltaX = rotationCenter.x;
        int deltaY = rotationCenter.y;
        if (orientation == VERTICAL) {
            if (tryRotateToHorizontalPosition(board, deltaX, deltaY)) {
                orientation = HORIZONTAL;
            }
        } else {
            if (tryRotateToVerticalPosition(board, deltaX, deltaY)) {
                orientation = VERTICAL;
            }
        }
    }

    private boolean tryRotateToHorizontalPosition(final Board board, int centerX, int centerY) {
        for (Block block : blocks) {
            int newX = -(block.y - centerY) + centerX;
            int newY = block.x - centerX + centerY;
            if (newX < MIN_X || newX > MAX_X || newY < MIN_Y) {
                return false;
            }
            if (board.blockAt(newX, newY) != NONE) {
                return false;
            }
        }
        for (Block block : blocks) {
            int newX = -(block.y - centerY) + centerX;
            int newY = block.x - centerX + centerY;
            block.x = newX;
            block.y = newY;
        }
        return true;
    }


    private boolean tryRotateToVerticalPosition(Board board, int centerX, int centerY) {
        for (Block block : blocks) {
            int newX = block.y - centerY + centerX;
            int newY = -(block.x - centerX) + centerY;
            if (newX < MIN_X || newX > MAX_X || newY < MIN_Y) {
                return false;
            }
            if (board.blockAt(newX, newY) != NONE) {
                return false;
            }
        }
        for (Block block : blocks) {
            int newX = block.y - centerY + centerX;
            int newY = -(block.x - centerX) + centerY;
            block.x = newX;
            block.y = newY;
        }
        return true;
    }
}
