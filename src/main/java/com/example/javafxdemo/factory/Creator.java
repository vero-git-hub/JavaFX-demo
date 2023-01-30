package com.example.javafxdemo.factory;

import com.example.javafxdemo.buttons.Button;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Creator {

    public void createInstanceFactory() {
        Button button = createButton();
        button.onClick();
    }

    public abstract Button createButton();

    public static String getCurrentTime( String pattern ) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( pattern );
        return simpleDateFormat.format( new Date() );
    }
}
