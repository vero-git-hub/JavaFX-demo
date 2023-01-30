package com.example.javafxdemo.buttons.languages;

import com.example.javafxdemo.Localization;
import com.example.javafxdemo.Controller;
import com.example.javafxdemo.buttons.Button;

public class RuButton extends LanguageButton implements Button {

    public RuButton(Controller controller) {
        super(controller);
    }

    @Override
    public void onClick() {
        changeLanguageHeader( Localization.RU_COUNTRY.getAttribute(),
                Localization.RU_DATETIME_BUTTON.getAttribute(),
                Localization.RU_MAIN_TEXT.getAttribute() );
        changeLanguageDataLabel( Localization.RU_COUNTRY.getAttribute() );
    }
}