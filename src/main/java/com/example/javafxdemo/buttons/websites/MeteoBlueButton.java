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
import java.util.stream.Collectors;

public class MeteoBlueButton extends WebsiteButton implements Button {

    public MeteoBlueButton(Controller controller) {
        super(controller);
    }

    @Override
    public void onClick() {
        if ( !isClick ) {
            Document doc;
            try {
                String URL = "https://www.meteoblue.com/ru/%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D0%B0/%D0%BD%D0%B5%D0%B4%D0%B5%D0%BB%D1%8F/%D0%94%D0%BD%D0%B5%D0%BF%D1%80_%D0%A3%D0%BA%D1%80%D0%B0%D0%B8%D0%BD%D0%B0_709930";
                doc = Jsoup.connect( URL )
                        .userAgent( browser )
                        .get();
                Elements time = doc.getElementsByClass( "time" );
                Elements temperature = doc.getElementsByClass( "cell" );
                List<String> timeList = getTimeListUpdated( createList( time ), symbolTime );
                List<String> temperatureList = createList( temperature );
                temperatureList = temperatureList.stream()
                        .filter( s -> s.contains( degreeSign ))
                        .filter( s1 -> !s1.contains( celsius ))
                        .limit( countElements )
                        .collect(Collectors.toList());
                temperatureList = getTemperatureListUpdated( temperatureList );
                setLink( METEOBLUE_BUTTON, new URI( URL ));
                getTimeAndTemperature( timeList, temperatureList );
            } catch ( Exception e ) {
                e.printStackTrace();
            }
            isClick = true;
            nameLastPressedButton = METEOBLUE_BUTTON;
        } else {
            if ( nameLastPressedButton.equals( METEOBLUE_BUTTON )) {
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
        List<String> timeListUpdated = new ArrayList<>();
        for ( int i = 0; i < timeList.size(); i++ ) {
            if ( i < 3 ) {
                timeList.set(i, timeList.get(i).charAt(1) + symbolTime );
            } else {
                timeList.set(i, timeList.get(i).substring(0,2) + symbolTime );
            }
            timeListUpdated.add( timeList.get(i) );
        }
        return timeListUpdated;
    }

    @Override
    public List<String> getTemperatureListUpdated(List<String> temperatureList) {
        List<String> temperatureListUpdated = new ArrayList<>();
        for ( int i = 0; i < temperatureList.size(); i++) {
            String first = temperatureList.get(i).substring(0,1);
            if ( !first.equals("-") ) {
                if ( Integer.parseInt(first) != 0 ) {
                    temperatureList.set(i, "+" + temperatureList.get(i));
                }
            }
            temperatureListUpdated.add( temperatureList.get(i));
        }
        return temperatureListUpdated;
    }
}
