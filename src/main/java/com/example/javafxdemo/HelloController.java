package com.example.javafxdemo;

import com.example.javafxdemo.factory.*;
import com.example.javafxdemo.factory.datatime.DateDialog;
import com.example.javafxdemo.factory.datatime.TimeDialog;
import com.example.javafxdemo.factory.languages.EnDialog;
import com.example.javafxdemo.factory.languages.RuDialog;
import com.example.javafxdemo.factory.languages.UaDialog;
import com.example.javafxdemo.factory.websites.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class HelloController {

    private Dialog dialog;

    public static String language = Constants.DEFAULT_LOCALE.getAttribute();
    public static Boolean isDateVisible = false;
    public static Boolean isTimeVisible = false;


    final String EN_DATE_BUTTON = "DATE";
    final String EN_TIME_BUTTON = "TIME";

    final String RU_DATE_BUTTON = "ДАТА";
    final String RU_TIME_BUTTON = "ВРЕМЯ";
    final String UA_TIME_BUTTON = "ЧАС";

    final String SINOPTIK_BUTTON = "SINOPTIK";
    final String GISMETEO_BUTTON = "GISMETEO";
    final String METEO_BUTTON = "METEO";
    final String POGODA_BUTTON = "POGODA";
    final String METEOBLUE_BUTTON = "METEOBLUE";


    @FXML
    protected GridPane grid;

    @FXML
    protected Button dateButton;

    @FXML
    protected Button timeButton;

    @FXML
    protected Label dateToday;
    @FXML
    protected Label dateTodayLabel;
    @FXML
    protected Label timeToday;

    @FXML
    protected Label timeTodayLabel;

    @FXML
    protected Label mainText;

    public GridPane getGrid() {
        return grid;
    }

    public Button getDateButton() {
        return dateButton;
    }

    public Button getTimeButton() {
        return timeButton;
    }

    public Label getDateToday() {
        return dateToday;
    }

    public Label getDateTodayLabel() {
        return dateTodayLabel;
    }

    public Label getTimeToday() {
        return timeToday;
    }

    public Label getTimeTodayLabel() {
        return timeTodayLabel;
    }

    public Label getMainText() {
        return mainText;
    }

    @FXML
    public void onWebsiteButtonClick(ActionEvent actionEvent) {
        configureWebsite( actionEvent );
        runBusinessLogic();
    }

    @FXML
    public void onLanguageButtonClick( ActionEvent actionEvent ) {
        configureLanguage( actionEvent );
        runBusinessLogic();
    }

    @FXML
    public void onDatetimeButtonClick( ActionEvent actionEvent ) {
        configureDatetime( actionEvent );
        runBusinessLogic();
    }

    private void runBusinessLogic() {
        dialog.renderWindow();
    }

    private void configureWebsite( ActionEvent actionEvent ) {
        switch ( getButtonText( actionEvent ) ) {
            case SINOPTIK_BUTTON -> dialog = new SinoptikDialog( this );
            case GISMETEO_BUTTON -> dialog = new GismeteoDialog( this );
            case METEO_BUTTON -> dialog = new MeteoDialog( this );
            case POGODA_BUTTON -> dialog = new PogodaDialog( this );
            case METEOBLUE_BUTTON -> dialog = new MeteoBlueDialog( this );
        }
    }

    private void configureLanguage(ActionEvent actionEvent ) {
        String text = getButtonText( actionEvent );
        if ( text.equals( Constants.RU_COUNTRY.getAttribute() ) ) {
            dialog = new RuDialog(this);
        } else if ( text.equals( Constants.UA_COUNTRY.getAttribute() ) ){
            dialog = new UaDialog(this);
        } else {
            dialog = new EnDialog(this);
        }
    }

    private void configureDatetime( ActionEvent actionEvent ) {
        switch ( getButtonText( actionEvent )  ) {
            case EN_DATE_BUTTON, RU_DATE_BUTTON -> dialog = new DateDialog( this );
            case EN_TIME_BUTTON, RU_TIME_BUTTON, UA_TIME_BUTTON  -> dialog = new TimeDialog( this );
        }
    }

    private String getButtonText ( ActionEvent actionEvent ) {
        Object node = actionEvent.getSource();
        Button button = (Button)node;
        return button.getText();
    }
}