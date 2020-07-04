package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private final static Pattern patternSentence = Pattern.compile("[.!?]\\s");
    private final static Pattern patternSyllables = Pattern.compile("[aeiouy]{1,3}");

    private static int words;
    private static int characters;
    private static int sentenceCount = 1;
    private static int syllables;
    private static int polysyllables;


    public static void main(String[] args) {
        File file = new File(args[0]);
        StringBuilder builder = new StringBuilder();
        String[] text;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                builder.append(scanner.nextLine());
            }
            text = builder.toString().split(" ");


            calculateTextProperties(builder);
            calculateWordsProperties(text);

            double score = calculateAutomatedReadabilityIndex();

            System.out.println("Words: " + words);
            System.out.println("Sentences: " + sentenceCount);
            System.out.println("Characters: " + characters);
            System.out.println("Syllables: " + syllables);
            System.out.println("Polysyllables: " + polysyllables);
            System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all):");

            double index;
            index = calculateAutomatedReadabilityIndex();
            System.out.println(String.format("Automated Readability Index: %f (about %d year olds).", index, evaluateAge(index)));
            index = calculateFleschKincaidReadabilityIndex();
            System.out.println(String.format("Flesch–Kincaid readability tests: %f (about %d year olds).", index, evaluateAge(index)));
            index = calculateSMOGIndex();
            System.out.println(String.format("Simple Measure of Gobbledygook: %f (about %d year olds).", index, evaluateAge(index)));
            index = calculateColemanLiauIndex();
            System.out.println(String.format("Coleman–Liau index: %f (about %d year olds).", index, evaluateAge(index)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void calculateTextProperties(StringBuilder builder) {
        words = (int) (builder.chars().filter(c -> c == (int) ' ').count()) + 1;

        characters = builder.length() - words + 1;

        sentenceCount = 1;

        Matcher matcher = patternSentence.matcher(builder);
        while (matcher.find()) {
            sentenceCount++;
        }

    }

    private static void calculateWordsProperties(String[] text) {
        for (int i = 0; i < text.length; i++) {

            int syllablesInWord = 0;

            Matcher matcherSyllables = patternSyllables.matcher(text[i]);
            while (matcherSyllables.find()) {
                syllables++;
                syllablesInWord++;
            }

            if (text[i].endsWith("e")) {
                syllables--;
                syllablesInWord--;
            }
            if (syllablesInWord == 0) {
                syllables++;
            }
            if (syllablesInWord > 2) {
                polysyllables++;
            }


        }
    }

    private static double calculateAutomatedReadabilityIndex() {
        return 4.71 * characters / words + 0.5 * words / sentenceCount - 21.43;
    }

    private static double calculateFleschKincaidReadabilityIndex() {
        return 0.39 * words / sentenceCount + 11.8 * syllables / words - 15.59;
    }

    private static double calculateSMOGIndex() {
        return 1.043 * Math.sqrt(polysyllables * 30 / sentenceCount) + 3.1291;
    }

    private static double calculateColemanLiauIndex() {
        return 0.0588 * characters / words * 100 - 0.296 * sentenceCount / words * 100 - 15.8;
    }

    private static int evaluateAge(double index) {
        int indexRound = (int) Math.ceil(index);

        switch (indexRound) {
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 9;
            case 4:
                return 10;
            case 5:
                return 11;
            case 6:
                return 12;
            case 7:
                return 13;
            case 8:
                return 14;
            case 9:
                return 15;
            case 10:
                return 16;
            case 11:
                return 17;
            case 12:
                return 18;
            case 13:
                return 24;
            case 14:
                return 24;
        }
        return 24;
    }
}
