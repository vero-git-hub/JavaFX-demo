package com.example.javafxdemo;

public enum Constants {
    DEFAULT_LOCALE("EN"),
    EN_COUNTRY("EN"),
    EN_LOCALE("en"),
    EN_DATE_BUTTON("DATE"),
    EN_TIME_BUTTON("TIME"),
    EN_MAIN_TEXT("WEATHER IN DNIPRO"),
    EN_DATE_TODAY_LABEL("TODAY: "),
    EN_TIME_TODAY_LABEL("TIME: "),

    RU_COUNTRY("RU"),
    RU_LOCALE("ru"),
    RU_DATE_BUTTON("ДАТА"),
    RU_TIME_BUTTON("ВРЕМЯ"),
    RU_MAIN_TEXT("ПОГОДА В ДНЕПРЕ"),
    RU_DATE_TODAY_LABEL("СЕГОДНЯ: "),
    RU_TIME_TODAY_LABEL("ВРЕМЯ: "),


    UA_COUNTRY("UA"),
    UA_LOCALE("uk"),
    UA_DATE_BUTTON("ДАТА"),
    UA_TIME_BUTTON("ЧАС"),
    UA_MAIN_TEXT("ПОГОДА У ДНІПРІ"),
    UA_DATE_TODAY_LABEL("СЬОГОДНІ: "),
    UA_TIME_TODAY_LABEL("ЧАС: ");

    private final String attribute;

    public String getAttribute() {
        return attribute;
    }

    Constants(String attribute) {
        this.attribute = attribute;
    }

}
