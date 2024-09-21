package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseManager {
    // Simulate reading recipient data from a database (text file in this case)
    public List<Map<String, String>> getRecipients() {
        List<Map<String, String>> recipients = new ArrayList<>();

        Map<String, String> recipient1 = new HashMap<>();
        recipient1.put("Title", "Mr.");
        recipient1.put("LastName", "Smith");
        recipient1.put("Email", "mr.smith@example.com");

        Map<String, String> recipient2 = new HashMap<>();
        recipient2.put("Title", "Ms.");
        recipient2.put("LastName", "Johnson");
        recipient2.put("Email", "ms.johnson@example.com");

        recipients.add(recipient1);
        recipients.add(recipient2);

        return recipients;
    }
}
