package com.example.javafxdemo.factory.websites;

import com.example.javafxdemo.HelloController;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.websites.SinoptikButton;
import com.example.javafxdemo.factory.Dialog;

public class SinoptikDialog extends Dialog {

    HelloController controller;

    public SinoptikDialog(HelloController controller) {
        this.controller = controller;
    }

    @Override
    public Button createButton() {
        return new SinoptikButton( controller );
    }
}
