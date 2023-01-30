package com.example.javafxdemo.factory.websites;

import com.example.javafxdemo.Controller;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.websites.MeteoBlueButton;
import com.example.javafxdemo.factory.Creator;

public class MeteoBlueCreator extends Creator {
    Controller controller;

    public MeteoBlueCreator(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Button createButton() {
        return new MeteoBlueButton( controller );
    }
}
