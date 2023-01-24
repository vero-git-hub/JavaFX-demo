package com.example.javafxdemo.buttons.websites;

import com.example.javafxdemo.HelloController;
import com.example.javafxdemo.buttons.Button;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class GismeteoButton extends WeatherWebsite implements Button {
    private final HelloController controller;

    public GismeteoButton(HelloController controller) {
        this.controller = controller;
    }

    @Override
    public void onClick() {
        Document doc;
        try {
            doc = Jsoup.connect( "https://www.gismeteo.ua/weather-dnipro-5077/" ).get();
            Elements time = doc.getElementsByClass( "widget-row-time" );
            Elements temperature = doc.getElementsByClass(
                    "unit_temperature_c" );

            List<String> timeList = createList( time );
            timeList = getTimeListUpdated( timeList, symbolTime );

            List<String> temperatureList = createList( temperature );
            ArrayList<String> copy = new ArrayList<>(temperatureList.subList(6,temperatureList.size()));
            temperatureList = getTemperatureListUpdated( copy );

            getTimeAndTemperature( controller.getGrid(), timeList, temperatureList );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getTimeListUpdated(List<String> timeList, String symbolTime) {
        List<String> listTimeUpdated = new ArrayList<>();

        int countElements = 8;
        for (int i = 0; i < countElements ; i++ ){
            String[] number = timeList.get(i).split("");

            if ( number.length == 3 ) {
                listTimeUpdated.add( number[0] + symbolTime );
            }
            if ( number.length == 4 ) {
                listTimeUpdated.add( number[0] + number[1] + symbolTime );
            }
        }
        return listTimeUpdated;
    }

    @Override
    public List<String> getTemperatureListUpdated(List<String> temperatureList) {
        List<String> temperatureListUpdated = new ArrayList<>();
        for ( String str : temperatureList ) {
            temperatureListUpdated.add( str + degreeSign );
        }
        return temperatureListUpdated;
    }
}