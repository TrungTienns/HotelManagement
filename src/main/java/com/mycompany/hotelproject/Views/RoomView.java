package com.mycompany.hotelproject.Views;

import com.mycompany.hotelproject.models.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RoomView {
    private ObservableList<Room> roomList;
    private ListView<Room> listView;
    private VBox mainContent;

    public RoomView() {
        roomList = FXCollections.observableArrayList(
            new Room("100", "Vip", "Đang trống", 50000, 300000, "Phòng VIP tầng 1"),
            new Room("101", "Vip", "Đã có người ở", 50000, 300000, ""),
            new Room("102", "Hoàng Đế", "Đang trống", 100000, 500000, "Phòng Hoàng Đế"),
            new Room("103", "Thường", "Đã có người ở", 30000, 200000, ""),
            new Room("104", "Hoàng Đế", "Đã có người ở", 100000, 500000, "")
        );
    }

    public VBox createRoomView() {
        mainContent = new VBox(15);
        mainContent.setPadding(new Insets(20));

        Label title = new Label("Quản Lý Phòng");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        listView = new ListView<>(roomList);
        listView.setPrefHeight(300);

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER_LEFT);

        Button btnAdd = new Button("Thêm phòng");
        Button btnEdit = new Button("Sửa");
        Button btnDelete = new Button("Xóa");

        btnAdd.setOnAction(e -> showAddDialog());
        btnEdit.setOnAction(e -> {
            Room selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) showEditDialog(selected);
        });
        btnDelete.setOnAction(e -> {
            Room selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Xóa phòng này?", ButtonType.YES, ButtonType.NO);
                confirm.setHeaderText(null);
                confirm.showAndWait().ifPresent(res -> {
                    if (res == ButtonType.YES) roomList.remove(selected);
                });
            }
        });

        buttonBox.getChildren().addAll(btnAdd, btnEdit, btnDelete);

        mainContent.getChildren().addAll(title, listView, buttonBox);
        return mainContent;
    }

    private void showAddDialog() {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Thêm phòng");

        VBox box = new VBox(10);
        box.setPadding(new Insets(15));

        TextField tfNumber = new TextField();
        tfNumber.setPromptText("Số phòng");

        TextField tfType = new TextField();
        tfType.setPromptText("Loại phòng");

        TextField tfStatus = new TextField();
        tfStatus.setPromptText("Trạng thái");

        Button btnSave = new Button("Lưu");
        btnSave.setOnAction(e -> {
            if (tfNumber.getText().trim().isEmpty() || tfType.getText().trim().isEmpty() || tfStatus.getText().trim().isEmpty()) {
                showAlert("Vui lòng nhập đủ thông tin!");
                return;
            }
            roomList.add(new Room(tfNumber.getText(), tfType.getText(), tfStatus.getText(), 0, 0, ""));
            dialog.close();
        });

        Button btnCancel = new Button("Hủy");
        btnCancel.setOnAction(e -> dialog.close());

        HBox hBox = new HBox(10, btnSave, btnCancel);
        hBox.setAlignment(Pos.CENTER);

        box.getChildren().addAll(new Label("Số phòng:"), tfNumber, new Label("Loại phòng:"), tfType, new Label("Trạng thái:"), tfStatus, hBox);

        dialog.setScene(new Scene(box, 300, 250));
        dialog.showAndWait();
    }

    private void showEditDialog(Room room) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Sửa phòng");

        VBox box = new VBox(10);
        box.setPadding(new Insets(15));

        TextField tfNumber = new TextField(room.getRoomNumber());
        TextField tfType = new TextField(room.getRoomType());
        TextField tfStatus = new TextField(room.getStatus());

        Button btnSave = new Button("Lưu");
        btnSave.setOnAction(e -> {
            if (tfNumber.getText().trim().isEmpty() || tfType.getText().trim().isEmpty() || tfStatus.getText().trim().isEmpty()) {
                showAlert("Vui lòng nhập đủ thông tin!");
                return;
            }
            room.setRoomNumber(tfNumber.getText());
            room.setRoomType(tfType.getText());
            room.setStatus(tfStatus.getText());
            listView.refresh();
            dialog.close();
        });

        Button btnCancel = new Button("Hủy");
        btnCancel.setOnAction(e -> dialog.close());

        HBox hBox = new HBox(10, btnSave, btnCancel);
        hBox.setAlignment(Pos.CENTER);

        box.getChildren().addAll(new Label("Số phòng:"), tfNumber, new Label("Loại phòng:"), tfType, new Label("Trạng thái:"), tfStatus, hBox);

        dialog.setScene(new Scene(box, 300, 250));
        dialog.showAndWait();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

}