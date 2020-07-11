package day32;

import java.util.ArrayList;
import java.util.List;

public class YangHuiTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>((int) (numRows / 0.75 + 1));
        if (numRows == 0) {
            return result;
        }
        List<Integer> row1 = new ArrayList<>(2);
        row1.add(1);
        result.add(row1);
        if (numRows == 1) {
            return result;
        }
        List<Integer> row2 = new ArrayList<>(4);
        row2.add(1);
        row2.add(1);
        result.add(row2);
        if (numRows == 2) {
            return result;
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> row = result.get(i-1);
            List<Integer> newRow = new ArrayList<>((int) (i / 0.75 + 1));
            newRow.add(1);
            for (int j = 1; j < row.size(); j++) {
                newRow.add(row.get(j-1) + row.get(j));
            }
            newRow.add(1);
            result.add(newRow);
        }
        return result;
    }
}
