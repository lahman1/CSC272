package com.example;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Template with placeholders
        String template = "Dear [Title] [LastName],\nThank you for being a valued customer.";

        // Initialize the TemplateManager with the template
        TemplateManager templateManager = new TemplateManager(template);
        HTMLFormatter htmlFormatter = new HTMLFormatter();
        Mailer mailer = new Mailer();
        DatabaseManager databaseManager = new DatabaseManager();

        // Get recipients from the "database"
        List<Map<String, String>> recipients = databaseManager.getRecipients();

        // Loop over each recipient, generate personalized message and "send" it
        for (Map<String, String> recipient : recipients) {
            String message = templateManager.generateMessage(recipient);
            String htmlMessage = htmlFormatter.formatToHTML(message);
            mailer.sendEmail(recipient.get("Email"), htmlMessage);
        }
    }
}
