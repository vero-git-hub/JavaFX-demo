package com.example.javafxdemo.buttons.websites;

import com.example.javafxdemo.Controller;
import com.example.javafxdemo.buttons.Button;
import static com.example.javafxdemo.Controller.GISMETEO_BUTTON;
import static com.example.javafxdemo.Controller.nameLastPressedButton;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GismeteoButton extends WebsiteButton implements Button {

    public GismeteoButton(Controller controller) {
        super(controller);
    }

    @Override
    public void onClick() {
        if ( !isClick) {
            Document doc;
            try {
                String URL = "https://www.gismeteo.ua/weather-dnipro-5077/";
                doc = Jsoup.connect(URL).get();
                Elements time = doc.getElementsByClass( "widget-row-time" );
                Elements temperature = doc.getElementsByClass("unit_temperature_c" );
                List<String> timeList = getTimeListUpdated( createList( time ), symbolTime );
                List<String> temperatureList = createList( temperature );
                ArrayList<String> copy = new ArrayList<>(temperatureList.subList(6,temperatureList.size()));
                temperatureList = getTemperatureListUpdated( copy );
                setLink( GISMETEO_BUTTON, new URI(URL));
                getTimeAndTemperature( timeList, temperatureList );
            } catch ( Exception e ) {
                e.printStackTrace();
            }
            isClick = true;
            nameLastPressedButton = GISMETEO_BUTTON;
        } else {
            if ( nameLastPressedButton.equals( GISMETEO_BUTTON ) ) {
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
        for ( int i = 0; i < temperatureList.size(); i++) {
            List<String> list = Arrays.asList( temperatureList.get(i).split("") );
            String minus = "-";
            if ( list.get(0).equals("−") ){
                String newStr = minus + temperatureList.get(i).substring(1);
                temperatureList.set(i, newStr );
            }
            temperatureListUpdated.add( temperatureList.get(i) + degreeSign );
        }
        return temperatureListUpdated;
    }
}