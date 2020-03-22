package accountEntities;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Virus {

    private String type;
    private String name;
    private String symptoms;
    private String info;

    public Virus(String type, String name, String symptoms, String info) {
        this.type = type;
        this.name = name;
        this.symptoms = symptoms;
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public ObservableList<String> getSymptomsList(){

        String[] list = this.symptoms.trim().split(",");
        return FXCollections.observableArrayList(list);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
