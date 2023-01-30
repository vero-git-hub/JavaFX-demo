package com.example.javafxdemo.factory.languages;

import com.example.javafxdemo.Controller;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.languages.UaButton;
import com.example.javafxdemo.factory.Creator;

public class UaCreator extends Creator {
    Controller controller;

    public UaCreator(Controller controller) {

        this.controller = controller; }

    @Override
    public Button createButton() { return new UaButton( controller ); }
}
