package com.mycompany.hotelproject.Views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AllRoom extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox roomContainer = new VBox(10); // Khoảng cách giữa các phòng
        roomContainer.getChildren().addAll(
                createRoomCard("Saigon Suite", "50m²", "2 người", "01 Giường lớn"),
                createRoomCard("Suite", "44m²", "2 người", "01 Giường lớn"),
                createRoomCard("Deluxe Suite", "60m²", "2 người", "01 Giường lớn"),
                createRoomCard("Executive Suite", "55m²", "2 người", "01 Giường lớn"),
                createRoomCard("Premium Suite", "70m²", "2 người", "01 Giường lớn")
        );

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(roomContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: #333;");

        Scene scene = new Scene(scrollPane, 800, 600);
        primaryStage.setTitle("Danh Sách Phòng");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createRoomCard(String roomType, String size, String occupants, String bed) {
        VBox card = new VBox(5);
        card.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 10; -fx-border-color: #ccc; -fx-border-width: 1;");

        // Thêm mô tả phòng (giống giao diện)
        card.getChildren().addAll(
                new javafx.scene.control.Label(roomType),
                new javafx.scene.control.Label("Diện tích: " + size),
                new javafx.scene.control.Label("Số người: " + occupants),
                new javafx.scene.control.Label("Giường: " + bed),
                new javafx.scene.control.Button("Đặt Phòng"),
                new javafx.scene.control.Button("Chi Tiết")
        );

        return card;
    }

    public static void main(String[] args) {
        launch(args);
    }
}