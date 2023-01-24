package com.example.javafxdemo.factory.websites;

import com.example.javafxdemo.HelloController;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.websites.GismeteoButton;
import com.example.javafxdemo.factory.Dialog;

public class GismeteoDialog extends Dialog {
    HelloController controller;

    public GismeteoDialog(HelloController controller) {
        this.controller = controller;
    }

    @Override
    public Button createButton() {
        return new GismeteoButton( controller );
    }
}
