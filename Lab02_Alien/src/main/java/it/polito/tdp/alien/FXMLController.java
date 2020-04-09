package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary dizionario=new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInsert;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	txtInsert.clear();

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String riga=txtInsert.getText().toLowerCase();
    	
    	if(riga.length()==0) {
    		txtResult.setText("Inserire due parole per aggiungerle al dizionario\no una parola per avere una traduzione\n");
    		return;
    	}
    	
    	StringTokenizer st= new StringTokenizer(riga, " ");
    	
    	String alienWord=st.nextToken();
    	
    	//inserire parola e traduzione
    	if(st.hasMoreTokens()) {
    		String translation=st.nextToken();
    		
    		if(!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici\n");
    			return;
    		}
    		
    		dizionario.add(alienWord, translation);
    		txtResult.setText("La parola "+alienWord+" con traduzione "+translation+" è stata inserita nel dizionario con successo!\n");
    	}
    	else {
    		//inserire la parola da tradurre
    		if(!alienWord.matches("[a-zA-Z]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici\n");
    			return;
    		}
    		String translation=dizionario.translateWord(alienWord);
    		if(translation!=null) {
    			txtResult.setText(translation);
    		}
    		else {
    			txtResult.setText("La parola non è presente nel dizionario\n");
    		}
    		
    	}
    	
    	

    }

    @FXML
    void initialize() {
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
