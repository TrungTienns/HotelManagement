/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelproject.Views;
import com.mycompany.hotelproject.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UserView {
    private ObservableList<User> userList;
    private ListView<User> listView;
    private VBox mainContent;

    public UserView() {
        userList = FXCollections.observableArrayList(
            new User("Nguyễn Văn A", "Nam", "123456789012", "Hà Nội"),
            new User("Trần Thị B", "Nữ", "987654321098", "TP.HCM"),
            new User("Lê Văn C", "Nam", "456789123456", "Đà Nẵng")
        );
    }

    public VBox createUserView() {
        mainContent = new VBox(15);
        mainContent.setPadding(new Insets(20));

        Label title = new Label("Quản Lý Khách Hàng");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        listView = new ListView<>(userList);
        listView.setPrefHeight(300);

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER_LEFT);

        Button btnAdd = new Button("Thêm khách");
        Button btnEdit = new Button("Sửa");
        Button btnDelete = new Button("Xóa");

        btnAdd.setOnAction(e -> showAddDialog());
        btnEdit.setOnAction(e -> {
            User selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) showEditDialog(selected);
        });
        btnDelete.setOnAction(e -> {
            User selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Xóa khách hàng này?", ButtonType.YES, ButtonType.NO);
                confirm.setHeaderText(null);
                confirm.showAndWait().ifPresent(res -> {
                    if (res == ButtonType.YES) userList.remove(selected);
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
        dialog.setTitle("Thêm khách hàng");

        VBox box = new VBox(10);
        box.setPadding(new Insets(15));

        TextField tfName = new TextField();
        tfName.setPromptText("Tên khách");

        ComboBox<String> cbGender = new ComboBox<>();
        cbGender.getItems().addAll("Nam", "Nữ");
        cbGender.setPromptText("Giới tính");

        TextField tfCCCD = new TextField();
        tfCCCD.setPromptText("Số CCCD");

        TextField tfAddress = new TextField();
        tfAddress.setPromptText("Địa chỉ");

        Button btnSave = new Button("Lưu");
        btnSave.setOnAction(e -> {
            if (tfName.getText().trim().isEmpty() || cbGender.getValue() == null ||
                tfCCCD.getText().trim().isEmpty() || tfAddress.getText().trim().isEmpty()) {
                showAlert("Vui lòng nhập đủ thông tin!");
                return;
            }
            userList.add(new User(tfName.getText(), cbGender.getValue(), tfCCCD.getText(), tfAddress.getText()));
            dialog.close();
        });

        Button btnCancel = new Button("Hủy");
        btnCancel.setOnAction(e -> dialog.close());

        HBox hBox = new HBox(10, btnSave, btnCancel);
        hBox.setAlignment(Pos.CENTER);

        box.getChildren().addAll(new Label("Tên khách:"), tfName,
                                 new Label("Giới tính:"), cbGender,
                                 new Label("Số CCCD:"), tfCCCD,
                                 new Label("Địa chỉ:"), tfAddress,
                                 hBox);

        dialog.setScene(new Scene(box, 300, 300));
        dialog.showAndWait();
    }

    private void showEditDialog(User user) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Sửa khách hàng");

        VBox box = new VBox(10);
        box.setPadding(new Insets(15));

        TextField tfName = new TextField(user.getName());
        ComboBox<String> cbGender = new ComboBox<>();
        cbGender.getItems().addAll("Nam", "Nữ");
        cbGender.setValue(user.getGender());
        TextField tfCCCD = new TextField(user.getCccd());
        TextField tfAddress = new TextField(user.getAddress());

        Button btnSave = new Button("Lưu");
        btnSave.setOnAction(e -> {
            if (tfName.getText().trim().isEmpty() || cbGender.getValue() == null ||
                tfCCCD.getText().trim().isEmpty() || tfAddress.getText().trim().isEmpty()) {
                showAlert("Vui lòng nhập đủ thông tin!");
                return;
            }
            user.setName(tfName.getText());
            user.setGender(cbGender.getValue());
            user.setCccd(tfCCCD.getText());
            user.setAddress(tfAddress.getText());
            listView.refresh();
            dialog.close();
        });

        Button btnCancel = new Button("Hủy");
        btnCancel.setOnAction(e -> dialog.close());

        HBox hBox = new HBox(10, btnSave, btnCancel);
        hBox.setAlignment(Pos.CENTER);

        box.getChildren().addAll(new Label("Tên khách:"), tfName,
                                 new Label("Giới tính:"), cbGender,
                                 new Label("Số CCCD:"), tfCCCD,
                                 new Label("Địa chỉ:"), tfAddress,
                                 hBox);

        dialog.setScene(new Scene(box, 300, 300));
        dialog.showAndWait();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}