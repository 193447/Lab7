package it.polito.tdp.dizionario.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.dizionario.db.DizionarioDAO;
import it.polito.tdp.dizionario.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DizionarioController {
	
	DizionarioDAO dD;
	Model m;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtL;

    @FXML
    private TextField txtP;

    @FXML
    private Button btnG;

    @FXML
    private Button btnT;

    @FXML
    private Button btnC;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doGenera(ActionEvent event) {
    	int i=Integer.parseInt(txtL.getText());
    	dD.readWordWithLengthX(i);
    	dD.getM().creagrafo();
    	txtResult.setText("Grafo Generato \n");
    }

    @FXML
    void doTrovaConnessi(ActionEvent event) {
    	
    	String parola=txtP.getText();

    	String m1="";
    	int i=0;
    	for(String s:dD.getM().TrovaConnessi(parola)){
    		m1+=s+"\n";
    		i++;
    	}
    	txtResult.appendText(m1);
    	txtResult.appendText("Numero parole :"+i+"\n");

    }

    @FXML
    void doTrovaVicini(ActionEvent event) {
    	
    	String parola=txtP.getText();
    	
    	String m1="";
    	int i=0;
    	for(String s:dD.getM().TrovaVicini(parola)){
    		m1+=s+"\n";
    		i++;
    	}
    	txtResult.appendText(m1);
    	txtResult.appendText("Numero parole :"+i+"\n");

    }

    @FXML
    void initialize() {
        assert txtL != null : "fx:id=\"txtL\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert txtP != null : "fx:id=\"txtP\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert btnG != null : "fx:id=\"btnG\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert btnT != null : "fx:id=\"btnT\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert btnC != null : "fx:id=\"btnC\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Dizionario.fxml'.";

        dD=new DizionarioDAO();
        m=new Model();
    }
}


