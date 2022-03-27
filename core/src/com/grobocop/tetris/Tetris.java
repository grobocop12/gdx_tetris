package com.grobocop.tetris;

import com.badlogic.gdx.utils.Array;
import com.grobocop.tetris.pieces.Piece;
import com.grobocop.tetris.pieces.PieceGenerator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static com.grobocop.tetris.BlockType.NONE;

public class Tetris {
    public static final byte MAX_X = 9;
    public static final byte MAX_Y = 19;
    public static final byte MIN_X = 0;
    public static final byte MIN_Y = 0;
    public static final byte BOARD_WIDTH = 10;
    public static final byte BOARD_HEIGHT = 20;

    private final Board board;
    private final PieceGenerator generator;
    private Piece piece;

    public Tetris() {
        board = new Board(new BlockType[BOARD_HEIGHT * BOARD_WIDTH], BOARD_WIDTH, BOARD_HEIGHT);
        generator = new PieceGenerator(new Random());
        fillBoard();
        piece = generateNewPiece();
    }

    private void fillBoard() {
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                setPiece(j, i, NONE);
            }
        }
    }

    public void setPiece(int x, int y, BlockType blockType) {
        board.setBlock(x, y, blockType);
    }

    public BlockType blockAt(int x, int y) {
        return board.blockAt(x, y);
    }

    public Array<Block> getFallingBlocks() {
        return piece.getBlocks();
    }

    public boolean tryMove(int deltaX, int deltaY) {
        return this.piece.tryMove(deltaX, deltaY, board);
    }

    public void fall() {
        while (tryMove(0, -1)) {

        }
        stopFallingPiece();
        removeFullRows();
        trySpawnNewPiece();
    }

    public void rotate() {
        piece.rotate(board);
    }

    public Piece generateNewPiece() {
        return generator.generatePiece();
    }

    public boolean trySpawnNewPiece() {
        final Piece piece = generateNewPiece();
        for (Block block : piece.getBlocks()) {
            if (blockAt(block.x, block.y) != NONE) {
                return false;
            }
        }
        this.piece = piece;
        return true;
    }

    public void stopFallingPiece() {
        for (Block block : piece.getBlocks()) {
            setPiece(block.x, block.y, block.blockType);
        }
    }

    public void removeFullRows() {
        final Set<Integer> removed = new HashSet<>();
        for (Block block : piece.getBlocks()) {
            if (board.removeRowIfFull(block.y)) {
                removed.add(block.y);
            }
        }
        removed.stream().sorted((a, b) -> -(a - b)).forEach(board::pullDownToRow);
    }
}
