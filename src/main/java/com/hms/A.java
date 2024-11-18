package com.hms;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class A {
    public static void main(String[] args) {
//        PasswordEncoder en = new BCryptPasswordEncoder();
//        System.out.println(en.encode("test"));
        String enPwd = BCrypt.hashpw("testing", BCrypt.gensalt(4));
        System.out.println(enPwd);
    }
}
