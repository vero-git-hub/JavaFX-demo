package com.example.javafxdemo.factory.languages;

import com.example.javafxdemo.HelloController;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.languages.UaButton;
import com.example.javafxdemo.factory.Dialog;

public class UaDialog extends Dialog {
    HelloController controller;

    public UaDialog(HelloController controller) { this.controller = controller; }

    @Override
    public Button createButton() { return new UaButton( controller ); }
}
