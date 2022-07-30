package com.hcb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GitDemoApplication {

    public static void main(String[] args) {
        System.out.println("helloGit!");
        SpringApplication.run(GitDemoApplication.class, args);
    }

}
