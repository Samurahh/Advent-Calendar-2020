package com.spartaglobal.day5;

public class BoardingPass {
    public static final int ROW_RANGE = 127; //0 - 127
    public static final int COLUMN_RANGE = 7; //0 - 7

    private char[] binaryPosition;

    public BoardingPass(String binaryPosition) {
        this.binaryPosition = binaryPosition.toCharArray();
    }

    public int getRow() {
        int leftPosition = 0;
        int rightPosition = ROW_RANGE;
        for (int i = 0; i < 6; i++) {
            if (binaryPosition[i] == 'B') {
                leftPosition = (leftPosition + rightPosition + 1) / 2;
            } else if (binaryPosition[i] == 'F') {
                rightPosition = (rightPosition + leftPosition) / 2;
            }
        }
        if (binaryPosition[6] == 'F') {
            return leftPosition;
        } else if (binaryPosition[6] == 'B') {
            return rightPosition;
        } else {
            return -1;
        }
    }

    public int getColumn() {
        int leftPosition = 0;
        int rightPosition = COLUMN_RANGE;
        for (int i = 7; i < 9; i++) {
            if (binaryPosition[i] == 'R') {
                leftPosition = (leftPosition + rightPosition + 1) / 2;
            } else if (binaryPosition[i] == 'L') {
                rightPosition = (rightPosition + leftPosition) / 2;
            }
        }
        if (binaryPosition[9] == 'R') {
            return rightPosition;
        } else if (binaryPosition[9] == 'L') {
            return leftPosition;
        }
        return 0;
    }

    public int getId() {
        return getId(getRow(), getColumn());
    }

    public static int getId(int row, int column){
        return row * 8 + column;
    }
}
