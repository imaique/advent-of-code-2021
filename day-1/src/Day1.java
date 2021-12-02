import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        try {
            File input = new File("day-1/input.txt");
            Scanner reader = new Scanner(input);
            ArrayList<Integer> list = new ArrayList<>();

            while (reader.hasNextLine()) {
                list.add(reader.nextInt());
            }

            System.out.println("Part 1: " + timesCurrentBiggerThanPrevious(list));
            System.out.println("Part 2: " + timesWindowBiggerThanPrevious(list, 3));

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
    public static int timesCurrentBiggerThanPrevious(ArrayList<Integer> depths) {
        int count = 0;
        for(int i = 0, j = 1; j < depths.size(); i++, j++) {
            if (depths.get(i) < depths.get(j)) count++;
        }
        return count;
    }
    public static int timesWindowBiggerThanPrevious(ArrayList<Integer> depths, int windowSize) {
        int count = 0;
        int previous = 0;
        for(int i = 0; i < windowSize; i++) {
            previous += depths.get(i);
        }
        for(int i = windowSize, j = 0; i < depths.size(); i++, j++) {
            int current = previous + depths.get(i) - depths.get(j);
            if (current > previous) count++;
            previous = current;
        }
        return count;
    }
}
