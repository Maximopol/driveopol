package com.maximopol.driveopol.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

/**
 *
 */
public class EmailValidator {
    private static Logger logger = LogManager.getLogger(EmailValidator.class);

    public static final String REG = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

    /**
     *
     * @param email
     * @return
     */
    public static boolean IsValidEmail(String email) {
        return Pattern.matches(REG, email);
    }
    public static void main(String[]args) {
        logger.info(IsValidEmail("maximopolnate@gmail.com"));//true
        logger.info(IsValidEmail("@@@"));//true
//        Date date = new Date();
//        System.out.println(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("d-MM-yyyy");
        Calendar calendar = new GregorianCalendar();
        System.out.println(dateFormat.format(calendar.getTime()));

    }
}
