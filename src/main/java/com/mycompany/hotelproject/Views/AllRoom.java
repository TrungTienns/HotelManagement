package com.mycompany.hotelproject.Views;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AllRoom extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox roomContainer = new VBox(20); // Phòng xếp dọc, cách nhau 20px
        roomContainer.setStyle("-fx-padding: 20;");
        roomContainer.setAlignment(Pos.TOP_CENTER);

        roomContainer.getChildren().addAll(
                createRoomCard("Saigon Suite", "50m²", "2 người", "01 Giường lớn"),
                createRoomCard("Suite", "44m²", "2 người", "01 Giường lớn"),
                createRoomCard("Deluxe Suite", "60m²", "2 người", "01 Giường lớn"),
                createRoomCard("Executive Suite", "55m²", "2 người", "01 Giường lớn"),
                createRoomCard("Premium Suite", "70m²", "2 người", "01 Giường lớn")
        );

        ScrollPane scrollPane = new ScrollPane(roomContainer);
        scrollPane.setFitToWidth(true); // Để card tự giãn ngang vừa màn hình
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setStyle("-fx-background: #333;");

        Scene scene = new Scene(scrollPane, 800, 600);
        primaryStage.setTitle("Danh Sách Phòng");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createRoomCard(String roomType, String size, String occupants, String bed) {
        VBox card = new VBox(10);
        card.setStyle("-fx-background-color: white; -fx-border-color: #ccc; -fx-border-width: 1; -fx-padding: 10; -fx-background-radius: 8;");
        card.setMaxWidth(600); // Giới hạn chiều ngang để không bị quá rộng

        // Ảnh minh họa
        ImageView imageView = new ImageView("file:src/main/java/images/banner.jpg");
        imageView.setFitWidth(600);
        imageView.setFitHeight(300);
        imageView.setPreserveRatio(false);

        Label nameLabel = new Label(roomType);
        nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");

        VBox infoBox = new VBox(
                nameLabel,
                new Label("Diện tích: " + size),
                new Label("Số người: " + occupants),
                new Label("Giường: " + bed),
                new Button("Đặt Phòng"),
                new Button("Chi Tiết")
        );
        infoBox.setSpacing(5);
        infoBox.setAlignment(Pos.CENTER_LEFT);

        card.getChildren().addAll(imageView, infoBox);
        return card;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
