package com.example.reminderapp.controller;

import com.example.reminderapp.model.Reminder;
import com.example.reminderapp.service.ReminderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReminderController {

    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("reminders", reminderService.getAllReminders());
        model.addAttribute("newReminder", new Reminder());
        return "index";
    }

    @PostMapping("/add")
    public String addReminder(@ModelAttribute Reminder reminder) {
        reminderService.addReminder(reminder);
        return "redirect:/";
    }
}
