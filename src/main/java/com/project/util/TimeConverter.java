package com.project.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConverter {
    public static double timeToFraction(String timeStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date inputTime = sdf.parse(timeStr);
            Date startTime = sdf.parse("00:00");
            Date endTime = sdf.parse("23:59");

            long totalTime = endTime.getTime() - startTime.getTime();
            long currentTime = inputTime.getTime() - startTime.getTime();

            // Calculate the fraction of the day
            double fractionOfDay = (double) currentTime / totalTime;

            // Ensure the fraction is between 0 and 1
            if (fractionOfDay < 0) {
                return 0.0;
            } else if (fractionOfDay > 1) {
                return 1.0;
            } else {
                return fractionOfDay;
            }
        } catch (ParseException e) {
            // Handle parsing exception
            e.printStackTrace();
            return -1.0; // Return a value indicating an error
        }
    }
}
