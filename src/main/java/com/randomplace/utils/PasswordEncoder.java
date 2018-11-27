package com.randomplace.utils;

import com.randomplace.dto.UserDTO;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoder {

    private static PasswordEncoder ourInstance = new PasswordEncoder();

    private PasswordEncoder() {
    }

    public static PasswordEncoder getOurInstance() {
        return ourInstance;
    }

    public void encodePassword(UserDTO user) {
        user.setEncryptedPassword(BCrypt.hashpw(user.getNewPassword(), BCrypt.gensalt()));
    }

    public boolean isMatches(UserDTO userDTO) {
        return BCrypt.checkpw(userDTO.getCurrentPassword(), userDTO.getEncryptedPassword());
    }
}
