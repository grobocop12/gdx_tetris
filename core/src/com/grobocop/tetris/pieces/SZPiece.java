package com.grobocop.tetris.pieces;

import com.badlogic.gdx.utils.Array;
import com.grobocop.tetris.Block;
import com.grobocop.tetris.Board;

import static com.grobocop.tetris.GameConstants.MAX_X;
import static com.grobocop.tetris.pieces.Orientation.HORIZONTAL;
import static com.grobocop.tetris.pieces.Orientation.VERTICAL;
import static com.grobocop.tetris.pieces.Rotation.CLOCKWISE;
import static com.grobocop.tetris.pieces.Rotation.COUNTER_CLOCKWISE;

public class SZPiece extends Piece {
    private Orientation orientation;

    public SZPiece(Array<Block> blocks, Orientation orientation) {
        super(blocks);
        this.orientation = orientation;
    }

    @Override
    public Block getRotationCenter() {
        return blocks.get(1);
    }

    @Override
    public void rotate(final Board board) {
        Block center = getRotationCenter();
        if (orientation == VERTICAL) {
            if (center.x == MAX_X) {
                tryMove(-1, 0, board);
            }
            if (rotateAroundPoint(board, center.x, center.y, COUNTER_CLOCKWISE)) {
                orientation = HORIZONTAL;
            }
        } else if (rotateAroundPoint(board, center.x, center.y, CLOCKWISE)) {
            orientation = VERTICAL;
        }
    }
}
