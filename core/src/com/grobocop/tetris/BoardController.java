package com.grobocop.tetris;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.grobocop.tetris.pieces.Piece;
import com.grobocop.tetris.pieces.PieceGenerator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static com.grobocop.tetris.BlockType.NONE;
import static com.grobocop.tetris.GameConstants.*;

public class BoardController {

    private final Board board;
    private final PieceGenerator generator;
    private Piece piece;
    private boolean gameOver = false;

    public BoardController() {
        board = new Board(new BlockType[BOARD_HEIGHT * BOARD_WIDTH], BOARD_WIDTH, BOARD_HEIGHT);
        generator = new PieceGenerator(new Random());
        fillBoard();
        piece = generateNewPiece();
    }

    public boolean tryMove(int deltaX, int deltaY) {
        return this.piece.tryMove(deltaX, deltaY, board);
    }

    public void spawnNewPiece() {
        stopFallingPiece();
        removeFullRows();
        if (!trySpawnNewPiece()) {
            this.gameOver = true;
        }
    }

    public void hardDrop() {
        if (tryMove(0, -1)) {
            hardDrop();
        } else {
            spawnNewPiece();
        }
    }

    public void drawBoardAndFallingPiece(SpriteBatch batch,
                                         TextureResolver textureResolver,
                                         float blockHeight,
                                         float blockWidth) {
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                batch.draw(textureResolver.findTexture(board.blockAt(j, i)), j * blockHeight, i * blockWidth);
            }
        }
        for (Block block : piece.getBlocks()) {
            batch.draw(textureResolver.findTexture(block.blockType), block.x * blockHeight, block.y * blockWidth);
        }
    }

    public void rotate() {
        piece.rotate(board);
    }

    public Piece generateNewPiece() {
        return generator.generatePiece();
    }

    private boolean trySpawnNewPiece() {
        final Piece piece = generateNewPiece();
        for (Block block : piece.getBlocks()) {
            if (board.blockAt(block.x, block.y) != NONE) {
                return false;
            }
        }
        this.piece = piece;
        return true;
    }

    private void stopFallingPiece() {
        for (Block block : piece.getBlocks()) {
            if (block.y >= MAX_Y) {
                this.gameOver = true;
                return;
            }
            board.setBlock(block.x, block.y, block.blockType);
        }
    }

    private void removeFullRows() {
        final Set<Integer> removed = new HashSet<>();
        for (Block block : piece.getBlocks()) {
            if (board.removeRowIfFull(block.y)) {
                removed.add(block.y);
            }
        }
        removed.stream().sorted((a, b) -> -(a - b)).forEach(board::pullDownToRow);
    }

    private void fillBoard() {
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                board.setBlock(j, i, NONE);
            }
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
