package com.example.javafxdemo.buttons.websites;

import com.example.javafxdemo.HelloController;
import com.example.javafxdemo.buttons.Button;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class PogodaButton extends WeatherWebsite implements Button {

    private final HelloController controller;

    public PogodaButton(HelloController controller) {
        this.controller = controller;
    }

    @Override
    public void onClick() {
        Document doc;
        try {
            doc = Jsoup.connect( "https://pogoda.meta.ua/Dnipropetrovska/Dnipropetrovskyi/Dnipropetrovsk/" )
                    .userAgent( browser )
                    .get();
            Elements time = doc.getElementsByClass( "city__forecast-time" );
            Elements temperature = doc.getElementsByClass("city__forecast-temperature");

            List<String> timeList = createList( time );
            timeList = getTimeListUpdated( timeList, symbolTime );

            List<String> temperatureList = createList( temperature );
            temperatureList = new ArrayList<>( temperatureList.subList(1,temperatureList.size()) );

            getTimeAndTemperature( controller.getGrid(), timeList, temperatureList );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getTimeListUpdated(List<String> timeList, String symbolTime) {
        List<String> timeListUpdated = new ArrayList<>();
        for ( int i = 0; i < timeList.size(); i++ ) {
            if ( i == 0 ) { continue; }
            if ( i < 5 ) {
                timeList.set(i, timeList.get(i).substring(1));
            }
            timeListUpdated.add( timeList.get(i) );
        }
        return timeListUpdated;
    }

    @Override
    public List<String> getTemperatureListUpdated(List<String> temperatureList) {
        return null;
    }
}
