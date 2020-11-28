package com.uvtest;

import com.uservalidator.UserValidator;
import org.junit.Assert;
import org.junit.Test;

public class UVTest
{
    @Test
    public void checkFirstName()
    {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateFirstName("Rohit");
        Assert.assertTrue(result);
    }

    @Test
    public void checkLastName()
    {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateLastName("Kumar");
        Assert.assertTrue(result);
    }

    @Test
    public void checkEmail()
    {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateEmail("abc-xyz@bridgelabz.co.in");
        Assert.assertTrue(result);
    }

    @Test
    public void checkPassword()
    {
        UserValidator validator =new UserValidator();
        boolean result = validator.validatePassword("A@9asdnmjk");
        Assert.assertTrue(result);
    }

    @Test
    public void checkMobile()
    {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateMobile("91 7856458322");
        Assert.assertTrue(result);
    }

}
