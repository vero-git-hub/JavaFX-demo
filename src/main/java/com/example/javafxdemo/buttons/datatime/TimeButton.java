package com.example.javafxdemo.buttons.datatime;

import com.example.javafxdemo.Constants;
import com.example.javafxdemo.HelloController;
import com.example.javafxdemo.buttons.Button;

import java.text.SimpleDateFormat;
import java.util.Date;
import static com.example.javafxdemo.HelloController.*;

public class TimeButton implements Button {

    private final HelloController controller;

    public TimeButton(HelloController controller) {
        this.controller = controller;
    }

    @Override
    public void onClick() {
        isTimeVisible = true;
        String timeFormat = "HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(timeFormat);

        controller.getTimeTodayLabel().setText( getLabelForTime() );
        controller.getTimeToday().setText( simpleDateFormat.format( new Date() ) );
    }

    private static String getLabelForTime(){
        return switch ( language ) {
            case "RU" -> Constants.RU_TIME_TODAY_LABEL.getAttribute();
            case "UA" -> Constants.UA_TIME_TODAY_LABEL.getAttribute();
            default   -> Constants.EN_TIME_TODAY_LABEL.getAttribute();
        };
    }
}
