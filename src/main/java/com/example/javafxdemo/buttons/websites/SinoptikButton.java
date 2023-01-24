package com.example.javafxdemo.buttons.websites;

import com.example.javafxdemo.HelloController;
import com.example.javafxdemo.buttons.Button;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class SinoptikButton extends WeatherWebsite implements Button {

    private final HelloController controller;

    public SinoptikButton(HelloController controller) {
        this.controller = controller;
    }

    @Override
    public void onClick() {
        Document doc;
        try {
            String url = "https://sinoptik.ua/%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D0%B0-%D0%B4%D0%BD%D0%B5%D0%BF%D1%80-303007131";
            doc = Jsoup.connect(url).get();
            String idNameContent = "bd1c";
            Element content = doc.getElementById(idNameContent);
            assert content != null;
            String classNameTime = "time";
            Elements time = content.getElementsByClass(classNameTime);
            String classNameTemperature = "temperature";
            Elements temperature = content.getElementsByClass(classNameTemperature);

            List<String> timeList = createList( time );
            timeList = getTimeListUpdated( timeList, symbolTime );

            List<String> temperatureList = createList( temperature );
            getTimeAndTemperature( controller.getGrid(), timeList, temperatureList);

        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getTimeListUpdated(List<String> timeList, String symbolTime) {
        List<String> listTimeUpdated = new ArrayList<>();
        for ( int i = 0; i < timeList.size(); i++ ){
            if ( i % 2 == 0 ) {
                listTimeUpdated.add( timeList.get(i) + symbolTime);
            }
        }
        return listTimeUpdated;
    }

    @Override
    public List<String> getTemperatureListUpdated(List<String> temperatureList) {
        return null;
    }
}