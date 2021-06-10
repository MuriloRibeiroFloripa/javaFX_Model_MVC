package gui;

/* Checklist:
 * Propriedade Prompt Text
 * Usar tipo genérico, por exemplo: ComboBox<Pessoa>
 * ObservableList<Pessoa>, ObservableSet<Pessoa>, ObservableMap<Pessoa>
 * Para criar um ObservableList: FXCollections.observableList(list)
 * ComboBox.setItems(observableList)
 * 
 * Nota: o combo box, por padrão, mostra o toString do objeto
 * Para obter o elemento selecionado: comboBox.getSelectionModel().getSelectedItem()
 * Para acessar a coleção: comboBox.getItems()
 * Para definir o que mostrar na comboBox:
 * 
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entities.Pessoa;

/* Limitações para TextField e Initializable
 * Referências: https://docs.oracle.com/javase/8/javafx/api/javafx/fxml/Initializable.html
 * 
 * Checklist:
 * - Criar classe utilitária Constraints
 * - Fazer o controlador implementar a interface Initializable
 */

public class ViewController implements Initializable {
	
	@FXML
	private ComboBox<Pessoa> comboBoxPessoa;
	
	// Evento para percorrer os elemento da comboBox
	@FXML
	private Button btTodos;	
	
	// Lista que fica associado ao componente veisual
	private ObservableList<Pessoa> obsList;
	
	// Evento para percorrer os elemento da comboBox
	@FXML
	public void onBtTodosAction() {
		for(Pessoa pessoa : comboBoxPessoa.getItems()) {
			System.out.println(pessoa);
		}
	}
	
	//Tratar evento para pegar o iten selecionado mostrar no prompt do eclipse
	public void onComboBoxPessoaAction() {
		Pessoa pessoa = comboBoxPessoa.getSelectionModel().getSelectedItem();
		System.out.println(pessoa);
	}
		
	// Esse metodo vai ser inicializando quando o controlador for iniciado.
	// colocar nele ações para ser executadas na hora da instanciação do controlador
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		List<Pessoa> list = new ArrayList<>();
		list.add(new Pessoa(1, "Maria", "maria@gmail.com"));
		list.add(new Pessoa(2, "Marcos", "marcos@gmail.com"));
		list.add(new Pessoa(3, "Tina", "tina@gmail.com"));
		
		//Istanciar obsList com os elementos anexodos na lista
		obsList = FXCollections.observableArrayList(list);
		comboBoxPessoa.setItems(obsList);
		
		Callback<ListView<Pessoa>, ListCell<Pessoa>> factory = lv -> new ListCell<Pessoa>() {
			@Override
			protected void updateItem(Pessoa item, boolean empty) {
			super.updateItem(item, empty);
			setText(empty ? "" : item.getNome());
			}
		};
		comboBoxPessoa.setCellFactory(factory);
		comboBoxPessoa.setButtonCell(factory.call(null));
	}
}