package com.randomplace.utils;

public interface PagePath {
    String USER_PREFIX = "/views/user/";
    String PLACE_PREFIX = "/views/place/";
    String LOGIN_PREFIX = "/views/security/";
    String SUFFIX = ".jsp";
    String SIGN_UP = USER_PREFIX + "signUp" + SUFFIX;
    String USER_PAGE = USER_PREFIX + "userPage" + SUFFIX;
    String CREATE_PLACE = PLACE_PREFIX + "createPlace" + SUFFIX;
    String EDIT_PLACE = PLACE_PREFIX + "editPlace" + SUFFIX;
    String PLACE_PAGE = PLACE_PREFIX + "place" + SUFFIX;
    String PLACE_LIST = PLACE_PREFIX + "places" + SUFFIX;
    String SIGN_IN = LOGIN_PREFIX + "signIn" + SUFFIX;
    String ERROR = "/views/error" + SUFFIX;
}

