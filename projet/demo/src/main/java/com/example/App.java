package com.example;

/**
 * Hello world!
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        try {
            File file = new File("input.txt"); // Nom du fichier d'entrée
            Scanner scanner = new Scanner(file);

            // Lecture des coordonnées de la pelouse
            int maxX = scanner.nextInt();
            int maxY = scanner.nextInt();

            // Lecture des données de chaque tondeuse
            while (scanner.hasNext()) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                char orientation = scanner.next().charAt(0);

                // Lecture des instructions de déplacement
                String instructions = scanner.next();

                // Déplacement de la tondeuse
                moveTondeuse(x, y, orientation, maxX, maxY, instructions);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void moveTondeuse(int x, int y, char orientation, int maxX, int maxY, String instructions) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'D':
                    orientation = turnRight(orientation);
                    break;
                case 'G':
                    orientation = turnLeft(orientation);
                    break;
                case 'A':
                    switch (orientation) {
                        case 'N':
                            if (y < maxY)
                                y++;
                            break;
                        case 'E':
                            if (x < maxX)
                                x++;
                            break;
                        case 'S':
                            if (y > 0)
                                y--;
                            break;
                        case 'W':
                            if (x > 0)
                                x--;
                            break;
                    }
                    break;
            }
        }

        System.out.println(x + " " + y + " " + orientation);
    }

    public static char turnRight(char orientation) {
        switch (orientation) {
            case 'N':
                return 'E';
            case 'E':
                return 'S';
            case 'S':
                return 'W';
            case 'W':
                return 'N';
            default:
                return orientation;
        }
    }

    public static char turnLeft(char orientation) {
        switch (orientation) {
            case 'N':
                return 'W';
            case 'E':
                return 'N';
            case 'S':
                return 'E';
            case 'W':
                return 'S';
            default:
                return orientation;
        }
    }
}
