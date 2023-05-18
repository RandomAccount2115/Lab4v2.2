package com.example.lab4v2;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    private final int steelDensity = 7871;
    private final int stainlessSteelDensity = 7980;

    private final int steelPrice = 5;
    private final int stainlessSteelPrice = 18;

    public ChoiceBox metal;
    public TextField radius;
    public TextField height;
    public TextField thickness;
    public TextField weight;
    public TextField cost;
    public Button start;


    @FXML
    public void initialize(){

        metal.getItems().add("Blacha stalowa");
        metal.getItems().add("Blacha stalowa nierdzewna");

        start.setOnAction((event) -> {
            if (this.guiInputChecker() == false){
                return;
            }
            float tempWeight;
            float tempCost;
            tempWeight = this.getWeight(Float.parseFloat(radius.getText()), Float.parseFloat(height.getText()), Float.parseFloat(thickness.getText()), (String) metal.getValue());
            tempCost = this.getCost(tempWeight, (String) metal.getValue());
            this.updateGUI(tempWeight,  tempCost);
        });

    }



    public float getWeight(float tRadius, float tHeight, float tThickness, String tMaterial){

        float cylinderArea;
        float steelVolume;
        float cylinderWeight;

        cylinderArea = (float) (2 * Math.PI * tRadius * (tRadius + tHeight));

        steelVolume = cylinderArea * tThickness * 0.1f;

        if (tMaterial.equals("Blacha stalowa")){
            cylinderWeight = steelVolume * (steelDensity / 1000000f);
        }
        else {
            cylinderWeight = steelVolume * (stainlessSteelDensity / 1000000f);
        }

        return cylinderWeight;
    }

    public float getCost(float tWeight, String tMaterial){

        float materialCost;

        if (tMaterial.equals("Blacha stalowa")){
            materialCost = tWeight * steelPrice;
        }
        else {
            materialCost = tWeight * stainlessSteelPrice;
        }

        return Math.round(materialCost * 100) / 100f;

    }

    public void updateGUI(float tWeight, float tCost){

        weight.setText(Float.toString(tWeight));
        cost.setText(Float.toString(tCost));

    }

    private boolean guiInputChecker(){

        boolean result = true;

        if (metal.getValue() == null){
            metal.setStyle("-fx-base: #f74f4f;");
            result = false;
        }
        else {
            metal.setStyle("");
        }

        try {
            if (Float.parseFloat(radius.getText()) < 0){
                radius.setStyle("-fx-base: #f74f4f;");
                result = false;
            }
            else {
                radius.setStyle("");
            }
        } catch (NumberFormatException n){
            radius.setStyle("-fx-base: #f74f4f;");
            result = false;
        }

        try {
            if (Float.parseFloat(height.getText()) < 0){
                height.setStyle("-fx-base: #f74f4f;");
                result = false;
            }
            else {
                height.setStyle("");
            }
        } catch (NumberFormatException n){
            height.setStyle("-fx-base: #f74f4f;");
            result = false;
        }

        try {
            if (Float.parseFloat(thickness.getText()) < 0){
                thickness.setStyle("-fx-base: #f74f4f;");
                result = false;
            }
            else {
                thickness.setStyle("");
            }
        } catch (NumberFormatException n){
            thickness.setStyle("-fx-base: #f74f4f;");
            result = false;
        }

        if (result == false){
            weight.setText("");
            cost.setText("");
        }

        return result;
    }




}