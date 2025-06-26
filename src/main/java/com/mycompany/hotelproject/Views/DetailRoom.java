package com.mycompany.hotelproject.Views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DetailRoom extends Application {
    @Override
    public void start(Stage stage) {
        //Title
        Label title = new Label("Room Details");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: BROWN;");

        //Dec
        Label lblHotel = new Label("Hotel");
        lblHotel.setStyle("-fx-font-size: 12px; -fx-text-fill: GREY; -fx-font-weight: bold;");
        Label lblHotelName = new Label("Luxury Hotel SaiGon Centre");
        lblHotelName.setStyle("-fx-font-size: 16px; -fx-text-fill: Black");

        VBox titleTop = new VBox();
        titleTop.getChildren().addAll(title, lblHotel, lblHotelName);
        titleTop.setPadding(new Insets(10, 10, 0, 20));

        //Img Top
        ImageView imageView = new ImageView(new Image("file:src/main/java/images/ImgRoomDetail.png"));
        imageView.setFitWidth(780);
        imageView.setFitHeight(500);

        //title
        Label header = new Label("ROOMS & SUITES");
        header.setStyle("-fx-font-size: 30px; font-weight: bold;");
        header.setPadding(new Insets(20, 0, 20, 20));

        //Grid các phòng
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(30);
        grid.setPadding(new Insets(20));

        //room1
        VBox room1 = new VBox();
        //img
        ImageView imageRoom1 = new ImageView(new Image("file:src/main/java/images/room1.png"));
        imageRoom1.setFitWidth(360);
        imageRoom1.setFitHeight(250);
        imageRoom1.setPreserveRatio(false);

        Label roomName = new Label("Room Lite");
        roomName.setStyle("-fx-font-size: 20px;  -fx-font-weight: bold;");

        HBox descRoom = new HBox(10,
                new Label("🛏 " + "QUEEN"),
                new Label("📐 " + "20 m2"),
                new Label("👁 " + "CITY VIEW"),
                new Label("👥 " + "2 ADULTS")
        );

        Label description = new Label("Compact but never cramped, these queen-sized havens are where smart meets snug. Perfect for solo adventurers or cozy couples who know good things come in chic packages.");
        description.setWrapText(true);
        description.setStyle("-fx-font-size: 14px");

        //btnBook
        Button btnBook = new Button("BOOK");
        btnBook.setStyle("-fx-background-color: #b22222; -fx-text-fill: white;");
        btnBook.setPrefWidth(80);
        HBox bookBox = new HBox(btnBook);
        bookBox.setAlignment(Pos.BOTTOM_RIGHT);
        bookBox.setPadding(new Insets(10, 0, 0, 0));

        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(roomName, descRoom, description, bookBox);
        vBox1.setPadding(new Insets(10));
        vBox1.setSpacing(10);

        room1.getChildren().addAll(imageRoom1, vBox1);
        room1.setStyle("-fx-background-color: #CCCCCC");

        //room2
        VBox room2 = new VBox();

        //img
        ImageView imageRoom2 = new ImageView(new Image("file:src/main/java/images/room2.png"));
        imageRoom2.setFitWidth(360);
        imageRoom2.setFitHeight(250);
        imageRoom2.setPreserveRatio(false);

        Label roomName2 = new Label("Room Luxe");
        roomName2.setStyle("-fx-font-size: 20px;  -fx-font-weight: bold");

        HBox descRoom2 = new HBox(10,
                new Label("🛏 " + "QUEEN/TWIN"),
                new Label("📐 " + "30 m2"),
                new Label("👁 " + "CITY VIEW"),
                new Label("👥 " + "2 ADULTS")
        );

        Label description2 = new Label("Our Luxe rooms are the cool kids on the block, sporting a queen bed for the grown-ups, bunk beds for the munchkins (or young-at-heart), and a sneaky sofa that morphs into a bed.");
        description2.setWrapText(true);
        description2.setStyle("-fx-font-size: 14px");

        //btnBook
        Button btnBook2 = new Button("BOOK");
        btnBook2.setStyle("-fx-background-color: #b22222; -fx-text-fill: white;");
        btnBook2.setPrefWidth(80);
        HBox bookBox2 = new HBox(btnBook2);
        bookBox2.setAlignment(Pos.BOTTOM_RIGHT);
        bookBox2.setPadding(new Insets(10, 0, 0, 0));

        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(roomName2, descRoom2, description2, bookBox2);
        vBox2.setPadding(new Insets(10));
        vBox2.setSpacing(10);

        room2.getChildren().addAll(imageRoom2, vBox2);
        room2.setStyle("-fx-background-color: #CCCCCC");

        grid.add(room1, 0, 0);
        grid.add(room2, 1, 0);

        ScrollPane scroll = new ScrollPane(grid);
        scroll.setFitToWidth(true);

        VBox content = new VBox(titleTop, imageView, header, grid);
        content.setSpacing(10);

        ScrollPane scrollPane = new ScrollPane(content);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        Scene scene = new Scene(scrollPane, 800, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}