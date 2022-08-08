package com.hcb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GitDemoApplication {

    public static void main(String[] args) {
        System.out.println("helloGit!");
        System.out.println("在GitHub上新建了仓库");
        SpringApplication.run(GitDemoApplication.class, args);
    }

}
