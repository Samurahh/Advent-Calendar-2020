package com.spartaglobal.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasswordsProblem {

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




}
