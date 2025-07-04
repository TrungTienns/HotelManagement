package com.mycompany.hotelproject;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LandingPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Thanh menu đơn giản
        HBox menuBar = new HBox(30);
        menuBar.setPadding(new Insets(20));
        menuBar.setStyle("-fx-background-color: #F5F5DC;");
        
        Label logo = new Label("Luxury Hotel");
        logo.setFont(Font.font(20));
        logo.setStyle("-fx-font-weight: bold;");

        Label home = new Label("Trang chủ");
        Label service = new Label("Dịch vụ");
        Label about = new Label("Về chúng tôi");
        Label contact = new Label("Liên hệ");

        // Icon Account
        Button accountBtn = new Button("👤");
        accountBtn.setStyle("-fx-font-size: 20px; -fx-background-color: transparent;");

        // Sự kiện khi click vào icon account
        accountBtn.setOnAction(e -> showLoginRegisterDialog(primaryStage));

        HBox menuItems = new HBox(20, home, service, about, contact, accountBtn);
        menuItems.setAlignment(Pos.CENTER_RIGHT);
        menuBar.getChildren().addAll(logo, menuItems);
        HBox.setHgrow(menuItems, Priority.ALWAYS);

        // Tiêu đề
        Label title = new Label("LUXURY HOTEL & RESORT");
        title.setFont(Font.font("Arial", 36));
        title.setStyle("-fx-font-weight: bold;");

        Label promo = new Label("Giảm 20% cho khách hàng đặt khách sạn online");
        promo.setFont(Font.font("Arial", 20));
        promo.setTextFill(Color.DARKRED);

        Label description = new Label("Lựa chọn cho sự thư giãn của gia đình bạn");
        description.setFont(Font.font("Arial", 14));

        VBox textBox = new VBox(10, title, promo, description);
        textBox.setAlignment(Pos.CENTER_LEFT);

        // Hình ảnh tròn
        Image image = new Image("file:src/main/resources/hotel.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(300);
        imageView.setFitHeight(300);
        Circle clip = new Circle(150, 150, 150);
        imageView.setClip(clip);

        // Bố cục chính
        HBox mainContent = new HBox(50, textBox, imageView);
        mainContent.setPadding(new Insets(40));
        mainContent.setAlignment(Pos.CENTER);

        // Nút Book Now
        Button bookNow = new Button("Đặt ngayyyy");
        bookNow.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white; -fx-font-size: 16;");
        bookNow.setFont(Font.font("Arial", 30));
        textBox.getChildren().add(bookNow);
        

        // Tổng thể
        VBox root = new VBox(menuBar, mainContent);
        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setTitle("Luxury Hotel & Resort");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Hàm hiển thị popup đăng nhập/đăng ký
    private void showLoginRegisterDialog(Stage owner) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(owner);
        dialog.setTitle("Account");

        Button loginButton = new Button("Đăng nhập");
        Button registerButton = new Button("Đăng ký");

        loginButton.setPrefWidth(150);
        registerButton.setPrefWidth(150);

        loginButton.setStyle("-fx-font-size: 14px;");
        registerButton.setStyle("-fx-font-size: 14px;");

        VBox dialogVBox = new VBox(20, loginButton, registerButton);
        dialogVBox.setAlignment(Pos.CENTER);
        dialogVBox.setPadding(new Insets(30));

        Scene dialogScene = new Scene(dialogVBox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    public static void main(String[] args) {
        launch();
    }
}