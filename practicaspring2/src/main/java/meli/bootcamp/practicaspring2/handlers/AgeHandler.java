package meli.bootcamp.practicaspring2.handlers;

import meli.bootcamp.practicaspring2.exceptions.ObtenerDiplomaExceptionController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AgeHandler {

    public static void validateDate(String day, String month, String year) {

        Integer iyear = Integer.valueOf(year);
        Integer imonth = Integer.valueOf(month);
        Integer iday = Integer.valueOf(day);

        Calendar calendar = Calendar.getInstance();
        if(!isValid(day + "-" + month + "-" + year) ||
                calendar.get(Calendar.YEAR) < iyear ||
                calendar.get(Calendar.YEAR) == iyear && calendar.get(Calendar.MONTH) < imonth ||
                calendar.get(Calendar.YEAR) == iyear && calendar.get(Calendar.MONTH) == imonth && calendar.get(Calendar.DAY_OF_MONTH) < iday){
            Map<String, String> errors = new HashMap<>();
            errors.put("date", "invalid date");
            throw new ObtenerDiplomaExceptionController(400, "bad date", errors);
        }

    }

    public static Integer getAge(String day, String month, String year) {

        Integer iyear = Integer.valueOf(year);
        Integer imonth = Integer.valueOf(month);
        Integer iday = Integer.valueOf(day);

        Calendar calendar = Calendar.getInstance();
        Integer totalYears = calendar.get(Calendar.YEAR)-iyear;
        totalYears = (calendar.get(Calendar.MONTH) < imonth || (calendar.get(Calendar.MONTH) == imonth && calendar.get(Calendar.DAY_OF_MONTH) < iday)) ? totalYears-1 : totalYears;
        return totalYears;
    }

    private static boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
