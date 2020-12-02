package com.spartaglobal;

public class PasswordPolicy {
    private int maxChars;
    private int minChars;
    private char specifiedChar;
    private String input;

    public PasswordPolicy(String fileInput) {
        String[] resultInput = fileInput.split("[-: ]", 4);
        this.minChars = Integer.parseInt(resultInput[0]);
        this.maxChars = Integer.parseInt(resultInput[1]);
        this.specifiedChar = resultInput[2].charAt(0);
        this.input = resultInput[3].trim();
    }

    public int getMaxChars() {
        return maxChars;
    }

    public void setMaxChars(int maxChars) {
        this.maxChars = maxChars;
    }

    public int getMinChars() {
        return minChars;
    }

    public void setMinChars(int minChars) {
        this.minChars = minChars;
    }

    public char getSpecifiedChar() {
        return specifiedChar;
    }

    public void setSpecifiedChar(char specifiedChar) {
        this.specifiedChar = specifiedChar;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public boolean isValidOld(){
        char[] chars = input.toCharArray();
        int currentPresence = 0;
        for (char character:
             chars) {
            if(character == specifiedChar){
                currentPresence++;
            }
            if(currentPresence>maxChars){
                return false;
            }
        }
        return currentPresence <= maxChars && currentPresence >= minChars;
    }

    public boolean isValidNew(){
        char[] chars = input.toCharArray();
        if(chars[minChars-1] == specifiedChar && chars[maxChars-1] == specifiedChar){
            return false;
        }else return chars[minChars - 1] == specifiedChar && chars[maxChars - 1] != specifiedChar ||
                chars[minChars - 1] != specifiedChar && chars[maxChars - 1] == specifiedChar;
    }
}
