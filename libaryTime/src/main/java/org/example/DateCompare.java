package org.example;
import java.time.LocalDateTime;

/**
 * Hello world!
 *
 */
public class DateCompare
{
    public static boolean compareDates(LocalDateTime[] date1, LocalDateTime[] date2){
        // date[0] - время отправления, date[1] - время прилета
        return (date2[0].isBefore(date1[1])) && (date2[1].isAfter(date1[0]));
    }
}