package com.mycompany.hotelproject.Views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        // Tải ảnh background
        Image bgImage = new Image("file:src/main/java/images/background.jpg");
        ImageView background = new ImageView(bgImage);
        background.setFitWidth(1200);
        background.setFitHeight(700);
        background.setPreserveRatio(false);

        //Box 1 
        VBox contactBox = new VBox(15);
        contactBox.setPadding(new Insets(20));
        contactBox.setStyle("-fx-background-color: rgba(255,255,255,0.9); -fx-background-radius: 10;");
        contactBox.setAlignment(Pos.TOP_LEFT);
        contactBox.setPrefWidth(500);  // Cố định width để tránh tràn
        contactBox.setMaxHeight(600);  // Chống box cao quá

        Label contactTitle = new Label("THÔNG TIN LIÊN HỆ");
        contactTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 22));
        contactTitle.setTextFill(Color.web("#990000"));
        HBox titleBox = new HBox(contactTitle);
        titleBox.setAlignment(Pos.CENTER);
        //
        Label company = new Label("CÔNG TY CỔ PHẦN KHÁCH SẠN SÀI GÒN\n41-47 Đồng Du, Quận 1, TP.HCM, Việt Nam");
        company.setFont(Font.font("Arial", 16));
        company.setWrapText(true);
        //
        Label email = new Label("Email: hotelluxury@gmail.com");
        email.setFont(Font.font("Arial", 16));
        email.setTextFill(Color.web("#990000"));
        //
        Label phone = new Label("Hotline: (+84) 999 699 999\nTel: (84-28) 99 999 999\nFax: (84-28) 99 669 999");
        phone.setFont(Font.font("Arial", 16));
        phone.setWrapText(true);
        //
        contactBox.getChildren().addAll(contactTitle, company, email, phone);

        // Box 2 
        VBox mapBox = new VBox();
        mapBox.setPadding(new Insets(20));
        mapBox.setStyle("-fx-background-color: rgba(255,255,255,0.9); -fx-background-radius: 10;");
        mapBox.setAlignment(Pos.CENTER);
        mapBox.setPrefWidth(500);  // Khớp với contactBox
        mapBox.setMaxHeight(600);

        Image mapImage = new Image("file:src/main/java/images/maps.png");
        ImageView mapView = new ImageView(mapImage);
        mapView.setFitWidth(450);
        mapView.setFitHeight(350);
        mapView.setPreserveRatio(true);

        mapBox.getChildren().add(mapView);

        // 
        HBox mainBox = new HBox(40, contactBox, mapBox);
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setPadding(new Insets(40));
        mainBox.setMaxWidth(1100); // Tổng chiều ngang không vượt quá 1200
        mainBox.setMaxHeight(600);

        // StackPane để có background
        StackPane root = new StackPane(background, mainBox);

        // Nút quay về trang chủ
        Button btnBack = new Button("Quay về trang chủ");
        btnBack.setStyle("-fx-background-color: #990000; -fx-text-fill: white;");
        btnBack.setOnMouseClicked(e -> {
            LandingPage landingPage = new LandingPage();
            landingPage.start(primaryStage);
        });
        StackPane.setAlignment(btnBack, Pos.BOTTOM_CENTER);
        StackPane.setMargin(btnBack, new Insets(20));
        root.getChildren().add(btnBack);

        // Tạo scene với đúng kích thước nền
        Scene scene = new Scene(root, 1200, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Về Chúng Tôi");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}