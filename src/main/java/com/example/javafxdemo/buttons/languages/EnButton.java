package com.example.javafxdemo.buttons.languages;

import com.example.javafxdemo.Localization;
import com.example.javafxdemo.Controller;
import com.example.javafxdemo.buttons.Button;

public class EnButton extends LanguageButton implements Button {

    public EnButton(Controller controller) {
        super(controller);
    }

    @Override
    public void onClick() {
        changeLanguageHeader( Localization.EN_COUNTRY.getAttribute(),
                Localization.EN_DATETIME_BUTTON.getAttribute(),
                Localization.EN_MAIN_TEXT.getAttribute() );
        changeLanguageDataLabel( Localization.EN_COUNTRY.getAttribute() );
    }
}
