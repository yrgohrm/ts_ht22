package se.yrgo;

import java.time.*;

public class DayUtils {
    public static String isItFriday(DayOfWeek dow) {
        if (dow == DayOfWeek.FRIDAY) {
            return "TGIF";
        }
        else if (dow == DayOfWeek.THURSDAY) {
            return "Soon";
        }

        return "Nope";
    }
}
