package com.grobocop.tetris.pieces;

import com.badlogic.gdx.utils.Array;
import com.grobocop.tetris.Block;

import static com.grobocop.tetris.BlockType.*;
import static com.grobocop.tetris.pieces.Orientation.HORIZONTAL;
import static com.grobocop.tetris.pieces.Orientation.VERTICAL;

public class PieceFactory {
    public static IPiece createIPiece() {
        final Array<Block> blocks = new Array<>();
        blocks.add(new Block(5, 21, RED));
        blocks.add(new Block(5, 20, RED));
        blocks.add(new Block(5, 19, RED));
        blocks.add(new Block(5, 18, RED));
        return new IPiece(blocks, VERTICAL);
    }

    public static JPiece createJPiece() {
        final Array<Block> blocks = new Array<>();
        blocks.add(new Block(5, 19, BLUE));
        blocks.add(new Block(5, 18, BLUE));
        blocks.add(new Block(5, 17, BLUE));
        blocks.add(new Block(4, 17, BLUE));
        return new JPiece(blocks);
    }

    public static LPiece createLPiece() {
        final Array<Block> blocks = new Array<>();
        blocks.add(new Block(5, 19, YELLOW));
        blocks.add(new Block(5, 18, YELLOW));
        blocks.add(new Block(5, 17, YELLOW));
        blocks.add(new Block(6, 17, YELLOW));
        return new LPiece(blocks);
    }

    public static OPiece createOPiece() {
        final Array<Block> blocks = new Array<>();
        blocks.add(new Block(5, 19, GREEN));
        blocks.add(new Block(6, 19, GREEN));
        blocks.add(new Block(5, 18, GREEN));
        blocks.add(new Block(6, 18, GREEN));
        return new OPiece(blocks);
    }

    public static SPiece createSPiece() {
        final Array<Block> blocks = new Array<>();
        blocks.add(new Block(6, 19, PURPLE));
        blocks.add(new Block(5, 19, PURPLE));
        blocks.add(new Block(5, 18, PURPLE));
        blocks.add(new Block(4, 18, PURPLE));
        return new SPiece(blocks, HORIZONTAL);
    }

    public static TPiece createTPiece() {
        final Array<Block> blocks = new Array<>();
        blocks.add(new Block(4, 18, WHITE));
        blocks.add(new Block(5, 18, WHITE));
        blocks.add(new Block(3, 18, WHITE));
        blocks.add(new Block(4, 19, WHITE));
        return new TPiece(blocks);
    }

    public static ZPiece createZPiece() {
        final Array<Block> blocks = new Array<>();
        blocks.add(new Block(4, 19, DARK_BLUE));
        blocks.add(new Block(5, 19, DARK_BLUE));
        blocks.add(new Block(5, 18, DARK_BLUE));
        blocks.add(new Block(6, 18, DARK_BLUE));
        return new ZPiece(blocks, HORIZONTAL);
    }
}
