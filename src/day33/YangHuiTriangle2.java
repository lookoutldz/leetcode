package day33;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class YangHuiTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        if (rowIndex == 0) {
            return row;
        }
        row.add(1);
        if (rowIndex == 1) {
            return row;
        }
        for (int i = 1; i < rowIndex; i++) {
            List<Integer> nextRow = new ArrayList<>();
            nextRow.add(1);
            for (int j = 1; j < row.size(); j++) {
                nextRow.add(row.get(j-1) + row.get(j));
            }
            nextRow.add(1);
            row = nextRow;
        }
        return row;
    }

    public void test() {
        PrintUtils.print(getRow(3));
    }
}
