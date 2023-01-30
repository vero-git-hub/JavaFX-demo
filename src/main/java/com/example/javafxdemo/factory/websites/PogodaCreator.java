package com.example.javafxdemo.factory.websites;

import com.example.javafxdemo.Controller;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.websites.PogodaButton;
import com.example.javafxdemo.factory.Creator;

public class PogodaCreator extends Creator {
    Controller controller;

    public PogodaCreator(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Button createButton() {
        return new PogodaButton( controller );
    }
}
