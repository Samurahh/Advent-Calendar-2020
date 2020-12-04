package com.spartaglobal.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SlopeProblem {
    public static List<char[]> getMap(){
        try{
            List<char[]> mapList = new ArrayList<>();
            File file = new File("slopeMapFile.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                mapList.add(scanner.nextLine().toCharArray());
            }
            return mapList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int countTreesOnSlope(int startingPoint, int verticalIncrement, int horizontalIncrement, List<char[]> map){
        int countedTrees = 0;
        int xPos = startingPoint;
        int yPos = 0;
        if(map == null){
            return 0;
        }else {
            while (yPos < map.size()) {
                if (map.get(yPos)[xPos] == '#') {
                    countedTrees++;
                }
                yPos += verticalIncrement;
                xPos = (xPos + horizontalIncrement) % (map.get(0).length);
            }
            return countedTrees;
        }
    }

}
