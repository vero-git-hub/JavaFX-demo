package com.example.javafxdemo.factory.websites;

import com.example.javafxdemo.Controller;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.websites.SinoptikButton;
import com.example.javafxdemo.factory.Creator;

public class SinoptikCreator extends Creator {
    Controller controller;

    public SinoptikCreator(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Button createButton() {
        return new SinoptikButton( controller );
    }
}
