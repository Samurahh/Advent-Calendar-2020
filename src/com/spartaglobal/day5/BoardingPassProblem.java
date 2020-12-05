package com.spartaglobal.day5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardingPassProblem {

    public static List<BoardingPass> getBoardingPasses() {
        try {
            List<BoardingPass> boardingPassesList = new ArrayList<>();
            File file = new File("boardingPassesFile.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                boardingPassesList.add(new BoardingPass(currentLine));
            }
            return boardingPassesList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getMaxId(List<BoardingPass> boardingPassList) {
        if (boardingPassList == null) {
            return -1;
        } else {
            int maxId = 0;
            for (BoardingPass boardingPass : boardingPassList) {
                int boardingPassId = boardingPass.getId();
                if (maxId < boardingPassId) {
                    maxId = boardingPassId;
                }
            }
            return maxId;
        }
    }

    public static List<Integer> getEmptySeats(List<BoardingPass> boardingPassList) {
        if (boardingPassList == null) {
            return null;
        } else {
            int[][] seatingMap = new int[128][8];
            List<Integer> emptySeatsId = new ArrayList<>();
            for (BoardingPass boardingPass : boardingPassList) {
                seatingMap[boardingPass.getRow()][boardingPass.getColumn()] = 1;
            }
            for (int i = 0; i <= BoardingPass.ROW_RANGE; i++) {
                for (int j = 0; j <= BoardingPass.COLUMN_RANGE; j++) {
                    if (seatingMap[i][j] == 0) {
                        emptySeatsId.add(BoardingPass.getId(i, j));
                    }
                }
            }
            return emptySeatsId;
        }
    }
}
