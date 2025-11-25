package week.pkg10.sets.maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Week10SetsMaps {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a filename for baby name ranking (e.g., babynamesranking2001.txt): ");
        String filename = input.nextLine();
        System.out.println();
        
        Set<String> boyNames = new HashSet<>();
        Set<String> girlNames = new HashSet<>();

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNext()) {
                fileScanner.next();
                String boyName = fileScanner.next();
                boyNames.add(boyName);
                fileScanner.next();
                String girlName = fileScanner.next();
                girlNames.add(girlName);
                fileScanner.next();
            }

            Set<String> both = new HashSet<>(boyNames);
            both.retainAll(girlNames);

            List<String> sorted = new ArrayList<>(both);
            Collections.sort(sorted);

            System.out.println("There are " + sorted.size() + " common names between genders.");
            System.out.print("They are ");

            int count = 0;
            for (int i = 0; i < sorted.size(); i++) {
                System.out.print(sorted.get(i));
                if (i < sorted.size() - 1) System.out.print(", ");
                count++;

                if (count == 10 && i < sorted.size() - 1) {
                    System.out.println();
                    count = 0;
                }
            }

            System.out.println();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            System.out.println("Current working directory: " + new File(".").getAbsolutePath());
        }
    }
    
}
