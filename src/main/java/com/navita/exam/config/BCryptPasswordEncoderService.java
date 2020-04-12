package com.navita.exam.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptPasswordEncoderService {

    public BCryptPasswordEncoder get() {
        return new BCryptPasswordEncoder();
    }
}
