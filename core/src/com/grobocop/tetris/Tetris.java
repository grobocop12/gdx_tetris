package com.grobocop.tetris;

import com.badlogic.gdx.utils.Array;
import com.grobocop.tetris.pieces.Piece;
import com.grobocop.tetris.pieces.PieceFactory;
import com.grobocop.tetris.pieces.PieceGenerator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static com.grobocop.tetris.BlockType.NONE;
import static com.grobocop.tetris.BlockType.RED;

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
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                setPiece(j, i, RED);
            }
        }
        setPiece(8, 2, NONE);
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
        Array<Block> fallingBlocks = piece.getBlocks();
        for (int i = 0; i < piece.getBlocks().size; i++) {
            int newX = fallingBlocks.get(i).x + deltaX;
            int newY = fallingBlocks.get(i).y + deltaY;
            if (newX < MIN_X || newX > MAX_X || newY < MIN_Y) {
                return false;
            }
            if (blockAt(newX, newY) != NONE) {
                return false;
            }
        }
        for (Block block : fallingBlocks) {
            block.x += deltaX;
            block.y += deltaY;
        }
        return true;
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
//        return generator.generatePiece();
        return PieceFactory.createLPiece();
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
