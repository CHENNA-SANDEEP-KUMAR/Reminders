package com.example.reminderapp.service;

import com.example.reminderapp.model.Reminder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReminderService {

    private final List<Reminder> reminders = new ArrayList<>();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");

    public List<Reminder> getAllReminders() {
        return reminders;
    }

    public void addReminder(Reminder reminder) {
        reminders.add(reminder);
    }

    // This runs every minute
    @Scheduled(fixedRate = 60000)
    public void checkReminders() {
        Date now = new Date();
        String today = dateFormat.format(now);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        for (Reminder r : reminders) {
            boolean isToday = r.getDate().equals(today) || 
                              (r.isMonthly() && dateFormat.format(now).substring(0, 2).equals(r.getDate().substring(0, 2)));

            boolean timeMatches = r.getAlarmTime() != null && !r.getAlarmTime().isEmpty() &&
                                  timeFormat.format(now).equals(r.getAlarmTime());

            if (isToday && timeMatches) {
                System.out.println("🔔 Reminder: " + r.getName() + " - Amount: " + r.getAmount());
                // In a real web app, we can push this to frontend using WebSocket
            }
        }
    }
}
