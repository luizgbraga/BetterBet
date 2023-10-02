package com.project.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class for converting time formats
 * @author Luiz Guilherme Amadi Braga
 */
public class TimeConverter {
    /** 
     * Converts a time String to a Double in [0, 1]
     * @param timeString formatted as "HH:mm"
     */
    public static double timeToFraction(String timeString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date inputTime = sdf.parse(timeString);
            Date startTime = sdf.parse("00:00");
            Date endTime = sdf.parse("23:59");

            long totalTime = endTime.getTime() - startTime.getTime();
            long currentTime = inputTime.getTime() - startTime.getTime();

            double fractionOfDay = (double)currentTime/totalTime;

            if (fractionOfDay < 0) {
                return 0.0;
            } else if (fractionOfDay > 1) {
                return 1.0;
            } else {
                return fractionOfDay;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return -1.0; // Error
        }
    }
}
