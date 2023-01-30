package com.example.javafxdemo.factory.languages;

import com.example.javafxdemo.Controller;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.languages.RuButton;
import com.example.javafxdemo.factory.Creator;

public class RuCreator extends Creator {
    Controller controller;

    public RuCreator(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Button createButton() {
        return new RuButton( controller );
    }
}
