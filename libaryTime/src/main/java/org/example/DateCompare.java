package org.example;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class DateCompare
{
    public static int compare(LocalDate date1, LocalDate date2){

        // Получить текущую дату
        LocalDate currentDate = LocalDate.now();
        if(date1.compareTo(currentDate)>0){
            return -1;
        }
        else if(date2.compareTo(currentDate)>=0){
            return 0;
        }
        else{
            return 1;
        }
    }
}