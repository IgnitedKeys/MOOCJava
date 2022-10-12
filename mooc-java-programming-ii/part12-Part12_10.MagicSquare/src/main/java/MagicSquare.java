
import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> sumOfRows = new ArrayList<>();
        int sum = 0;

        for (int row = 0; row < this.square.length; row++) {
            sum = 0;
            for (int col = 0; col < this.square[row].length; col++) {
                sum += this.square[row][col];
            }
            sumOfRows.add(sum);
        }
        return sumOfRows;
    }

    public ArrayList<Integer> sumsOfColumns() {
        ArrayList<Integer> sumOfColumns = new ArrayList<>();
        int sum = 0;

        for (int col = 0; col < this.square.length; col++) {
            sum = 0;
            for (int row = 0; row < this.square.length; row++) {
                sum += this.square[row][col];
            }
            sumOfColumns.add(sum);
        }
        return sumOfColumns;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> sumOfDiagonals = new ArrayList<>();
        int sum1 = 0;
        int size = this.square.length;
        //first diagonal is always double number(0,0 1,1  2,2 etc)
        for (int i = 0, j = 0; i < size && j < size; i++, j++) {
            sum1 += square[i][j];
        }
        //second diagonal, row increase normally, col moves backwards
        int sum2 = 0;
        for (int i = 0, j = size - 1; i < size && j >= 0; i++, j--) {
            sum2 += square[i][j];
        }
        sumOfDiagonals.add(sum1);
        sumOfDiagonals.add(sum2);
        return sumOfDiagonals;
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
