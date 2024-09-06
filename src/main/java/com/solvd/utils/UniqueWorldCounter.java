package com.solvd.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueWorldCounter {
    public static void uniqueWordCounter() {
        try {
            // Read file, remove any non alphabet character, split by whitespace characters and store in array.
            // Convert array to Stream<String>. Use distinct() to rule out repeated word, the use count() to count.
            long uniqueWordCount = Arrays.stream(
                    FileUtils.readFileToString(new File("src/main/resources/textForTest"),
                                    "UTF-8").replaceAll("\\W", " ").toLowerCase()
                            .split("\\s+")).distinct().count();
            // Print count() output on file output
            FileUtils.writeStringToFile(new File("src/main/resources/output.txt"),
                    "Number of unique words: "
                    + uniqueWordCount, "UTF-8");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void uniqueWordCounter2() {
        try {
            // Read file, remove any non alphabet character, split by whitespace characters and store in array.
            String[] wordList = FileUtils.readFileToString(new File("src/main/resources/TextForTest")
                            , "UTF-8")
                    .replaceAll("\\W+", " ")
                    .toLowerCase()
                    .split("\\s");

            // Convert array into Set which rules out repeated word
            Set<String> uniqueWordsSet = new HashSet<>(Arrays.asList(wordList));

            // output count
            System.out.println("Number of unique words: " + (long) uniqueWordsSet.size());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
