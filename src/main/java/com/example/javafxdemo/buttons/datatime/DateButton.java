package com.example.javafxdemo.buttons.datatime;

import com.example.javafxdemo.Constants;
import com.example.javafxdemo.HelloController;
import com.example.javafxdemo.buttons.Button;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import static com.example.javafxdemo.HelloController.*;

public class DateButton implements Button {

    private final HelloController controller;

    public DateButton(HelloController controller) {
        this.controller = controller;
    }

    @Override
    public void onClick() {
        if ( !isDateVisible ) {
            isDateVisible = true;
        }

        String dateFormat = "EEEEE dd.MM.yyyy";
        controller.getDateTodayLabel().setText( getLabelForDate() );

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                dateFormat, new Locale( getLocale(), language ) );
        String text = simpleDateFormat.format( new Date() ).toUpperCase();
        controller.getDateToday().setText( text );
    }

    private String getLocale(){
        return switch (language) {
            case "RU" -> Constants.RU_LOCALE.getAttribute();
            case "UA" -> Constants.UA_LOCALE.getAttribute();
            default   -> Constants.EN_LOCALE.getAttribute();
        };
    }

    public String getLabelForDate(){
        return switch (language) {
            case "RU" -> Constants.RU_DATE_TODAY_LABEL.getAttribute();
            case "UA" -> Constants.UA_DATE_TODAY_LABEL.getAttribute();
            default   -> Constants.EN_DATE_TODAY_LABEL.getAttribute();
        };
    }
}