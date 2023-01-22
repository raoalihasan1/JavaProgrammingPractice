package JavaProgrammingPractice.Testing;

public class MathematicalOperations {

    public static int Sum(int... num) {
        int total = 0;
        for (int x = 0; x < num.length; x++)
            total += num[x];
        return total;
    }

    public static int Multiply(int... num) {
        int total = 1;
        for (int x = 0; x < num.length; x++)
            total *= num[x];
        return total;
    }

}
