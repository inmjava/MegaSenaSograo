package com.ivan.mega;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class MegaSograoMain extends Application {

	@FXML
	private TextField txtPesquisa;

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("mega-sograo.fxml"));

		Scene scene = new Scene(root, 900, 700);

		stage.setTitle("MegaSena Vai Sogrão!");
		stage.setScene(scene);
		stage.show();
	}
}
