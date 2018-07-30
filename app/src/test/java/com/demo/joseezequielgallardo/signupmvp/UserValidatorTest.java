package com.demo.joseezequielgallardo.signupmvp;

import com.demo.joseezequielgallardo.signupmvp.model.IUser;
import com.demo.joseezequielgallardo.signupmvp.model.User;

import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Ideal user where all tests pass
 */
public class UserValidatorTest {

    IUser user;

    @Before
    public void setup(){
      user = new User("email@admin.com", "1234567");
    }

    /**
     * I prefer using String.length than String.isEmpty since the last one returns
     * true even when variable is null
     */
    @Test
    public void testIsEmailOrPasswordEmpty(){
        assertEquals(false, (user.getPassword().length() == 0)
                || (user.getEmail().length() == 0));
    }


    @Test
    public void testIsEmailAddressMalformed(){
        assertEquals(false,
                Pattern.matches("[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+", user.getEmail()));
    }

    @Test
    public void testIsPasswordLengthLessThanSevenChars(){
        assertEquals(false, user.isPasswordLengthLessThanSevenChars());
    }
}