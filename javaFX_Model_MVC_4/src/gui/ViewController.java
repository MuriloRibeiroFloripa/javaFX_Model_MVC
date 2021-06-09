package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/* Limita��es para TextField e Initializable
 * Refer�ncias: https://docs.oracle.com/javase/8/javafx/api/javafx/fxml/Initializable.html
 * 
 * Checklist:
 * - Criar classe utilit�ria Constraints
 * - Fazer o controlador implementar a interface Initializable
 */

public class ViewController implements Initializable {
	
	@FXML
	private TextField txtNumero1;
	
	@FXML
	private TextField txtNumero2;
	
	@FXML
	private Label labResultado;

	@FXML
	private Button btSoma;
	
	// Evento
	@FXML
	public void onBtSomatAction() {
		try {

			Locale.setDefault(Locale.US);
			double numero1 = Double.parseDouble(txtNumero1.getText());
			double numero2 = Double.parseDouble(txtNumero2.getText());
			double soma = numero1 + numero2;
			labResultado.setText(String.format("%.2f",soma));			
		}
		catch(NumberFormatException e) {
			Alerts.showAlert("Error","Parse error", e.getMessage(), AlertType.ERROR);
		}
	}
	
	// Esse metodo vai ser inicializando quando o controlador for iniciado.
	// colocar nele a��es para ser executadas na hora da instancia��o do controlador
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtNumero1);// para Aceitar apenas numeros inteiros ou numeros Double.
		Constraints.setTextFieldDouble(txtNumero2);
		Constraints.setTextFieldMaxLength(txtNumero1, 12);// para digitar maximo 12 digitos
		Constraints.setTextFieldMaxLength(txtNumero2, 12);
	}
}