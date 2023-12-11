package org.example;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static spark.Spark.port;
import static spark.Spark.post;

public class Main {
    public static void main(String[] args) {
        PainelGrafico pg = new PainelGrafico();

        port(8080);

        post("/api", (req, res) -> {
            double IMC,m,a;

            String corpoRequisicao = req.body();
            System.out.println("Corpo JSON: " + corpoRequisicao);

            JsonElement jsonElement = JsonParser.parseString(corpoRequisicao);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            pg.inputFieldAltura.setText(jsonObject.get("altura").getAsString());
            pg.inputFieldMassa.setText(jsonObject.get("massa").getAsString());

            a = Double.parseDouble(pg.inputFieldAltura.getText());
            m = Double.parseDouble(pg.inputFieldMassa.getText());
            IMC=m/(a*a);

            pg.inputFieldIMC.setText(String.format("%.2f",IMC));

            return "{\"IMC\":\"" +  String.format("%.2f",IMC) + "\"}";
        });
    }
}