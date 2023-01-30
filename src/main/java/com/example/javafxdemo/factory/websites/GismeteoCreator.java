package com.example.javafxdemo.factory.websites;

import com.example.javafxdemo.Controller;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.websites.GismeteoButton;
import com.example.javafxdemo.factory.Creator;

public class GismeteoCreator extends Creator {
    Controller controller;

    public GismeteoCreator(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Button createButton() {
        return new GismeteoButton( controller );
    }
}
