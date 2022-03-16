package com.grobocop.tetris.pieces;

import com.badlogic.gdx.utils.Array;
import com.grobocop.tetris.Block;
import com.grobocop.tetris.Board;

import static com.grobocop.tetris.BlockType.NONE;
import static com.grobocop.tetris.Tetris.*;
import static com.grobocop.tetris.pieces.Orientation.HORIZONTAL;
import static com.grobocop.tetris.pieces.Orientation.VERTICAL;

public class IPiece extends Piece {
    private Orientation orientation;

    public IPiece(Array<Block> blocks, Orientation orientation) {
        super(blocks);
        this.orientation = orientation;
    }

    @Override
    public Block getRotationCenter() {
        return blocks.get(2);
    }

    @Override
    public void rotate(Board board) {
        final Block rotationCenter = getRotationCenter();
        if (orientation == VERTICAL) {
            setHorizontalOrientation(board);
        } else {
            setVerticalOrientation(board);
        }
    }

    private void setHorizontalOrientation(final Board board) {
        final Block rotationCenter = getRotationCenter();
        for (Block block : blocks) {
            int newY = rotationCenter.y;
            int newX = rotationCenter.x - (rotationCenter.y - block.y);
            if (newX < MIN_X || newX > MAX_X || newY < MIN_Y) {
                return;
            }
            if (board.blockAt(newX, newY) != NONE) {
                return;
            }
        }
        for (Block block : blocks) {
            block.x = rotationCenter.x - (rotationCenter.y - block.y);
            block.y = rotationCenter.y;
        }
        orientation = HORIZONTAL;
    }

    private void setVerticalOrientation(final Board board) {
        final Block rotationCenter = getRotationCenter();
        for (Block block : blocks) {
            int newY = rotationCenter.y - (rotationCenter.x - block.x);
            int newX = rotationCenter.x;
            if (newX < MIN_X || newX > MAX_X || newY < MIN_Y) {
                return;
            }
            if (board.blockAt(newX, newY) != NONE) {
                return;
            }
        }
        for (Block block : blocks) {
            block.y = rotationCenter.y - (rotationCenter.x - block.x);
            block.x = rotationCenter.x;
        }
        orientation = VERTICAL;
    }
}
