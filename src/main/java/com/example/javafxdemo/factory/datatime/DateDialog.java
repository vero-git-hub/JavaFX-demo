package com.example.javafxdemo.factory.datatime;

import com.example.javafxdemo.HelloController;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.datatime.DateButton;
import com.example.javafxdemo.factory.Dialog;

public class DateDialog extends Dialog {
    HelloController controller;

    public DateDialog(HelloController controller) {
        this.controller = controller;
    }

    @Override
    public Button createButton() {
        return new DateButton( controller );
    }
}
