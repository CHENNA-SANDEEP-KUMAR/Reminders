package com.example.reminderapp.controller;

import com.example.reminderapp.model.Reminder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReminderController {

    private final List<Reminder> reminders = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("reminders", reminders);
        model.addAttribute("newReminder", new Reminder());
        return "index";
    }

    @PostMapping("/add")
    public String addReminder(@ModelAttribute Reminder reminder) {
        reminders.add(reminder);
        return "redirect:/";
    }
}
