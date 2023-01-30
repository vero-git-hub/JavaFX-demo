package com.example.javafxdemo.buttons.datatime;

import com.example.javafxdemo.Localization;
import com.example.javafxdemo.Controller;
import com.example.javafxdemo.buttons.Button;
import static com.example.javafxdemo.Controller.*;
import static com.example.javafxdemo.factory.Creator.getCurrentTime;

import javafx.concurrent.Task;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DatetimeButton implements Button {

    private final Controller controller;

    public DatetimeButton(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void onClick() {
        Task<Void> task = createTask();
        Thread thread = new Thread( task );
        thread.setDaemon(true);
        if ( !isTimeVisible ) {
            fillDatetimeField( task, thread, getDateText() );
        } else {
            clearDatetimeField( thread );
        }
    }

    private void fillDatetimeField( Task<Void> task, Thread th, String dateText ){
        controller.getTimeText().textProperty().bind(task.messageProperty());
        controller.getDateText().setText( dateText );
        th.start();
        isTimeVisible = true;
    }

    private void clearDatetimeField( Thread th ){
        th.interrupt();
        controller.getTimeText().textProperty().unbind();
        controller.getTimeText().setText("");
        controller.getDateText().setText("");
        isTimeVisible = false;
    }

    private String getDateText(){
        String dateFormat = "EEEEE dd.MM.yyyy";
        SimpleDateFormat simpleDateFormatForDate = new SimpleDateFormat(
                dateFormat, new Locale( getLocale(), language ) );
        return simpleDateFormatForDate.format( new Date() ).toUpperCase();
    }

    private Task<Void> createTask(){
        return new Task<>() {
            @Override public Void call() {
                while ( isTimeVisible ){
                    updateMessage( getCurrentTime( "HH:mm:ss" ) );
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        Thread.interrupted();
                        break;
                    }

                }
                return null;
            }
        };
    }

    private String getLocale(){
        return switch ( language ) {
            case "RU" -> Localization.RU_LOCALE.getAttribute();
            case "UA" -> Localization.UA_LOCALE.getAttribute();
            default   -> Localization.EN_LOCALE.getAttribute();
        };
    }
}
