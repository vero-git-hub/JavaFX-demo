package com.example.javafxdemo.factory.websites;

import com.example.javafxdemo.Controller;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.websites.MeteoButton;
import com.example.javafxdemo.factory.Creator;

public class MeteoCreator extends Creator {
    Controller controller;

    public MeteoCreator(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Button createButton() {
        return new MeteoButton( controller );
    }
}
