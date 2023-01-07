package com.DYShunyaev.Project.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class GeneralService {

    public boolean emailVerification(String email) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+");
        Matcher matcher = pattern.matcher(email);
        return true;
    }
}
