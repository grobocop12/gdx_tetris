package com.grobocop.tetris.pieces;

import com.badlogic.gdx.utils.Array;
import com.grobocop.tetris.Block;

public class TPiece extends Piece {
    public TPiece(Array<Block> blocks) {
        super(blocks);
    }

    @Override
    public Block getRotationCenter() {
        return blocks.get(0);
    }
}
