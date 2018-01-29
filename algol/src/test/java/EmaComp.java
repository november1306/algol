import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/*
    https://docs.google.com/document/d/1IK4k7XSEaLt45p7otAw-Vcr6h6BbMm4FnhfWGEfyyfk/edit
 */

public class EmaComp {

    private List<Plus> plusList = new ArrayList<Plus>();
    private int[][] intGrid;

    @Test
    public void test1() {
        String grid[] = {"BGBBGB", "GGGGGG", "BGBBGB", "GGGGGG", "BGBBGB", "BGBBGB"};
        calculatePluses(grid);
    }


    private int calculatePluses(String[] grid) {
        int resValue = 0;
        /*
            convert input grid to int [][]
         */
        intGrid = convertToNum(grid);
        /*
            find all exisitng pluses of size 3+
         */
        getAllPluses();
        Collections.sort(plusList);
        resValue = selectTwoMaxPlus(plusList);
        System.out.println("max production of cross sizes: "+ resValue);
        return resValue;
    }

    private int selectTwoMaxPlus(List<Plus> plusList) {
        Plus pl1;
        Plus pl2;

        int bestOutcome = countSize(plusList.get(0).getSize(), plusList.get(0).getSize());
        int maxProduct = 0;
        for (int i = 0; i < plusList.size() - 2; i++) {
            pl1 = plusList.get(i);
            for (int j = i + 1; j < plusList.size() - 1; j++) {
                pl2 = plusList.get(j);
                if (crosses(pl1, pl2) == false && pl1.getSize() + pl2.getSize() > maxProduct) {
                    maxProduct = countSize(pl1.getSize(), pl2.getSize());
                    if (maxProduct == bestOutcome)
                        return maxProduct;
                }
            }
        }
        return maxProduct;
    }

    private int countSize(int shSize1, int shSize2) {
        int product = 0;
        product = (shSize1*2-1) * (shSize2*2-1);
        return product;

    }

    private boolean crosses(Plus pl1, Plus pl2) {
        int size1 = (pl1.getSize() - 1) / 2;
        int size2 = (pl2.getSize() - 1) / 2;
        int x1 = pl1.getCenter().x;
        int y1 = pl1.getCenter().y;
        int x2 = pl2.getCenter().x;
        int y2 = pl2.getCenter().y;
        double distanceBetweenCenters = sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
        boolean doCross = false;
        if (x1 == x2 && abs(y1 - y2) < size1 + size2 + 1)
            doCross = true;
        if (y1 == y2 && abs(x1 - x2) < size1 + size2 + 1)
            doCross = true;

        if (!doCross && (abs(x2 - x1) <= Math.max(size1, size2) || abs(y2 - y1) <= Math.max(size1, size2))) {
            doCross = true;
        }
        return doCross;

    }

    private List<Plus> getAllPluses() {
        for (int i = 0; i < intGrid.length - 1; i++) {
            for (int j = 0; j < intGrid[i].length - 1; j++) {
                if (intGrid[i][j] == 1)
                    detectPlus(i, j, 0);
            }

        }
        return plusList;
    }

    private void detectPlus(int i, int j, int shiftSize) {
        if (isGood(i + shiftSize, j) && isGood(i, j + shiftSize) && isGood(i - shiftSize, j) && isGood(i, j - shiftSize)) {

            plusList.add(new Plus(shiftSize * 2 + 1, new Point(i, j)));
            detectPlus(i, j, shiftSize + 1);
        }

    }

    private boolean isGood(int i, int j) {
        boolean valid = true;
        if (i > intGrid.length - 1 || i < 0)
            valid = false;
        if (valid && j > intGrid[i].length - 1 || j < 0)
            valid = false;
        if (valid && intGrid[i][j] != 1)
            valid = false;
        return valid;
    }


    private int[][] convertToNum(String[] grid) {
        int[][] numGrid = new int[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                switch (grid[i].charAt(j)) {
                    case 'G':
                        numGrid[i][j] = 1;
                        break;
                    case 'B':
                        numGrid[i][j] = 0;
                        break;
                }
                ;
                System.out.print(numGrid[i][j]);
            }
            System.out.println();
        }
        return numGrid;
    }

}
