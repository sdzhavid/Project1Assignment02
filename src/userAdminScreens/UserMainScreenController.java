package userAdminScreens;

import accountEntities.Virus;
import accountEntities.VirusController;
import detailedVirusView.DetailedVirusScreenController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import loginScreen.LoginScreenController;

import java.io.IOException;

public class UserMainScreenController {

    private VirusController virusController = new VirusController();

    public ComboBox<String> typeVirusCB;
    public ListView<Virus> virusesListView;
    public Button moreBT;

    private ObservableList<Virus> typeAVirus;
    private ObservableList<Virus> typeBVirus;
    private ObservableList<Virus> typeCVirus;
    private ObservableList<Virus> typeDVirus;


    public void initialize(){

        typeAVirus = FXCollections.observableArrayList(virusController.getTypeA());
        typeBVirus = FXCollections.observableArrayList(virusController.getTypeB());
        typeCVirus = FXCollections.observableArrayList(virusController.getTypeC());
        typeDVirus = FXCollections.observableArrayList(virusController.getTypeD());

        ObservableList<String> typeList = FXCollections.observableArrayList("a","b","c","d");
        typeVirusCB.setItems(typeList);
    }


    public void GetVirusesOnType(ActionEvent actionEvent) {
        switch (typeVirusCB.getSelectionModel().getSelectedItem()){
            case "a":
                virusesListView.setItems(typeAVirus);
                break;
            case "b":
                virusesListView.setItems(typeBVirus);
                break;
            case "c":
                virusesListView.setItems(typeCVirus);
                break;
            case "d":
                virusesListView.setItems(typeDVirus);
                break;
        }
    }
    public void setParent(LoginScreenController loginScreenController){
    }

    public void showMore(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../detailedVirusView/detailedVirusScreen.fxml"));
            Parent parent = loader.load();

            Scene detailedVirusScene = new Scene(parent);

            DetailedVirusScreenController controller = loader.getController();
            controller.initData(virusesListView.getSelectionModel().getSelectedItem());

            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            window.setScene(detailedVirusScene);
            window.show();
        } catch (NullPointerException ignored){}

    }
}
