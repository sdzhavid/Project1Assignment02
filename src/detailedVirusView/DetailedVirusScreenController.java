package detailedVirusView;

import accountEntities.Virus;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class DetailedVirusScreenController {

    public TextArea virusInfoTA;
    public ListView<String> symptomsListView;
    public Button backBT;
    public Label nameLB;

    public void initData(Virus virus){
        virusInfoTA.setText(virus.getInfo());
        symptomsListView.setItems(virus.getSymptomsList());
        nameLB.setText(virus.getName());
    }

    public void backToUserScreen(ActionEvent actionEvent) throws IOException {

        Parent userScreenParent = FXMLLoader.load(getClass().getResource("../userAdminScreens/UserScreen.fxml"));
        Scene userScreenScene = new Scene(userScreenParent);

        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(userScreenScene);
        window.show();

    }
}
