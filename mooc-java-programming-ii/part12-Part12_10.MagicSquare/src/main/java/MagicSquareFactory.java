
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        //start from the center of first row
        int currentNumber = 1;
        int center = size / 2;

        //place first number
        square.placeValue(center, 0, currentNumber);
        currentNumber++;
        int row = 0;
        int col = center;

        while (true) {
            //check if square is finished
            if (square.isMagicSquare()) {
                break;
            }

            int oldRow = row;
            int oldCol = col;
            row--;
            col++;

            //check if next value is in the bounds of the square
            int checkSquare = square.readValue(col, row);
            
            if (checkSquare == -1) {
                //if row is out of bounds, move to bottom row of square
                if (row < 0 || row >= square.getHeight()) {
                    row = square.getHeight() - 1;
                }
                //if col is out of bounds, move to front of row
                if (col < 0 || col >= square.getWidth()) {
                    col = 0;
                }
                if (isOccupied(row, col, square, currentNumber)) {
                    row = oldRow;
                    col = oldCol;
                    while (true) {
                        if (isOccupied(row, col, square, currentNumber)) {
                            row += 1;
                        } else {
                            break;
                        }
                    }
                    square.placeValue(col, row, currentNumber);
                    currentNumber++;
                } else {
                    square.placeValue(col, row, currentNumber);
                    currentNumber++;
                }

            } else if (checkSquare > 0 && checkSquare <= currentNumber) {
                //if the existing square has a value already in it
                //move coordinates to below last number
                row += 2;
                col -= 1;
                while (true) {
                    if (isOccupied(row, col, square, currentNumber)) {
                        row++;
                    } else {
                        break;
                    }
                }

                square.placeValue(col, row, currentNumber);
                currentNumber++;
            } else {
                square.placeValue(col, row, currentNumber);
                currentNumber++;
            }
            System.out.println(square.toString());
        }

        return square;
    }

    public boolean isOccupied(int row, int col, MagicSquare square, int number) {
        return square.readValue(col, row) > 0 && square.readValue(col, row) <= number;
    }

}
