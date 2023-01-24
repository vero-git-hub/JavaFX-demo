package com.example.javafxdemo.buttons.languages;

import com.example.javafxdemo.Constants;
import com.example.javafxdemo.HelloController;
import com.example.javafxdemo.buttons.Button;

public class UaButton extends LanguageButton implements Button {

    public UaButton(HelloController controller) {
        super(controller);
    }

    @Override
    public void onClick() {
        changeLanguageHeader( Constants.UA_COUNTRY.getAttribute(),
                Constants.UA_DATE_BUTTON.getAttribute(),
                Constants.UA_TIME_BUTTON.getAttribute(),
                Constants.UA_MAIN_TEXT.getAttribute() );

        changeLanguageDatatimeLabel( Constants.UA_LOCALE.getAttribute(),
                Constants.UA_DATE_TODAY_LABEL.getAttribute(),
                Constants.UA_TIME_TODAY_LABEL.getAttribute() );
    }
}
