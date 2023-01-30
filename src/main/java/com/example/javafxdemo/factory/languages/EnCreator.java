package com.example.javafxdemo.factory.languages;

import com.example.javafxdemo.Controller;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.languages.EnButton;
import com.example.javafxdemo.factory.Creator;

public class EnCreator extends Creator {
    Controller controller;

    public EnCreator(Controller controller ) {
        this.controller = controller;
    }

    @Override
    public Button createButton() {
        return new EnButton( controller );
    }
}
