package com.example.javafxdemo.factory.datatime;

import com.example.javafxdemo.Controller;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.datatime.DatetimeButton;
import com.example.javafxdemo.factory.Creator;

public class DatetimeCreator extends Creator {

    Controller controller;

    public DatetimeCreator(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Button createButton() {
        return new DatetimeButton( controller );
    }
}
