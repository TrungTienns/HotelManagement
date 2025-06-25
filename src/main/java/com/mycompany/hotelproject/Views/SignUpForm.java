package com.mycompany.hotelproject.Views;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignUpForm extends Application {
    private TextField tfHoTen;
    private TextField tfEmail;
    private PasswordField pfPass;
    private PasswordField pfPassCF;
    private Label lblErrorMessage;
    private Button btnSubmit;

    @Override
    public void start(Stage stage) {
        Label title = new Label("ĐĂNG KÝ");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold");

        // GridPane canh chỉnh
        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(15);
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setPadding(new Insets(20));

        //hoten
        Label lblHoTen = new Label("Họ và tên:");
        tfHoTen = new TextField();
        tfHoTen.setPrefWidth(300);
        formGrid.add(lblHoTen, 0, 0);
        formGrid.add(tfHoTen, 1, 0);

        //email
        Label lblEmail = new Label("Email:");
        tfEmail = new TextField();
        tfEmail.setPrefWidth(300);
        formGrid.add(lblEmail, 0, 1);
        formGrid.add(tfEmail, 1, 1);

        //pass
        Label lblPass = new Label("Mật khẩu:");
        pfPass = new PasswordField();
        pfPass.setPrefWidth(300);
        formGrid.add(lblPass, 0, 2);
        formGrid.add(pfPass, 1, 2);

        //confirm
        Label lblPassCF = new Label("Nhập lại mật khẩu:");
        pfPassCF = new PasswordField();
        pfPassCF.setPrefWidth(300);
        formGrid.add(lblPassCF, 0, 3);
        formGrid.add(pfPassCF, 1, 3);

        lblErrorMessage = new Label();
        lblErrorMessage.setStyle("-fx-text-fill: red");
        formGrid.add(lblErrorMessage, 1, 4);

        //btn submit
        btnSubmit = new Button("Đăng ký");
        btnSubmit.setOnMouseClicked(event -> Submit());

        formGrid.add(btnSubmit, 1, 5);
        GridPane.setHalignment(btnSubmit, HPos.RIGHT);

        VBox root = new VBox(20, title, formGrid);
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(30));

        Scene scene = new Scene(root, 700, 450);
        stage.setTitle("Form Đăng Ký");
        stage.setScene(scene);
        stage.show();

        checkFieldsFilled();
    }

    private void Submit() {
        String hoTenText = tfHoTen.getText();
        String emailText = tfEmail.getText();
        String passText = pfPass.getText();
        String passCFText = pfPassCF.getText();

        boolean isValidEmail = emailText.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        boolean isValidHoTen = hoTenText.matches("^[\\p{L} ]+$");

        if (!isValidHoTen) {
            lblErrorMessage.setText("Họ tên không hợp lệ!");
            return;
        }

        if (!isValidEmail) {
            lblErrorMessage.setText("Email không hợp lệ!");
            return;
        }

        if (passText.length() < 8) {
            lblErrorMessage.setText("Mật khẩu phải có ít nhất 8 ký tự!");
            return;
        }

        if (!passText.equals(passCFText)) {
            lblErrorMessage.setText("Mật khẩu nhập lại không khớp!");
            return;
        }

        // Thành công
        lblErrorMessage.setText("Đăng ký thành công!");
        lblErrorMessage.setStyle("-fx-text-fill: blue");

        PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(0.5));
        pause.setOnFinished(e -> {
            new LoginForm().start((Stage) btnSubmit.getScene().getWindow());
        });
        pause.play();
    }

    private void checkFieldsFilled() {
        ChangeListener<String> listener = (obs, oldVal, newVal) -> checkFieldsEmpty();

        tfHoTen.textProperty().addListener(listener);
        tfEmail.textProperty().addListener(listener);
        pfPass.textProperty().addListener(listener);
        pfPassCF.textProperty().addListener(listener);

        checkFieldsEmpty();
    }

    private void checkFieldsEmpty() {
        boolean allFieldsFilled = !tfHoTen.getText().isEmpty()
                && !tfEmail.getText().isEmpty()
                && !pfPass.getText().isEmpty()
                && !pfPassCF.getText().isEmpty();

        btnSubmit.setDisable(!allFieldsFilled);
    }

    public static void main(String[] args) {
        launch();
    }
}
