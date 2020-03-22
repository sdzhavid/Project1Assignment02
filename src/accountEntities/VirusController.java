package accountEntities;

import java.util.ArrayList;

public class VirusController {

    private ArrayList<Virus> virusList;

    public VirusController(){

        Virus virus1 = new Virus("a", "name1", "Symptom1,Symptom2", "asdsahdiosajdosaidjaa");
        Virus virus11 = new Virus("a", "name1", "Symptom1,Symptom2", "Sdkhsahdosaihdosaid");
        Virus virus2 = new Virus("b", "name2","alabala,tupci","SJDNKSJDHKJSDHKJSDHJ");
        Virus virus23 = new Virus("b", "name2","alabala,tupci","SDNSJDNSJKDNSJDNSJLKD");
        Virus virus3 = new Virus("c", "name3", "sdadas,sadsada","1241241251251");
        Virus virus33 = new Virus("c", "name3", "sdadas,sadsada","13i4u124h1n2leka");
        Virus virus4 = new Virus("d", "name4", "sdsdamsdgja,asdasdjg","I eat dick");
        Virus virus44 = new Virus("d", "name4", "sdsdamsdgja,asdasdjg","I suck");


        virusList = new ArrayList<>();

        virusList.add(virus11);
        virusList.add(virus23);
        virusList.add(virus33);
        virusList.add(virus44);
        virusList.add(virus1);
        virusList.add(virus2);
        virusList.add(virus3);
        virusList.add(virus4);


    }

    public ArrayList<Virus> getTypeA() {
        ArrayList<Virus> typeA = new ArrayList<>();
        for (Virus virus : virusList) {
            if (virus.getType().equals("a")) {
                typeA.add(virus);
            }
        }
        return typeA;
    }

    public ArrayList<Virus> getTypeB() {
        ArrayList<Virus> typeB = new ArrayList<>();
        for (Virus virus : virusList) {
            if (virus.getType().equals("b")) {
                typeB.add(virus);
            }
        }
        return typeB;
    }

    public ArrayList<Virus> getTypeC() {
        ArrayList<Virus> typeC = new ArrayList<>();
        for (Virus virus : virusList) {
            if (virus.getType().equals("c")) {
                typeC.add(virus);
            }
        }
        return typeC;
    }

    public ArrayList<Virus> getTypeD() {
        ArrayList<Virus> typeD = new ArrayList<>();
        for (Virus virus : virusList) {
            if (virus.getType().equals("d")) {
                typeD.add(virus);
            }
        }
        return typeD;
    }
}
