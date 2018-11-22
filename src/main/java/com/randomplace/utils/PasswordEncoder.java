package com.randomplace.utils;

import com.randomplace.models.User;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoder {

    public void encodePassword(User user){
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
    }

    public boolean isMatches(String password, String encryptedPassword){
        return BCrypt.checkpw(password, encryptedPassword);
    }
}
