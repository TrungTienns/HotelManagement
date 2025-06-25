package com.mycompany.hotelproject;

import com.mycompany.hotelproject.Views.RoomView;
import com.mycompany.hotelproject.Views.ServiceView;
import com.mycompany.hotelproject.Views.UserView;
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
    private BorderPane layout;
    private VBox mainContent;
    private RoomView roomView;
    private ServiceView serviceView;
    private UserView userView;
    
    @Override
    public void start(Stage primaryStage) {
        // Màu sắc & style
        String backgroundColor = "#ffffff";
        String sidebarColor = "#1a1a1a";
        String textColor = "#f0c330";

        // Khởi tạo RoomView
        roomView = new RoomView();
        
        //Khởi tạo Service
        serviceView = new ServiceView();
        
        userView = new UserView();

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
        Button btnService = createNavButton("Dịch vụ", textColor);
        Button btnReport = createNavButton("Báo cáo", textColor);

        // Sự kiện chuyển view
        btnRooms.setOnAction(e -> showRoomView());
        btnUsers.setOnAction(e -> showUsersView());
        btnBookings.setOnAction(e -> showBookingsView());
        btnRevenue.setOnAction(e -> showRevenueView());
        btnService.setOnAction(e -> showServiceView());
        btnReport.setOnAction(e -> showReportView());

        sidebar.getChildren().addAll(logo, btnRooms, btnUsers, btnBookings, btnRevenue, btnService, btnReport);

        // Main content mặc định là RoomView
        mainContent = new VBox();
        mainContent.getChildren().add(roomView.createRoomView());

        // Layout chính
        layout = new BorderPane();
        layout.setLeft(sidebar);
        layout.setCenter(mainContent);
        layout.setStyle("-fx-background-color:" + backgroundColor + ";");

        Scene scene = new Scene(layout, 1200, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Admin DashBoard - HOTEL MANAGEMENT");
        primaryStage.show();
    }

    // Tạo nút sidebar
    private Button createNavButton(String text, String textColor) {
        Button btn = new Button(text);
        btn.setFont(Font.font("Segoe UI", 16));
        btn.setStyle("-fx-background-color: transparent; -fx-text-fill: " + textColor + ";");
        btn.setPrefWidth(200);
        btn.setAlignment(Pos.CENTER_LEFT);
        btn.setOnMouseEntered(e -> btn.setStyle("-fx-background-color: #333333; -fx-text-fill: " + textColor + ";"));
        btn.setOnMouseExited(e -> btn.setStyle("-fx-background-color: transparent; -fx-text-fill: " + textColor + ";"));
        return btn;
    }

    // Hiển thị RoomView
    private void showRoomView() {
        mainContent.getChildren().clear();
        mainContent.getChildren().add(roomView.createRoomView());
    }

    
    private void showUsersView() {
    mainContent.getChildren().clear();
    mainContent.getChildren().add(userView.createUserView());
}

    private void showBookingsView() {
        mainContent.getChildren().clear();
        Label label = new Label("Chức năng quản lý đặt phòng đang phát triển.");
        label.setFont(Font.font("Segoe UI", 18));
        mainContent.getChildren().add(label);
    }

    private void showRevenueView() {
        mainContent.getChildren().clear();
        Label label = new Label("Chức năng doanh thu đang phát triển.");
        label.setFont(Font.font("Segoe UI", 18));
        mainContent.getChildren().add(label);
    }

    private void showServiceView() {
        mainContent.getChildren().clear();
        mainContent.getChildren().add(serviceView.createServiceView());
    }

    private void showReportView() {
        mainContent.getChildren().clear();
        Label label = new Label("Chức năng báo cáo đang phát triển.");
        label.setFont(Font.font("Segoe UI", 18));
        mainContent.getChildren().add(label);
    }

    public static void main(String[] args) {
        launch(args);
    }
}