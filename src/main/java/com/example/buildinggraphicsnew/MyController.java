package com.example.buildinggraphicsnew;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MyController {
    @FXML
    private Button button;
    @FXML private AnchorPane anchorPane;
    @FXML private Canvas canvas;
    @FXML
    private TextField field;
    @FXML
    private void initialize() {

        anchorPane.setOnScroll(
                new EventHandler<ScrollEvent>() {
                    @Override
                    public void handle(ScrollEvent event) {
                        double zoomFactor = 1.05;
                        double deltaY = event.getDeltaY();

                        if ((deltaY < 0) ){
                            zoomFactor = 0.95;
                        }
                        anchorPane.setScaleX(anchorPane.getScaleX() * zoomFactor);
                        anchorPane.setScaleY(anchorPane.getScaleY() * zoomFactor);
                        //event.consume();
                    }
                });
        anchorPane.setOnMousePressed(pressEvent -> {
            anchorPane.setOnMouseDragged(dragEvent -> {
                anchorPane.setLayoutX(dragEvent.getScreenX() - pressEvent.getSceneX());
                anchorPane.setLayoutY(dragEvent.getScreenY() - pressEvent.getSceneY());
            });
        });
    }
    @FXML public void buttonOnAction(){
        Rasterization.drawLine(canvas.getGraphicsContext2D(),field.getText(), Color.BLACK);
    }
   /* @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }*/

}