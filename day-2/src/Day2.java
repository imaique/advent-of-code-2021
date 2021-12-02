import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        try {
            System.out.println("Part 1: " + part1());
            System.out.println("Part 2: " + part2());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

    }
    public static int part2() throws FileNotFoundException{
        File input = new File("day-2/input.txt");
        Scanner reader = new Scanner(input);
        int x = 0;
        int y = 0;
        int aim = 0;

        while (reader.hasNextLine()) {
            String direction = reader.next();
            int amount = reader.nextInt();
            switch (direction) {
                case "forward":
                    x += amount;
                    y += aim * amount;
                    break;
                case "up":
                    aim -= amount;
                    break;
                case "down":
                    aim += amount;
                    break;
            }
        }
        return x * y;
    }
    public static int part1() throws FileNotFoundException{
        File input = new File("day-2/input.txt");
        Scanner reader = new Scanner(input);
        int x = 0;
        int y = 0;

        while (reader.hasNextLine()) {
            String direction = reader.next();
            int amount = reader.nextInt();
            switch (direction) {
                case "forward":
                    x += amount;
                    break;
                case "up":
                    y -= amount;
                    break;
                case "down":
                    y += amount;
                    break;
            }
        }
        return x * y;
    }
}
