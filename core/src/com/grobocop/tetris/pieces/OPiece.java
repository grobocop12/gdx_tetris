package com.grobocop.tetris.pieces;

import com.badlogic.gdx.utils.Array;
import com.grobocop.tetris.Block;
import com.grobocop.tetris.Board;

public class OPiece extends Piece {

    public OPiece(Array<Block> blocks) {
        super(blocks);
    }

    @Override
    public Block getRotationCenter() {
        return null;
    }

    @Override
    public void rotate(Board board) {
    }
}
