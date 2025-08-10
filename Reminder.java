package com.example.reminderapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reminder {
    private String name;
    private double amount;
    private String date; // DDMMYYYY
    private boolean monthly;
    private String alarmTime; // HH:mm or empty if not set
}
