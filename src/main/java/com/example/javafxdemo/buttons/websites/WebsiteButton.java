package com.example.javafxdemo.buttons.websites;

import com.example.javafxdemo.Controller;
import static com.example.javafxdemo.factory.Creator.getCurrentTime;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

public abstract class WebsiteButton {

    protected final Controller controller;
    public static int countElements = 8;

    public static String symbolTime = ":00";

    public static String celsius = "C";

    public static String degreeSign = "°";

    public static String browser = "Chrome";

    public static boolean isClick = false;

    protected int idxNowTimeTemperature;

    public WebsiteButton(Controller controller) {
        this.controller = controller;
    }

    protected abstract List<String> getTimeListUpdated( List<String> timeList, String symbolTime );
    protected abstract List<String> getTemperatureListUpdated( List<String> temperatureList );


    protected void getTimeAndTemperature ( List<String> timeList,
                                        List<String> temperatureList){
        GridPane gridPane = controller.getGrid();
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
        String currentTime = getCurrentTime( "HH" );

        int now = Integer.parseInt( currentTime );
        int nextHour = now+1;
        int nextTwoHours = now+2;

        for ( int i = 0; i < timeList.size(); i++) {
            Label label = new Label( timeList.get(i) );
            gridPane.add( label, i, 0 );
            int time;
            if ( timeList.get(i).length() == 4 ) {
                time = Integer.parseInt( timeList.get(i).substring(0,1) );
            } else {
                time = Integer.parseInt( timeList.get(i).substring(0,2) );
            }

            if ( now == time || nextHour == time || nextTwoHours == time ) {
                idxNowTimeTemperature = i;
                label.setStyle("-fx-text-fill: -changing-text; -fx-effect: dropshadow( gaussian , white , 5 , 1 , 0.0 , 0.0 ); ");
            }
        }
    }

    private void getTemperature( List<String> temperatureList, GridPane gridPane ) {
        for ( int i = 0; i < temperatureList.size(); i++) {
            Label label = new Label( temperatureList.get(i) );
            gridPane.add( label, i, 1 );
            if ( idxNowTimeTemperature == i ) {
                label.setStyle("-fx-text-fill: -changing-text; -fx-effect: dropshadow( gaussian , white , 5 , 1 , 0.0 , 0.0 ); ");
            }
        }
    }

    protected List<String> createList ( Elements elements ){
        return Arrays.asList( elements.text().split(" ") );
    }

    protected void setLink(String websiteName, URI uri) {
        Hyperlink hlink = new Hyperlink( websiteName );
        hlink.setId("websiteLink");
        hlink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    java.awt.Desktop.getDesktop().browse(uri);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        clearHBoxHyperlink();
        controller.getHBoxHyperlink().getChildren().add( hlink );
        hlink.focusTraversableProperty().setValue(false);
    }

    protected void clearWeatherFields(){
        clearHBoxHyperlink();
        clearGridPane( controller.getGrid() );
    }

    private void clearHBoxHyperlink(){
        controller.getHBoxHyperlink().getChildren().clear();
    }

}
