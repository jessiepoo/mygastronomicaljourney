package persistence;

import model.RestaurantCollection;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// A reader that can read collection data from a file
public class Reader {
    /*
    public static final String DELIMITER = ",";

    // EFFECTS: returns a list of collections parsed from file; throws
    // IOException if an exception is raised when opening/ reading from file
    public static List<RestaurantCollection> readCollections(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string containing the content of one row of the
    // file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of collections parsed from list of strings where each string contains data for
    // one collection
    private static List<RestaurantCollection> parseContent(List<String> fileContent) {
        List<RestaurantCollection> restaurantCollections = new ArrayList<>();

        for (String line: fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            restaurantCollections.add(parseRestaurantCollection(lineComponents));
        }
        return restaurantCollections;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: returns a collection constructed from components
    private static RestaurantCollection parseRestaurantCollection(List<String> components) {
        return new RestaurantCollection();
    }

     */
}


