package com.example.javafxdemo.factory.websites;

import com.example.javafxdemo.HelloController;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.websites.MeteoBlueButton;
import com.example.javafxdemo.factory.Dialog;

public class MeteoBlueDialog extends Dialog {
    HelloController controller;

    public MeteoBlueDialog(HelloController controller) {
        this.controller = controller;
    }

    @Override
    public Button createButton() {
        return new MeteoBlueButton( controller );
    }
}
