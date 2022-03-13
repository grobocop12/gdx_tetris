package com.grobocop.tetris.pieces;

import java.util.Random;

public class PieceGenerator {

    private final Random random;

    public PieceGenerator(Random random) {
        this.random = random;
    }

    public Piece generatePiece() {
        int pieceNumber = random.nextInt(7);
        switch (pieceNumber) {
            case 0:
                return PieceFactory.createIPiece();
            case 1:
                return PieceFactory.createJPiece();
            case 2:
                return PieceFactory.createLPiece();
            case 3:
                return PieceFactory.createOPiece();
            case 4:
                return PieceFactory.createSPiece();
            case 5:
                return PieceFactory.createTPiece();
            case 6:
                return PieceFactory.createZPiece();
            default:
                throw new RuntimeException("Out of range");
        }
    }
}
