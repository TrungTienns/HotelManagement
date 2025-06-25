/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelproject.Views;

/**
 *
 * @author hieun
 */

import com.mycompany.hotelproject.models.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ServiceView {
    private ObservableList<Service> serviceList;
    private VBox mainContent;
    private ListView<Service> listView;

    public ServiceView() {
        serviceList = FXCollections.observableArrayList(
            new Service("Mì ly", 15000, "Mì ăn liền"),
            new Service("Giặt ủi", 30000, "Giặt ủi quần áo"),
            new Service("Nước suối", 10000, ""),
            new Service("Thuê xe máy", 120000, "Theo ngày")
        );
    }

    public VBox createServiceView() {
        mainContent = new VBox(15);
        mainContent.setPadding(new Insets(20));
        mainContent.setStyle("-fx-background-color: #f5f5f5;");

        Label title = new Label("Quản Lý Dịch Vụ");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        listView = new ListView<>(serviceList);
        listView.setPrefHeight(300);

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER_LEFT);

        Button btnAdd = new Button("Thêm dịch vụ");
        Button btnEdit = new Button("Sửa");
        Button btnDelete = new Button("Xóa");

        btnAdd.setOnAction(e -> showAddDialog());
        btnEdit.setOnAction(e -> {
            Service selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) showEditDialog(selected);
        });
        btnDelete.setOnAction(e -> {
            Service selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Xóa dịch vụ này?", ButtonType.YES, ButtonType.NO);
                confirm.setHeaderText(null);
                confirm.showAndWait().ifPresent(res -> {
                    if (res == ButtonType.YES) serviceList.remove(selected);
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
        dialog.setTitle("Thêm dịch vụ");

        VBox box = new VBox(10);
        box.setPadding(new Insets(15));

        TextField tfName = new TextField();
        tfName.setPromptText("Tên dịch vụ");

        TextField tfPrice = new TextField();
        tfPrice.setPromptText("Giá");

        TextField tfNote = new TextField();
        tfNote.setPromptText("Ghi chú");

        Button btnSave = new Button("Lưu");
        btnSave.setOnAction(e -> {
            if (tfName.getText().trim().isEmpty() || tfPrice.getText().trim().isEmpty()) {
                showAlert("Vui lòng nhập đủ tên và giá!");
                return;
            }
            try {
                double price = Double.parseDouble(tfPrice.getText());
                serviceList.add(new Service(tfName.getText(), price, tfNote.getText()));
                dialog.close();
            } catch (NumberFormatException ex) {
                showAlert("Giá phải là số!");
            }
        });

        Button btnCancel = new Button("Hủy");
        btnCancel.setOnAction(e -> dialog.close());

        HBox hBox = new HBox(10, btnSave, btnCancel);
        hBox.setAlignment(Pos.CENTER);

        box.getChildren().addAll(new Label("Tên dịch vụ:"), tfName, new Label("Giá:"), tfPrice, new Label("Ghi chú:"), tfNote, hBox);

        dialog.setScene(new Scene(box, 300, 250));
        dialog.showAndWait();
    }

    private void showEditDialog(Service service) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Sửa dịch vụ");

        VBox box = new VBox(10);
        box.setPadding(new Insets(15));

        TextField tfName = new TextField(service.getServiceName());
        TextField tfPrice = new TextField(String.valueOf(service.getPrice()));
        TextField tfNote = new TextField(service.getNote());

        Button btnSave = new Button("Lưu");
        btnSave.setOnAction(e -> {
            if (tfName.getText().trim().isEmpty() || tfPrice.getText().trim().isEmpty()) {
                showAlert("Vui lòng nhập đủ tên và giá!");
                return;
            }
            try {
                double price = Double.parseDouble(tfPrice.getText());
                service.setServiceName(tfName.getText());
                service.setPrice(price);
                service.setNote(tfNote.getText());
                listView.refresh();
                dialog.close();
            } catch (NumberFormatException ex) {
                showAlert("Giá phải là số!");
            }
        });

        Button btnCancel = new Button("Hủy");
        btnCancel.setOnAction(e -> dialog.close());

        HBox hBox = new HBox(10, btnSave, btnCancel);
        hBox.setAlignment(Pos.CENTER);

        box.getChildren().addAll(new Label("Tên dịch vụ:"), tfName, new Label("Giá:"), tfPrice, new Label("Ghi chú:"), tfNote, hBox);

        dialog.setScene(new Scene(box, 300, 250));
        dialog.showAndWait();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}