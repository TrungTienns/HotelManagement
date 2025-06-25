package com.mycompany.hotelproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DashbroardAdmin extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Màu sắc & style mới theo phong cách cao cấp
        String backgroundColor = "#ffffff";     // Nền trắng
        String sidebarColor = "#1a1a1a";        // Sidebar đen sang
        String textColor = "#f0c330";           // Vàng (như BOOK NOW)
        String cardBorderColor = "#e0e0e0";     // Viền nhạt cho card
        String cardTextColor = "#222222";       // Text đậm

        // Sidebar
        VBox sidebar = new VBox(20);
        sidebar.setPadding(new Insets(30));
        sidebar.setStyle("-fx-background-color:" + sidebarColor + ";");
        sidebar.setPrefWidth(250);

        Label logo = new Label("ADMIN HOTEL");
        logo.setFont(Font.font("Georgia", 22));
        logo.setTextFill(Color.web(textColor));

        Button btnRooms = createNavButton("Phòng", textColor);
        Button btnUsers = createNavButton("Người dùng", textColor);
        Button btnBookings = createNavButton("Đặt phòng", textColor);
        Button btnRevenue = createNavButton("Doanh thu", textColor);
        Button btnSevice = createNavButton("Dịch vụ", textColor);
        Button btnReport = createNavButton("Báo cáo", textColor);

        sidebar.getChildren().addAll(logo, btnRooms, btnUsers, btnBookings, btnRevenue ,btnSevice,btnReport);

        // Main content
        VBox mainContent = new VBox(20);
        mainContent.setPadding(new Insets(30));

        HBox statsRow = new HBox(20);
        statsRow.getChildren().addAll(
                createStatCard("Phòng", "120", cardTextColor, cardBorderColor),
                createStatCard("Phòng đã đặt", "12", cardTextColor, cardBorderColor),
                createStatCard("Doanh thu", "20 triệu", cardTextColor, cardBorderColor)
                
        );
        mainContent.getChildren().addAll(statsRow);

        // Layout chính
        BorderPane layout = new BorderPane();
        layout.setLeft(sidebar);
        layout.setCenter(mainContent);
        layout.setStyle("-fx-background-color:" + backgroundColor + ";");

        Scene scene = new Scene(layout, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Admin DashBoard - HOTEL MANAGEMENT");
        primaryStage.show();
    }

    private Button createNavButton(String text, String textColor) {
        Button btn = new Button(text);
        btn.setPrefWidth(180);
        btn.setStyle("-fx-background-color: #f0c330; -fx-text-fill: #000000 ; -fx-font-size: 16px; -fx-font-family: 'Segoe UI'");
        btn.setOnMouseEntered(e -> btn.setStyle("-fx-background-color: #B8860B; -fx-text-fill:#000000; -fx-font-size:16px; -fx-font-family: 'Segoe UI'"));
        btn.setOnMouseExited(e -> btn.setStyle("-fx-background-color: #f0c330; -fx-text-fill: #000000 ; -fx-font-size: 16px; -fx-font-family: 'Segoe UI'"));
        return btn;
    }

    private VBox createStatCard(String title, String value, String textColor, String borderColor) {
        VBox card = new VBox(10);
        card.setPadding(new Insets(20));
        card.setAlignment(Pos.CENTER_LEFT);
        card.setPrefSize(200, 100);
        card.setStyle("-fx-background-color: white; -fx-border-color: " + borderColor + "; -fx-border-radius: 10; -fx-background-radius: 10; -fx-effect: dropshadow(two-pass-box, rgba(0,0,0,0.08), 4, 0, 0, 2);");

        Label lblTitle = new Label(title);
        lblTitle.setTextFill(Color.web(textColor));
        lblTitle.setFont(Font.font("Segoe UI Semibold", 14));

        Label lblValue = new Label(value);
        lblValue.setTextFill(Color.web("#000000"));
        lblValue.setFont(Font.font("Segoe UI", 24));

        card.getChildren().addAll(lblTitle, lblValue);
        return card;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
