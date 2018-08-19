/**
 * Sample Skeleton for 'mega-sograo.fxml' Controller Class
 */

package com.ivan.mega;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MegaSograoController {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtConsole"
	private TextArea txtConsole; // Value injected by FXMLLoader

	@FXML // fx:id="btnCalcularEstatistica"
	private Button btnCalcularEstatistica; // Value injected by FXMLLoader

	@FXML // fx:id="txtJogos"
	private TextArea txtJogos; // Value injected by FXMLLoader

	@FXML
	void calcularEstatistica(ActionEvent event) throws IOException {

		HashMap<String, Integer> countNumeros = new HashMap<>();

		BufferedReader bufReader = new BufferedReader(new StringReader(txtJogos.getText()));
		String line = null;
		while ((line = bufReader.readLine()) != null) {
			for (String numero : line.split(" ")) {
				if (!StringUtils.isNumeric(numero) || numero.length() > 2 || numero.length() < 1) {
					continue;
				}
				Integer count = countNumeros.get(numero);
				if (count == null) {
					count = 0;
				}
				count++;
				countNumeros.put(numero, count);
			}
		}

		String saida = "";

		for (Map.Entry<String, Integer> entry : sortByValues2(countNumeros)) {
			saida += entry.getKey() + " => " + entry.getValue() + System.lineSeparator();
		}

		txtConsole.setText(saida);

	}

	private static List<Entry<String, Integer>> sortByValues2(HashMap<String, Integer> map) {
		return map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.collect(Collectors.toList());
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtConsole != null : "fx:id=\"txtConsole\" was not injected: check your FXML file 'mega-sograo.fxml'.";
		assert btnCalcularEstatistica != null : "fx:id=\"btnCalcularEstatistica\" was not injected: check your FXML file 'mega-sograo.fxml'.";
		assert txtJogos != null : "fx:id=\"txtJogos\" was not injected: check your FXML file 'mega-sograo.fxml'.";

	}
}
