package com.estebanvm.conversor.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record Conversion(String result,
                         String documentation,
                         String terms_of_use,
                         int time_last_update_unix,
                         String time_last_update_utc,
                         int time_next_update_unix,
                         String time_next_update_utc,
                         String base_code,
                         String target_code,
                         double conversion_rate,
                         double conversion_result) {

    public String makeHistoryEntry(double amount) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        return String.format("(%s) %.2f [%s] => %.2f [%s]\n", formattedDateTime, amount, base_code, conversion_result, target_code);
    }
}
