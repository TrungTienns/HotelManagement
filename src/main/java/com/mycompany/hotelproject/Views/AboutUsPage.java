package com.mycompany.hotelproject.Views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AboutUsPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Tải ảnh background (bạn hãy thay ảnh chính thức vào đây)
        Image bgImage = new Image("file:src/main/java/images/background.jpg");
        ImageView background = new ImageView(bgImage);
        background.setFitWidth(1200);
        background.setFitHeight(700);
        background.setPreserveRatio(false);

        // -------- Box 1: Thông tin liên hệ --------
        VBox contactBox = new VBox(15);
        contactBox.setPadding(new Insets(20));
        contactBox.setStyle("-fx-background-color: rgba(255,255,255,0.9); -fx-background-radius: 10;");
        contactBox.setMaxWidth(500);
        contactBox.setAlignment(Pos.TOP_LEFT);

        Label contactTitle = new Label("THÔNG TIN LIÊN HỆ");
        contactTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 22));
        contactTitle.setTextFill(Color.web("#990000"));
        contactTitle.setAlignment(Pos.CENTER);

        Label company = new Label("CÔNG TY CỔ PHẦN KHÁCH SẠN SÀI GÒN\n41-47 Đồng Du, Quận 1, Thành phố Hồ Chí Minh, Việt Nam");
        company.setFont(Font.font("Arial", 16));

        Label email = new Label("Email: hotelluxury@gmail.com");
        email.setFont(Font.font("Arial", 16));
        email.setTextFill(Color.web("#990000"));

        Label phone = new Label("Hotline: (+84) 999 699 999\nTel: (84-28) 99 999 999\nFax: (84-28) 99 669 999");
        phone.setFont(Font.font("Arial", 16));

        contactBox.getChildren().addAll(contactTitle, company, email, phone);

        // -------- Box 2: Google Maps --------
        VBox mapBox = new VBox();
        mapBox.setPadding(new Insets(20));
        mapBox.setStyle("-fx-background-color: rgba(255,255,255,0.9); -fx-background-radius: 10;");
        mapBox.setMaxWidth(500);
        mapBox.setAlignment(Pos.CENTER);

        // Ảnh bản đồ (maps.png bạn chuẩn bị sẵn)
        Image mapImage = new Image("file:src/main/java/images/maps.png");
        ImageView mapView = new ImageView(mapImage);
        mapView.setFitWidth(450);
        mapView.setPreserveRatio(true);
        mapBox.getChildren().add(mapView);

        // -------- Tổng thể layout chính --------
        HBox mainBox = new HBox(50, contactBox, mapBox);
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setPadding(new Insets(50));

        // StackPane để có background
        StackPane root = new StackPane(background, mainBox);
        root.setEffect(new DropShadow(5, Color.BLACK));

        Scene scene = new Scene(root, 1200, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Về Chúng Tôi");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}