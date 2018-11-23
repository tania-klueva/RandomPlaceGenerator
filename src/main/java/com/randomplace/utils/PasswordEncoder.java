package com.randomplace.utils;

import com.randomplace.models.User;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoder {

    private static PasswordEncoder ourInstance = new PasswordEncoder();

    private PasswordEncoder() {
    }

    public static PasswordEncoder getOurInstance() {
        return ourInstance;
    }

    public void encodePassword(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
    }

    public boolean isMatches(String password, String encryptedPassword) {
        return BCrypt.checkpw(password, encryptedPassword);
    }
}
