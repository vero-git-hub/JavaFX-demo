package com.example.javafxdemo;

import com.example.javafxdemo.factory.Creator;
import com.example.javafxdemo.factory.datatime.DatetimeCreator;
import com.example.javafxdemo.factory.languages.*;
import com.example.javafxdemo.factory.websites.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Controller {

    private Creator creator;

    public static final String SINOPTIK_BUTTON = "SINOPTIK";
    public static final String GISMETEO_BUTTON = "GISMETEO";
    public static final String METEO_BUTTON = "METEO";
    public static final String POGODA_BUTTON = "POGODA";
    public static final String METEOBLUE_BUTTON = "METEOBLUE";
    public static String language = Localization.DEFAULT_COUNTRY.getAttribute();
    public static Boolean isTimeVisible = false;
    public static String nameLastPressedButton = "";

    @FXML
    private ToggleButton datetimeToggleButton;
    @FXML
    private Label mainText;

    @FXML
    private Label dateText;
    @FXML
    private Label timeText;

    @FXML
    private HBox hBoxHyperlink;
    @FXML
    private GridPane grid;
    @FXML
    private ToggleGroup weatherToggleGroup;

    public ToggleButton getDatetimeToggleButton() {
        return datetimeToggleButton;
    }

    public Label getMainText() {
        return mainText;
    }
    public Label getDateText() {
        return dateText;
    }
    public Label getTimeText() {
        return timeText;
    }
    public HBox getHBoxHyperlink() {
        return hBoxHyperlink;
    }
    public GridPane getGrid() {
        return grid;
    }

    @FXML
    public void onDatetimeButtonClick() {
        creator = new DatetimeCreator( this );
        runBusinessLogic();
    }
    @FXML
    public void onLanguageButtonClick( ActionEvent actionEvent ) {
        configureLanguage( actionEvent );
        runBusinessLogic();
    }

    private void configureLanguage( ActionEvent actionEvent ) {
        String text = getComboBoxText( actionEvent );
        if ( text.equals( Localization.RU_COUNTRY.getAttribute() ) ) {
            creator = new RuCreator(this);
        } else if ( text.equals( Localization.UA_COUNTRY.getAttribute() ) ){
            creator = new UaCreator(this);
        } else {
            creator = new EnCreator(this);
        }
    }

    private String getComboBoxText( ActionEvent actionEvent ) {
        Object node = actionEvent.getSource();
        ComboBox<String> comboBox = (ComboBox) node;
        return comboBox.getValue();
    }

    @FXML
    public void onWebsiteButtonClick(ActionEvent actionEvent) {
        configureWebsite( actionEvent );
        runBusinessLogic();
    }

    private void configureWebsite( ActionEvent actionEvent ) {
        switch ( getToggleButtonText( actionEvent ) ) {
            case SINOPTIK_BUTTON -> creator = new SinoptikCreator( this );
            case GISMETEO_BUTTON -> creator = new GismeteoCreator( this );
            case METEO_BUTTON -> creator = new MeteoCreator( this );
            case POGODA_BUTTON -> creator = new PogodaCreator( this );
            case METEOBLUE_BUTTON -> creator = new MeteoBlueCreator( this );
        }
    }
    
    private String getToggleButtonText ( ActionEvent actionEvent ) {
        Object node = actionEvent.getSource();
        ToggleButton button = (ToggleButton) node;
        return button.getText();
    }

    private void runBusinessLogic() {
        creator.createInstanceFactory();
    }
}