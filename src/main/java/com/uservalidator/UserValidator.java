package com.uservalidator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserValidator {
    private static final String FIRST_NAME = "^[A-Z][a-z]{2,}";
    private static final String LAST_NAME = "^[A-Z][a-z]{2,}";
    private static final String MOBILE = "[91]{2}\\s[789]{1}[0-9]{9}";
    private static final String EMAIL = "^([a-z]{3})([+_.-]?[0-9a-z]{3,})?([@][0-9a-z]{1,})([.][a-z]{2,})([.][a-z]{2,})?";
    private static final String PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#%&-+=()])(?=\\S+$).{8,}$";

    public static void main(String[] args) throws UserValidatorException {
        System.out.println("Enter FirstName:");
        Scanner fname = new Scanner(System.in);
        try {
            if (validateFirstName(fname.next())) {
                System.out.println("Enter LastName:");
                Scanner lname = new Scanner(System.in);
                try {
                    if (validateLastName(lname.next())) {
                        System.out.println("Enter EmailID:");
                        Scanner email = new Scanner(System.in);
                        try {
                            if (validateEmail(email.next())) {
                                System.out.println("Enter MobileNo:");
                                Scanner mob = new Scanner(System.in);
                                try {
                                    if (validateMobile(mob.nextLine())) {
                                        System.out.println("Enter Password:");
                                        Scanner pswd = new Scanner(System.in);
                                        try {
                                            if (validatePassword(pswd.next())) {
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

    public static boolean validateFirstName(String fname) {
        Pattern pattern = Pattern.compile(FIRST_NAME);
        return pattern.matcher(fname).matches();
    }

    public static boolean validateLastName(String lname) {
        Pattern pattern = Pattern.compile(LAST_NAME);
        return pattern.matcher(lname).matches();
    }

    public static boolean validateMobile(String mob) {
        Pattern pattern = Pattern.compile(MOBILE);
        return pattern.matcher(mob).matches();
    }

    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL);
        return pattern.matcher(email).matches();
    }

    public static boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD);
        return pattern.matcher(password).matches();
    }
}