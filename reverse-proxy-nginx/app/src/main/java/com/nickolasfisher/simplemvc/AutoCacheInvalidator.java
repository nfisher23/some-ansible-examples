package com.nickolasfisher.simplemvc;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
public class AutoCacheInvalidator {

    @After("execution(* *(..)) && @annotation(InvalidateNginxCache)")
    private void runOnNonGET() {
        ProcessBuilder pb = new ProcessBuilder("invalidate_nginx_cache");
        try {
            pb.start();
        } catch (Exception ignored) {
            throw new RuntimeException("whatttt");
        }
    }

}
