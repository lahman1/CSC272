package com.example;

import java.util.HashMap;
import java.util.Map;

public class TemplateManager {
    private String template;

    public TemplateManager(String template) {
        this.template = template;
    }

    // Replace placeholders in the template with actual recipient data
    public String generateMessage(Map<String, String> recipientData) {
        String message = template;
        for (Map.Entry<String, String> entry : recipientData.entrySet()) {
            message = message.replace("[" + entry.getKey() + "]", entry.getValue());
        }
        return message;
    }
}
