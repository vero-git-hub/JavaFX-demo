package com.example.javafxdemo.buttons.languages;

import com.example.javafxdemo.Localization;
import com.example.javafxdemo.Controller;
import com.example.javafxdemo.buttons.Button;

public class UaButton extends LanguageButton implements Button {

    public UaButton(Controller controller) {
        super(controller);
    }

    @Override
    public void onClick() {
        changeLanguageHeader( Localization.UA_COUNTRY.getAttribute(),
                Localization.UA_DATETIME_BUTTON.getAttribute(),
                Localization.UA_MAIN_TEXT.getAttribute() );
        changeLanguageDataLabel( Localization.UA_LOCALE.getAttribute() );
    }
}
