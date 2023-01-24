package com.example.javafxdemo.factory.websites;

import com.example.javafxdemo.HelloController;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.websites.MeteoButton;
import com.example.javafxdemo.factory.Dialog;

public class MeteoDialog extends Dialog {
    HelloController controller;

    public MeteoDialog(HelloController controller) {
        this.controller = controller;
    }

    @Override
    public Button createButton() {
        return new MeteoButton( controller );
    }
}
