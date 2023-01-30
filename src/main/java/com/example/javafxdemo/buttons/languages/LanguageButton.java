package com.example.javafxdemo.buttons.languages;

import com.example.javafxdemo.Controller;
import static com.example.javafxdemo.Controller.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LanguageButton {

    private final Controller controller;

    public LanguageButton(Controller controller) {
        this.controller = controller;
    }

    protected void changeLanguageHeader( String locale, String timeButton, String mainText ) {
        language = locale;
        controller.getDatetimeToggleButton().setText( timeButton );
        controller.getMainText().setText( mainText );
    }

    protected void changeLanguageDataLabel(String locale ){
        if ( isTimeVisible ) {
            String dateFormat = "EEEEE dd.MM.yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, new Locale( locale, language.toUpperCase() ) );
            controller.getDateText().setText( simpleDateFormat.format( new Date() ).toUpperCase() );
        }
    }
}
