package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/* Configuração do build:
 * o Botão direito no projeto -> Run As -> Run Configurations -> Arguments -> VM Arguments
 * o Copiar o conteúdo abaixo, adaptando para sua pasta:
 * 
 * -- para enchergar os modulos do javafx
 * --module-path C:\java-libs\javafx-sdk\lib --add-modules=javafx.fxml,javafx.controls
 */

public class Main extends Application {

	@Override
	public void start(Stage stage) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/gui/View.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}