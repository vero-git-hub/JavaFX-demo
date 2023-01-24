package com.example.javafxdemo.buttons.languages;

import com.example.javafxdemo.HelloController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.example.javafxdemo.HelloController.*;

public class LanguageButton {

    private final HelloController controller;

    public LanguageButton(HelloController controller) {
        this.controller = controller;
    }

    protected void changeLanguageHeader( String locale, String dateButton,
                                         String timeButton, String mainText ) {
        language = locale;
        controller.getDateButton().setText(  dateButton );
        controller.getTimeButton().setText( timeButton );
        controller.getMainText().setText( mainText );
    }

    protected void changeLanguageDatatimeLabel( String locale, String DateTodayLabel, String TimeTodayLabel ){
        if ( isDateVisible ) {
            String dateFormat = "EEEEE dd.MM.yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, new Locale( locale, language.toUpperCase() ) );
            controller.getDateTodayLabel().setText( DateTodayLabel );
            controller.getDateToday().setText( simpleDateFormat.format( new Date() ).toUpperCase() );
        }
        if ( isTimeVisible ) {
            controller.getTimeTodayLabel().setText( TimeTodayLabel );
        }
    }
}
