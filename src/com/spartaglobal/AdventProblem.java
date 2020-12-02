package com.spartaglobal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdventProblem {

    public static List<Integer> getData(){
        try{
            List<Integer> numberList = new ArrayList<>();
            File file = new File("dataFile.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                numberList.add(Integer.valueOf(scanner.nextLine()));
            }
            return numberList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<PasswordPolicy> getPasswords(){
        try{
            List<PasswordPolicy> passwordList = new ArrayList<>();
            File file = new File("passwordsFile.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                PasswordPolicy passwordPolicy = new PasswordPolicy(scanner.nextLine());
                passwordList.add(passwordPolicy);
            }
            return passwordList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int countValidOldPasswords(List<PasswordPolicy> passwordPolicies){
        if(passwordPolicies == null){
            return 0;
        }else {
            int count = 0;
            for (PasswordPolicy passwordPolicy :
                    passwordPolicies) {
                if (passwordPolicy.isValidOld()) {
                    count++;
                }
            }
            return count;
        }
    }

    public static int countValidNewPasswords(List<PasswordPolicy> passwordPolicies){
        if(passwordPolicies == null){
            return 0;
        }else {
            int count = 0;
            for (PasswordPolicy passwordPolicy :
                    passwordPolicies) {
                if (passwordPolicy.isValidNew()) {
                    count++;
                }
            }
            return count;
        }
    }

    public static int multiplyFirstTwoThatSums(int sum, List<Integer> numberList) {
        if (numberList == null) {
            return 0;
        } else {
            for (int i = 0; i < numberList.size() - 1; i++) {
                for (int j = 0; j < numberList.size() - 1; j++) {
                    if (i != j) {
                        if (numberList.get(i) + numberList.get(j) == sum) {
                            return numberList.get(i) * numberList.get(j);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static int multiplyFirstThreeThatSums(int sum, List<Integer> numberList) {
        if (numberList == null) {
            return 0;
        } else {
            for (int i = 0; i < numberList.size() - 1; i++) {
                for (int j = 0; j < numberList.size() - 1; j++) {
                    for (int k = 0; k < numberList.size() - 1; k++) {
                        if (i != j && i!=k && k!=j) {
                            if (numberList.get(i) + numberList.get(j) + numberList.get(k) == sum) {
                                return numberList.get(i) * numberList.get(j) * numberList.get(k);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }


}
