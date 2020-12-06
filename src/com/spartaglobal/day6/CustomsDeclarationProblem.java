package com.spartaglobal.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CustomsDeclarationProblem {

    public static List<Group> getGroups() {
        try {
            List<Group> groupsList = new ArrayList<>();
            File file = new File("boardingPassAnswersFile.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                Group group = new Group();
                while (!(currentLine.isBlank() || currentLine.isEmpty()) && scanner.hasNextLine()) {
                    group.addAnswer(currentLine);
                    currentLine = scanner.nextLine();
                }
                if (!(currentLine.isBlank() || currentLine.isEmpty()) && !scanner.hasNextLine()) {
                    group.addAnswer(currentLine);
                }
                groupsList.add(group);
            }
            return groupsList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getTotalPositiveAnswers(List<Group> groups) {
        if (groups == null) {
            return -1;
        } else {
            int total = 0;
            for (Group group : groups) {
                total += group.getPositiveAnswers();
            }
            return total;
        }
    }

    public static int getTotalCompletePositiveAnswers(List<Group> groups) {
        if (groups == null) {
            return -1;
        } else {
            int total = 0;
            for (Group group : groups) {
                total += group.getCompletPositiveAnswers();
            }
            return total;
        }
    }

    private static class Group {
        private final List<String> answers = new ArrayList<>();

        public Group() {
        }

        public int getPositiveAnswers() {
            int count = 0;
            Map<Character, Boolean> positiveAnswers = new HashMap<>();
            for (String answer : answers) {
                char[] answerChar = answer.toCharArray();
                for (char c : answerChar) {
                    if (!positiveAnswers.containsKey(c)) {
                        positiveAnswers.put(c, true);
                        count++;
                    }
                }
            }
            return count;
        }

        public int getCompletPositiveAnswers() {
            int count = 0;
            Map<Character, Integer> positiveAnswers = new HashMap<>();
            for (String answer : answers) {
                char[] answerChar = answer.toCharArray();
                for (char c : answerChar) {
                    if (!positiveAnswers.containsKey(c)) {
                        positiveAnswers.put(c, 1);
                    } else {
                        positiveAnswers.put(c, positiveAnswers.get(c) + 1);
                    }
                }
            }
            for (int positiveAnswer : positiveAnswers.values()) {
                if (positiveAnswer == answers.size()) {
                    count++;
                }
            }
            return count;
        }

        public void addAnswer(String answer) {
            answers.add(answer);
        }

    }
}
