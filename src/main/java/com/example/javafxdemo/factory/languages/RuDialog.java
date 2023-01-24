package com.example.javafxdemo.factory.languages;

import com.example.javafxdemo.HelloController;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.languages.RuButton;
import com.example.javafxdemo.factory.Dialog;

public class RuDialog extends Dialog {
    HelloController controller;

    public RuDialog(HelloController controller) {
        this.controller = controller;
    }

    @Override
    public Button createButton() {
        return new RuButton( controller );
    }
}
