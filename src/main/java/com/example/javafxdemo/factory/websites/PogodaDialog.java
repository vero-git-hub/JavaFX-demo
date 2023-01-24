package com.example.javafxdemo.factory.websites;

import com.example.javafxdemo.HelloController;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.websites.PogodaButton;
import com.example.javafxdemo.factory.Dialog;

public class PogodaDialog extends Dialog {
    HelloController controller;

    public PogodaDialog(HelloController controller) {
        this.controller = controller;
    }

    @Override
    public Button createButton() {
        return new PogodaButton( controller );
    }
}
