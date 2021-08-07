package com.example.health.Classes;

public class InputChecker {
    public static boolean checkEmail(String email) {
        if (email.length() < 1) return false;
        return true;
    }

    public static boolean checkPassword(String password) {
        if (password.length() < 6) return false;
        return true;
    }

    public static boolean checkName(String name) {
        if (name.length() < 1) return false;
        return true;
    }
}
