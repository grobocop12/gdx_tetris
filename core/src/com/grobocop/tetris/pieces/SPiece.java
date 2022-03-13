package com.grobocop.tetris.pieces;

import com.badlogic.gdx.utils.Array;
import com.grobocop.tetris.Block;

public class SPiece extends Piece {

    public SPiece(Array<Block> blocks) {
        super(blocks);
    }

    @Override
    public Block getRotationCenter() {
        final Block first = blocks.get(1);
        final Block second = blocks.get(2);
        if (first.y == second.y) {
            if (first.x < second.x) {
                return first;
            }
        } else {
            if (first.y < second.y) {
                return first;
            }
        }
        return second;
    }
}
