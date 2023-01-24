package com.example.javafxdemo.buttons.languages;

import com.example.javafxdemo.Constants;
import com.example.javafxdemo.HelloController;
import com.example.javafxdemo.buttons.Button;

public class RuButton extends LanguageButton implements Button {

    public RuButton(HelloController controller) {
        super(controller);
    }

    @Override
    public void onClick() {
        changeLanguageHeader( Constants.RU_COUNTRY.getAttribute(),
                Constants.RU_DATE_BUTTON.getAttribute(),
                Constants.RU_TIME_BUTTON.getAttribute(),
                Constants.RU_MAIN_TEXT.getAttribute() );

        changeLanguageDatatimeLabel( Constants.RU_COUNTRY.getAttribute(),
                Constants.RU_DATE_TODAY_LABEL.getAttribute(),
                Constants.RU_TIME_TODAY_LABEL.getAttribute() );
    }
}