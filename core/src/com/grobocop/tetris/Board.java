package com.grobocop.tetris;

import static com.grobocop.tetris.BlockType.NONE;

public class Board {
    private final BlockType[] boardBlocks;
    private final int boardWidth;
    private final int boardHeight;

    public Board(BlockType[] boardBlocks, int boardWidth, int boardHeight) {
        this.boardBlocks = boardBlocks;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public BlockType blockAt(int x, int y) {
        if (y < boardHeight) {
            return boardBlocks[boardWidth * y + x];
        } else {
            return NONE;
        }
    }

    public void setBlock(int x, int y, BlockType blockType) {
        boardBlocks[boardWidth * y + x] = blockType;
    }

    public boolean removeRowIfFull(int y) {
        for (int i = 0; i < boardWidth; i++) {
            if (blockAt(i, y) == NONE) {
                return false;
            }
        }
        for (int i = 0; i < boardWidth; i++) {
            setBlock(i, y, NONE);
        }
        return true;
    }

    public void pullDownToRow(int y) {
        for (int i = y; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                setBlock(j, i, blockAt(j, i + 1));
            }
        }
    }
}
