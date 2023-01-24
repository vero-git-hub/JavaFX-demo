package com.example.javafxdemo.factory.languages;

import com.example.javafxdemo.HelloController;
import com.example.javafxdemo.buttons.Button;
import com.example.javafxdemo.buttons.languages.EnButton;
import com.example.javafxdemo.factory.Dialog;

public class EnDialog extends Dialog {
    HelloController controller;

    public EnDialog( HelloController controller ) {
        this.controller = controller;
    }

    @Override
    public Button createButton() {
        return new EnButton( controller );
    }
}
