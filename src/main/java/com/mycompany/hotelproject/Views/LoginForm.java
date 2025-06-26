package com.mycompany.hotelproject.Views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginForm extends Application {
    @Override
    public void start(Stage stage) {
        VBox layoutLeft = new VBox(20);
        layoutLeft.setPadding(new Insets(40));
        //title
        Label title = new Label("Log in to your account");
        title.setStyle("-fx-font-size: 30px;");
        VBox.setMargin(title, new Insets(0, 0, 30, 0));

        //Email
        TextField email = new TextField();
        email.setPromptText("Email");
        email.setStyle("-fx-font-size: 14px;");
        email.setMaxWidth(300);
        email.setMinHeight(40);

        //Password
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        password.setStyle("-fx-font-size: 14px;");
        password.setMaxWidth(300);
        password.setMinHeight(40);

        //forgot pass
        Label lblForgotPass = new Label("Forgot Password ?");
        lblForgotPass.setStyle("-fx-text-fill: RED; -fx-font-size: 14");
        HBox forgotPassBox = new HBox(lblForgotPass);
        forgotPassBox.setAlignment(Pos.CENTER_RIGHT);
        forgotPassBox.setMaxWidth(300);

        //btn Login
        Button btnLogin = new Button("Log in");
        btnLogin.setStyle("-fx-font-size: 20px; -fx-text-fill: WHITE; -fx-background-color: RED");
        btnLogin.setPrefWidth(300);

        //Sig up
        Text signUp = new Text("Sign Up");
        signUp.setStyle("-fx-fill: red; -fx-underline: true; -fx-font-size: 14px");
        Text already = new Text("You don't have an account yet? ");
        already.setStyle("-fx-font-size: 14px");
        HBox toSignUp = new HBox(already, signUp);
        toSignUp.setAlignment(Pos.CENTER);

        //Xử lí signup
        signUp.setOnMouseClicked(event -> {
            SignUpForm signUpForm = new SignUpForm();
            Stage signUpStage = (Stage) ((Text) event.getSource()).getScene().getWindow();
            signUpForm.start(signUpStage);
        });

        //Note
        Label lblNote = new Label("By logging in or signing up, you give your Consent to personal data processing and confirm that you have read the Online booking rules and the Privacy policy.");
        lblNote.setWrapText(true);

        layoutLeft.getChildren().addAll(title, email, password, forgotPassBox, btnLogin, toSignUp,  lblNote);

        //LayoutRight
        ImageView logoImg = new ImageView(new Image("file:src/main/java/images/logo.png"));
        logoImg.setFitWidth(300);
        logoImg.setPreserveRatio(true);

        Label titleR = new Label("Join our loyalty program");
        titleR.setStyle("-fx-font-weight: bold; -fx-text-fill: #611a1a; -fx-font-size: 30");

        Label benefit1 = new Label("• Earn points each time you make a booking.");
        benefit1.setStyle("-fx-font-size: 16");
        benefit1.setWrapText(true);
        Label benefit2 = new Label("• Use your points to pay for part of your stay.");
        benefit2.setStyle("-fx-font-size: 16");
        benefit2.setWrapText(true);
        Label benefit3 = new Label("• Your contact details will be filled in automatically.");
        benefit3.setStyle("-fx-font-size: 16");
        benefit3.setWrapText(true);

        VBox vbBenefit =  new VBox();
        vbBenefit.getChildren().addAll(benefit1, benefit2, benefit3);
        vbBenefit.setAlignment(Pos.CENTER_LEFT);
        vbBenefit.setSpacing(10);

        VBox layoutRight = new VBox(20,logoImg, titleR, vbBenefit);
        layoutRight.setPadding(new Insets(30));
        layoutRight.setAlignment(Pos.TOP_CENTER);
        layoutRight.setPrefWidth(400);
        layoutRight.setStyle("-fx-background-color: #CCCCCC;");

        HBox root = new HBox( layoutLeft, layoutRight );
        root.widthProperty().addListener((obs, oldVal, newVal) -> {
            double halfWidth = newVal.doubleValue() / 2;
            layoutLeft.setPrefWidth(halfWidth);
            layoutRight.setPrefWidth(halfWidth);
        });
        Scene scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
