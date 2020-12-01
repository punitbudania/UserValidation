package com.uservalidator;

import java.util.Scanner;
import java.util.regex.Pattern;

@FunctionalInterface
interface ValidateUserEntry
{
    boolean validate(String userInput, String PATTERN);
}

public class UserValidator {
    private static final String FIRST_NAME = "^[A-Z][a-z]{2,}";
    private static final String LAST_NAME = "^[A-Z][a-z]{2,}";
    private static final String MOBILE = "[91]{2}\\s[789]{1}[0-9]{9}";
    private static final String EMAIL = "^([a-z]{3})([+_.-]?[0-9a-z]{3,})?([@][0-9a-z]{1,})([.][a-z]{2,})([.][a-z]{2,})?";
    private static final String PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#%&-+=()])(?=\\S+$).{8,}$";


    public static void main(String[] args) {
        ValidateUserEntry validateInputs;

        validateInputs = (String userInput, String PATTERN) -> {
            Pattern pattern = Pattern.compile(PATTERN);
            return pattern.matcher(userInput).matches();
        };


        System.out.println("Enter FirstName:");
        Scanner sc = new Scanner(System.in);
        String fname = sc.next();
        try {
            if (validateInputs.validate(fname, FIRST_NAME)) {
                System.out.println("Enter LastName:");
                sc = new Scanner(System.in);
                String lname = sc.next();
                try {
                    if (validateInputs.validate(lname, LAST_NAME)) {
                        System.out.println("Enter EmailID:");
                        sc = new Scanner(System.in);
                        String email = sc.next();
                        try {
                            if (validateInputs.validate(email, EMAIL)) {
                                System.out.println("Enter MobileNo:");
                                sc = new Scanner(System.in);
                                String mob = sc.nextLine();
                                try {
                                    if (validateInputs.validate(mob, MOBILE)) {
                                        System.out.println("Enter Password:");
                                        sc = new Scanner(System.in);
                                        String pswd = sc.next();
                                        try {
                                            if (validateInputs.validate(pswd, PASSWORD)) {
                                                System.out.println("Done");
                                            } else {
                                                throw new UserValidatorException("Invalid!! Try Again");
                                            }
                                        } catch (UserValidatorException e) {
                                            System.out.println("UserValidatorException:" + e.getMessage());
                                        }
                                    } else {
                                        throw new UserValidatorException("Invalid!! Try Again");
                                    }
                                } catch (UserValidatorException e) {
                                    System.out.println("UserValidatorException:" + e.getMessage());
                                }
                            } else {
                                throw new UserValidatorException("Invalid!! Try Again");
                            }
                        } catch (UserValidatorException e) {
                            System.out.println("UserValidatorException:" + e.getMessage());
                        }

                    } else {
                        throw new UserValidatorException("Invalid!! Try Again");
                    }
                } catch (UserValidatorException e) {
                    System.out.println("UserValidatorException:" + e.getMessage());
                }
            } else {
                throw new UserValidatorException("Invalid!! Try Again");
            }
        } catch (UserValidatorException e) {
            System.out.println("UserValidatorException:" + e.getMessage());
        }
    }
}