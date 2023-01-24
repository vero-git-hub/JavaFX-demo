package com.example.javafxdemo.buttons.websites;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.jsoup.select.Elements;

import java.util.Arrays;
import java.util.List;

public abstract class WeatherWebsite {

    public static int countElements = 8;

    public static String symbolTime = ":00";

    public static String celsius = "C";

    public static String degreeSign = "°";

    public static String browser = "Chrome";

    protected abstract List<String> getTimeListUpdated( List<String> timeList, String symbolTime );
    protected abstract List<String> getTemperatureListUpdated( List<String> temperatureList );

    protected void getTimeAndTemperature ( GridPane gridPane, List<String> timeList,
                                        List<String> temperatureList){
        clearGridPane( gridPane );
        getTime( timeList, gridPane );
        getTemperature( temperatureList, gridPane );
    }

    private void clearGridPane( GridPane gridPane ){
        if ( !gridPane.getChildren().isEmpty() ) {
            gridPane.getChildren().clear();
        }
    }

    private void getTime( List<String> timeList, GridPane gridPane ) {
        for ( int i = 0; i < timeList.size(); i++) {
            Label labelTemperature = new Label( timeList.get(i) );
            gridPane.add( labelTemperature, i, 0 );
        }
    }

    private void getTemperature( List<String> temperatureList, GridPane gridPane ) {
        for ( int i = 0; i < temperatureList.size(); i++) {
            Label labelTemperature = new Label( temperatureList.get(i) );
            gridPane.add( labelTemperature, i, 1 );
        }
    }

    protected List<String> createList ( Elements elements ){
        return Arrays.asList( elements.text().split(" ") );
    }

}
