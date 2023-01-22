package JavaProgrammingPractice.Testing;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathematicalOperationsTest {

    @Test
    public void testSum() {
        int num = 12;
        assertEquals(num, MathematicalOperations.Sum(num));
        int[] num1 = { 1, 2, 3 };
        assertEquals(IntStream.of(num1).sum(), MathematicalOperations.Sum(num1));
        int[] num2 = { 1, 2, 3, 4, 5, 6 };
        assertEquals(IntStream.of(num2).sum(), MathematicalOperations.Sum(num2));
        int[] num3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        assertEquals(IntStream.of(num3).sum(), MathematicalOperations.Sum(num3));
    }

    @Test
    public void testMultiply() {
        int num = 1;
        assertEquals(num, MathematicalOperations.Multiply(num));
        int[] num1 = { 1, 2, 3 };
        assertEquals(IntStream.of(num1).reduce(1, (a, b) -> a * b), MathematicalOperations.Multiply(num1));
        int[] num2 = { 1, 2, 3, 4, 5, 6 };
        assertEquals(IntStream.of(num2).reduce(1, (a, b) -> a * b), MathematicalOperations.Multiply(num2));
        int[] num3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        assertEquals(IntStream.of(num3).reduce(1, (a, b) -> a * b), MathematicalOperations.Multiply(num3));
    }

}
