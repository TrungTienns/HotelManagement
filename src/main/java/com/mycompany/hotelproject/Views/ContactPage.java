package com.mycompany.hotelproject.Views;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContactPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Thanh menu trên cùng giống AboutUsPage
        HBox menuBar = new HBox(30);
        menuBar.setPadding(new Insets(20));
        menuBar.setStyle("-fx-background-color: #F5F5DC;");
        
        Label logo = new Label("Luxury Hotel");
        logo.setFont(Font.font(20));
        logo.setStyle("-fx-font-weight: bold;");
        menuBar.getChildren().add(logo);

        // GridPane chính
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(40));
        grid.setVgap(30);
        grid.setHgap(30);
        grid.setAlignment(Pos.CENTER);

        // Tiêu đề trang
        Label title = new Label("Liên hệ với chúng tôi");
        title.setFont(Font.font("Arial", 36));
        title.setStyle("-fx-font-weight: bold;");
        title.setTextFill(Color.DARKRED);
        GridPane.setHalignment(title, HPos.CENTER);
        grid.add(title, 0, 0, 3, 1);

        // Tạo 3 khối dịch vụ liên hệ
        VBox callBox = createContactBox("📞", "Liên hệ ngay", "84+ 123456789");
        VBox chatBox = createContactBox("💬", "Nhắn tin ngay" ,"Trả lời 24/7");
        VBox askBox = createContactBox("✉️", "Bạn có câu hỏi", "Trả lời trong 24h");

        grid.add(callBox, 0, 1);
        grid.add(chatBox, 1, 1);
        grid.add(askBox, 2, 1);

        // Nút quay về trang chủ
        Button backButton = new Button("Quay lại trang chủ");
        backButton.setFont(Font.font("Arial", 16));
        backButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white;");
        backButton.setOnAction(e -> {
            LandingPage landingPage = new LandingPage();
            landingPage.start(primaryStage);
        });
        GridPane.setHalignment(backButton, HPos.CENTER);
        grid.add(backButton, 1, 2); // đặt ở giữa

        // Tổng thể
        VBox root = new VBox(menuBar, grid);

        // Thêm background image giống AboutUsPage
        Image bgImage = new Image("file:src/main/java/images/background.jpg");
        BackgroundImage bg = new BackgroundImage(
            bgImage,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(100, 100, true, true, true, true)
        );
        root.setBackground(new Background(bg));

        Scene scene = new Scene(root, 1000, 650);
        primaryStage.setTitle("Liên hệ - Luxury Hotel");
        primaryStage.setScene(scene);
        root.setStyle("-fx-background-color: #D4AF37;");
        primaryStage.show();
    }

    private VBox createContactBox(String icon, String header, String subText) {
        Label iconLabel = new Label(icon);
        iconLabel.setFont(Font.font("Arial", 50));

        Label headerLabel = new Label(header);
        headerLabel.setFont(Font.font("Arial", 24));
        headerLabel.setStyle("-fx-font-weight: bold;");

        Label subLabel = new Label(subText);
        subLabel.setFont(Font.font("Arial", 16));

        Button actionButton = new Button("Liên hệ");
        actionButton.setFont(Font.font("Arial", 14));
        actionButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white;");

        VBox box = new VBox(15, iconLabel, headerLabel, subLabel, actionButton);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(30));
        box.setPrefSize(250 , 250);
        box.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #D4AF37; -fx-border-width: 3px; -fx-background-radius: 10; -fx-border-radius: 10;");
        return box;
    }

    public static void main(String[] args) {
        launch();
    }
}