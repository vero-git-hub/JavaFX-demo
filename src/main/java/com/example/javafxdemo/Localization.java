package com.example.javafxdemo;

public enum Localization {
    DEFAULT_COUNTRY("EN"),
    EN_COUNTRY("EN"),
    EN_LOCALE("en"),
    EN_DATETIME_BUTTON("DATE AND TIME"),
    EN_MAIN_TEXT("WEATHER IN DNIPRO"),

    RU_COUNTRY("RU"),
    RU_LOCALE("ru"),
    RU_DATETIME_BUTTON("ДАТА И ВРЕМЯ"),
    RU_MAIN_TEXT("ПОГОДА В ДНЕПРЕ"),


    UA_COUNTRY("UA"),
    UA_LOCALE("uk"),
    UA_DATETIME_BUTTON("ДАТА І ЧАС"),
    UA_MAIN_TEXT("ПОГОДА У ДНІПРІ");

    private final String attribute;

    public String getAttribute() {
        return attribute;
    }

    Localization(String attribute) {
        this.attribute = attribute;
    }

}
