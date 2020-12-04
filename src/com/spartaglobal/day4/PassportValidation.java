package com.spartaglobal.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PassportValidation {

    public static List<Passport> getPassports(){
        try{
            List<Passport> passportsList = new ArrayList<>();
            File file = new File("passportsFile.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String currentLine = scanner.nextLine();
                Passport passport = new Passport();
                while(!(currentLine.isBlank() || currentLine.isEmpty()) && scanner.hasNextLine()){
                    passport.addInfo(currentLine);
                    currentLine = scanner.nextLine();
                }
                if(!(currentLine.isBlank() || currentLine.isEmpty()) && !scanner.hasNextLine()){
                    passport.addInfo(currentLine);
                }
                passportsList.add(passport);
            }
            System.out.println(passportsList.size());
            return passportsList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int countValidPassports(String... exceptions){
        int counter = 0;
        List<Passport> passportList = getPassports();
        assert passportList != null;
        for (Passport passport: passportList) {
            printPassport(passport);
            boolean isValid = passport.isValid(exceptions);
            if(isValid){
                counter++;
            }
            System.out.println("THIS PASSPORT IS: " + (isValid?"VALID":"NOT VALID"));
            System.out.println();
        }
        return counter;
    }

    public static void printPassport(Passport passport){
        System.out.printf("Birth year:  %s%n", passport.getCredentials().get("byr"));
        System.out.printf("Issue year:  %s%n", passport.getCredentials().get("iyr"));
        System.out.printf("Expir year:  %s%n", passport.getCredentials().get("eyr"));
        System.out.printf("Heigth:      %s%n", passport.getCredentials().get("hgt"));
        System.out.printf("Hair color:  %s%n", passport.getCredentials().get("hcl"));
        System.out.printf("Eye color:   %s%n", passport.getCredentials().get("ecl"));
        System.out.printf("Passport id: %s%n", passport.getCredentials().get("pid"));
        System.out.printf("Country id:  %s%n", passport.getCredentials().get("cid"));
    }
}
