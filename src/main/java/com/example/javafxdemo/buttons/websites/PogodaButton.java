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

public class PogodaButton extends WebsiteButton implements Button {

    public PogodaButton(Controller controller) {
        super(controller);
    }

    @Override
    public void onClick() {
        if ( !isClick ) {
            Document doc;
            try {
                String URL = "https://pogoda.meta.ua/Dnipropetrovska/Dnipropetrovskyi/Dnipropetrovsk/";
                doc = Jsoup.connect( URL )
                        .userAgent( browser )
                        .get();
                Elements time = doc.getElementsByClass( "city__forecast-time" );
                Elements temperature = doc.getElementsByClass("city__forecast-temperature");
                List<String> timeList = getTimeListUpdated( createList( time ), symbolTime );
                List<String> temperatureList = createList( temperature );
                temperatureList = new ArrayList<>( temperatureList.subList(1,temperatureList.size()) );
                setLink( POGODA_BUTTON, new URI( URL ));
                getTimeAndTemperature( timeList, temperatureList );
            } catch ( Exception e ) {
                e.printStackTrace();
            }
            isClick = true;
            nameLastPressedButton = POGODA_BUTTON;
        } else {
            if ( nameLastPressedButton.equals( POGODA_BUTTON ) ) {
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
