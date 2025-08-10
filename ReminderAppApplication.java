package com.example.reminderapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  // Enables Spring's scheduled tasks
public class ReminderAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReminderAppApplication.class, args);
    }
}
