package com.example.javafxdemo.buttons.languages;

import com.example.javafxdemo.Constants;
import com.example.javafxdemo.HelloController;
import com.example.javafxdemo.buttons.Button;

public class EnButton extends LanguageButton implements Button {

    public EnButton(HelloController controller) {
        super(controller);
    }

    @Override
    public void onClick() {
        changeLanguageHeader( Constants.EN_COUNTRY.getAttribute(),
                Constants.EN_DATE_BUTTON.getAttribute(),
                Constants.EN_TIME_BUTTON.getAttribute(),
                Constants.EN_MAIN_TEXT.getAttribute() );

        changeLanguageDatatimeLabel( Constants.EN_COUNTRY.getAttribute(),
                Constants.EN_DATE_TODAY_LABEL.getAttribute(),
                Constants.EN_TIME_TODAY_LABEL.getAttribute() );
    }
}
