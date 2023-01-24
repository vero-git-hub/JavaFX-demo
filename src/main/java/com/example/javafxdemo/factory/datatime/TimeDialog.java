package com.example.javafxdemo.factory.datatime;

import com.example.javafxdemo.HelloController;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.datatime.TimeButton;
import com.example.javafxdemo.factory.Dialog;

public class TimeDialog extends Dialog {

    HelloController controller;

    public TimeDialog(HelloController controller) { this.controller = controller; }

    @Override
    public Button createButton() {
        return new TimeButton( controller );
    }
}
