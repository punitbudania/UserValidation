package com.uvtest.com.uvtest;

import com.uservalidator.UserValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EmailTest
{
    private final String email;
    private final boolean expres;
    public UserValidator emailPart = new UserValidator();

    public EmailTest(String email, boolean expres)
    {
        super();
        this.email = email;
        this.expres = expres;
    }

    @Parameterized.Parameters
    public static Collection input()
    {
        return Arrays.asList(new Object[][] {{"abc@yahoo.com", true},
                {"abc-100@yahoo.com", true},
                {"abc.100@yahoo.com", true},
                {"abc111@abc.com", true},
                {"abc-100@abc.net", true},
                {"abc.100@abc.com.au", true},
                {"abc@1.com", true},
                {"abc", false},
                {"abc@.com.my", false},
                {"abc123@gmail.a", false}});
    }

    @Test
    public void testEmail()
    {
        Assert.assertEquals(expres, emailPart.validateEmail("abc-xyz@bridgelabz.co.in"));
    }
}
