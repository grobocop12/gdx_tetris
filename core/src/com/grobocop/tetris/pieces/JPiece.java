package com.grobocop.tetris.pieces;

import com.badlogic.gdx.utils.Array;
import com.grobocop.tetris.Block;

public class JPiece extends Piece {

    public JPiece(Array<Block> blocks) {
        super(blocks);
    }

    @Override
    public Block getRotationCenter() {
        return blocks.get(1);
    }
}
