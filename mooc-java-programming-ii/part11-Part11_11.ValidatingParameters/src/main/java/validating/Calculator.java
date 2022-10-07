package validating;

public class Calculator {

    public int factorial(int num) {
        if(num < 0) {
            throw new IllegalArgumentException("factorial needs to be on a positive number");
        }
        int answer = 1;
        for (int i = 1; i <= num; i++) {
            answer *= i;
        }

        return answer;
    }

    public int binomialCoefficent(int setSize, int subsetSize) {

        if(setSize < 0 || subsetSize < 0) {
            throw new IllegalArgumentException("both sets must be positive numbers");
        }
        if(subsetSize > setSize){
            throw new IllegalArgumentException("SubsetSize must be less than the setSize");
        }
        int numerator = factorial(setSize);
        int denominator = factorial(subsetSize) * factorial(setSize - subsetSize);

        return numerator / denominator;
    }
}
