package com.randomplace.security;

import com.randomplace.models.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class UserSession {

    private static Map<Integer, String> userSession = new HashMap<>();

    public static void addUser(HttpServletRequest request, User user) {
        userSession.put(user.getId(), request.getSession().getId());
        request.getSession().setAttribute("userId", user.getId());
        request.getSession().setAttribute("role", user.getId());
    }

    public static void clearSession(int id) {
        userSession.remove(id);
    }

    public static boolean isSessionValid(HttpServletRequest request, int id) {
        if (!userSession.containsKey(id)) {
            return false;
        }
        return userSession.get(id).equals(request.getSession().getId());
    }

}
