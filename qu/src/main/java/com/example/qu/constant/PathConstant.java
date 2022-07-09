package com.example.qu.constant;

import java.util.HashMap;
import java.util.Map;

public class PathConstant {

    // user constants
    public static final String LOGIN_USER = "login";
    public static final String SINGLE_USER = "{userId}";
    public static final String REGISTER_USER = "register";
    public static final String ALL_USER = "all";
    public static final String SEARCH_USER = "search";



    // Post constants
    public static final String CREATE_POST = "create/{userId}";
    public static final String FIND_POST = "find";
    public static final String FIND_POST_DESC = "findon";
    public static final String HIBERNATE = "hibernate";

    public static final String CURRENT_USER_POST = "user/{userId}";

    // Comment constants
    public static final String CREATE_COMMENT = "create/{userId}/{postId}";


    /*
    jpql things
     */
    public static final String GET_ATTR_EXACT = "find/exact";
    public static final String USER_STATS = "stats";
}