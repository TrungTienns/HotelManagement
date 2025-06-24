package com.mycompany.hotelproject.Views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ServicePage extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Tải ảnh nền
        Image bgImage = new Image("file:src/main/java/images/hotelservice.jpg");
        ImageView background = new ImageView(bgImage);
        background.setFitWidth(1200);
        background.setFitHeight(700);
        background.setPreserveRatio(false); 

        // Tiêu đề chính
        Label title = new Label("Hãy Tự Thưởng Cho Bản Thân Mình Một Sự Thư Giãn Cần Có");
        title.setTextFill(Color.WHITE); 
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 28));
        title.setEffect(new DropShadow(3, Color.BLACK));

        // Label và DatePicker cho Check-in
        Label checkInLabel = new Label("Check-in:");
        checkInLabel.setTextFill(Color.WHITE);
        DatePicker checkInDatePicker = new DatePicker();

        VBox checkInBox = new VBox(5, checkInLabel, checkInDatePicker);
        checkInBox.setAlignment(Pos.CENTER_LEFT);

        // Label và DatePicker cho Check-out
        Label checkOutLabel = new Label("Check-out:");
        checkOutLabel.setTextFill(Color.WHITE);
        DatePicker checkOutDatePicker = new DatePicker();

        VBox checkOutBox = new VBox(5, checkOutLabel, checkOutDatePicker);
        checkOutBox.setAlignment(Pos.CENTER_LEFT);

        // Label và ComboBox chọn số lượng người
        Label guestLabel = new Label("Khách:");
        guestLabel.setTextFill(Color.WHITE);

        // ComboBox cho người lớn
        Label adultsLabel = new Label("Người lớn:");
        adultsLabel.setTextFill(Color.WHITE);
        ComboBox<Integer> adultsCombo = new ComboBox<>();
        adultsCombo.getItems().addAll(1, 2, 3, 4, 5);
        adultsCombo.setValue(2); 

        // ComboBox cho trẻ em
        Label childrenLabel = new Label("Trẻ em:");
        childrenLabel.setTextFill(Color.WHITE);
        ComboBox<Integer> childrenCombo = new ComboBox<>();
        childrenCombo.getItems().addAll(0, 1, 2, 3, 4);
        childrenCombo.setValue(0); 

        // Gom ComboBox người lớn và trẻ em vào chung 1 hàng
        VBox adultsBox = new VBox(3, adultsLabel, adultsCombo);
        VBox childrenBox = new VBox(3, childrenLabel, childrenCombo);
        HBox guestInputs = new HBox(10, adultsBox, childrenBox);
        guestInputs.setAlignment(Pos.CENTER_LEFT);

        // Tổng thể phần khách
        VBox guestBox = new VBox(5, guestLabel, guestInputs);
        guestBox.setAlignment(Pos.CENTER_LEFT);

        // Gom toàn bộ DatePicker và Guest vào cùng 1 hàng ngang
        HBox dateGuestBox = new HBox(40, checkInBox, checkOutBox, guestBox);
        dateGuestBox.setAlignment(Pos.CENTER);
        dateGuestBox.setPadding(new Insets(10));

        // Nút tìm phòng
        Button findRoom = new Button("FIND ROOM");
        findRoom.setStyle("-fx-background-color: #cc0000; -fx-text-fill: white; -fx-font-weight: bold;");
        findRoom.setPrefWidth(200);
        findRoom.setPrefHeight(40);

        // Tổng thể giao diện xếp dọc
        VBox content = new VBox(30, title, dateGuestBox, findRoom);
        content.setAlignment(Pos.CENTER);
        content.setPadding(new Insets(20));

        // StackPane để đặt ảnh nền phía sau
        StackPane root = new StackPane();
        root.getChildren().addAll(background, content);

        // Tạo scene và hiển thị
        Scene scene = new Scene(root, 1200, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hotel Self-Service App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
