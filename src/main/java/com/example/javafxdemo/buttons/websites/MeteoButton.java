package com.example.javafxdemo.buttons.websites;

import com.example.javafxdemo.Controller;
import com.example.javafxdemo.buttons.Button;
import static com.example.javafxdemo.Controller.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class MeteoButton extends WebsiteButton implements Button {

    public MeteoButton(Controller controller) {
        super(controller);
    }

    @Override
    public void onClick() {
        if ( !isClick) {
            Document doc;
            try {
                String URL = "https://meteo.ua/164/dnepr-dnepropetrovsk";
                doc = Jsoup.connect( URL ).get();
                Elements time = doc.getElementsByClass( "weather-detail__main-time" );
                Elements temperature = doc.getElementsByClass( "weather-detail__main-degree" );
                List<String> timeList = createList( time );
                timeList = getTimeListUpdated( new ArrayList<>( timeList.subList(0,8) ), symbolTime );
                List<String> temperatureList = createList( temperature );
                temperatureList = temperatureList.stream()
                        .filter( s -> !s.equals( degreeSign ))
                        .limit( countElements )
                        .toList();
                temperatureList = getTemperatureListUpdated( temperatureList );
                setLink( METEO_BUTTON, new URI( URL ));
                getTimeAndTemperature( timeList, temperatureList );
            } catch ( Exception e ) {
                e.printStackTrace();
            }
            isClick = true;
            nameLastPressedButton = METEO_BUTTON;
        } else {
            if ( nameLastPressedButton.equals( METEO_BUTTON )) {
                clearWeatherFields();
                isClick = false;
            } else {
                isClick = false;
                onClick();
            }
        }
    }

    @Override
    public List<String> getTimeListUpdated(List<String> timeList, String symbolTime) {
        List<String> listTimeUpdated = new ArrayList<>();
        int countElements = 8;
        for (int i = 0; i < countElements; i++ ) {
            if ( i < 4) {
                timeList.set(i, timeList.get(i).substring(1));
            }
            listTimeUpdated.add( timeList.get(i) );
        }
        return listTimeUpdated;
    }

    @Override
    public List<String> getTemperatureListUpdated(List<String> temperatureList) {
        List<String> listTemperatureUpdated = new ArrayList<>();
        for (String s : temperatureList) {
            listTemperatureUpdated.add( s + degreeSign );
        }
        return listTemperatureUpdated;
    }
}
