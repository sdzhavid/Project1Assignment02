package loginScreen;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import accountEntities.Account;
import accountEntities.AccountController;
import userAdminScreens.UserMainScreenController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginScreenController {

    public JFXTextField username;
    public JFXPasswordField password;
    public Label errorMessage;
    private ArrayList<Account> userPass;
    private AccountController accountController = new AccountController();

    public void loginButton(MouseEvent mouseEvent) throws IOException {

        if (accountController.checkUsername(username.getText().trim())) {

            if (accountController.checkPassword(username.getText().trim(),password.getText().trim())) {

                if (accountController.checkIfAdmin(username.getText().trim())){

                Stage adminScreen = new Stage();
                Parent root = null;

                try {
                    root = FXMLLoader.load(getClass().getResource("../userAdminScreens/AdminScreen.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }

                Stage current = (Stage) username.getScene().getWindow();
                Scene scene = new Scene(root, 1336, 730);

                adminScreen.setScene(scene);
                adminScreen.initStyle(StageStyle.TRANSPARENT);

                current.hide();

                adminScreen.show();

            } else {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../userAdminScreens/UserScreen.fxml"));
                    Scene scene = new Scene(loader.load());

                    UserMainScreenController controller = loader.getController();
                    controller.setParent(LoginScreenController.this);

                    Stage userScreen = new Stage();
                    Stage current = (Stage) username.getScene().getWindow();
                    userScreen.setScene(scene);

                    userScreen.initStyle(StageStyle.TRANSPARENT);

                    current.hide();
                    userScreen.show();
                /*Stage userScreen = new Stage();


                //Parent root = null;

                try {
                    root = FXMLLoader.load(getClass().getResource("../userAdminScreens/UserScreen.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }

                Stage current = (Stage) username.getScene().getWindow();
                Scene scene = new Scene(root, 1336, 730);

                userScreen.setScene(scene);
                userScreen.initStyle(StageStyle.TRANSPARENT);

                current.hide();

                userScreen.show();*/
                }
            } else {
                username.setStyle("-fx-border-color: white");
                password.setStyle("-fx-border-color: red");
                errorMessage.setText("Incorrect password. Please try again");
            }
        } else {
            password.setStyle("-fx-border-color: white");
            username.setStyle("-fx-border-color: red");
            errorMessage.setText("Username not found. Try again!");
        }
    }
}
