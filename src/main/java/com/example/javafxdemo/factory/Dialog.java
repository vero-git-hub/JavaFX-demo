package com.example.javafxdemo.factory;

import com.example.javafxdemo.buttons.Button;

public abstract class Dialog {

    public void renderWindow() {
        Button okButton = createButton();
        okButton.onClick();
    }

    public abstract Button createButton();
}
