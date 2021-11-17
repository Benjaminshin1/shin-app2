/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Benjamin Shin
 */
package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;


public class FXMLController implements Initializable {

    @FXML
    private MenuItem load_saved;
    @FXML
    private Button delete_item_button;

    @FXML
    private TextField name_text_field;

    @FXML
    private TextField price_text_field;

    @FXML
    private TextField search_bar_text_field;

    @FXML
    private TextField ser;

    @FXML
    private TextField ser1;

    @FXML
    private TextField ser2;

    @FXML
    private TextField ser3;

    @FXML
    private MenuItem save_as;

    @FXML
    private TableColumn<itemgettersetter, String> name = new TableColumn<>("Name");

    @FXML
    private TableColumn<itemgettersetter, String> serial_number = new TableColumn<>("SerialNumber");

    @FXML
    private TableColumn<itemgettersetter, Double> value = new TableColumn<>("Value");


    @FXML
    private TableView<itemgettersetter> table_view = new TableView<>();

    ObservableList<itemgettersetter> list = FXCollections.observableArrayList();

    @FXML
    void addtolist() {
        //get the text from the user input and diplay it on the tableview
        //add to database
        String serialnumber = ser.getText() + "-" + ser1.getText() + "-" + ser2.getText() + "-" + ser3.getText();

        if (!name_text_field.getText().isEmpty() && !price_text_field.getText().isEmpty() &&serialnumber.matches("[A-Z]-[0-9a-z]{3}-[0-9a-z]{3}-[0-9a-z]{3}") ) {
            list.add(new itemgettersetter(serialnumber, name_text_field.getText(), Double.parseDouble(price_text_field.getText())));
        } else{
            //error message if input is empty
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Input fields empty");
            alert.setContentText("Please fill all input fields");

            alert.showAndWait();
        }

        //clear the textfields
        ser.clear();
        ser1.clear();
        ser2.clear();
        ser3.clear();
        name_text_field.clear();
        price_text_field.clear();


        table_view.setEditable(true);
        table_view.setItems(list);


    }

    @FXML
    void removefromlist() {
        //user can click on an item an it will remove the item from the list
        delete_item_button.setOnAction(e -> {
            itemgettersetter selectedItem = table_view.getSelectionModel().getSelectedItem();
            table_view.getItems().remove(selectedItem);
        });
        table_view.refresh();
    }

    @FXML
    void loadData() {

    }

    @FXML
    void savefile() {
        //will save file of the array list in a TSV/HTML/and JSON
    }

    @FXML
    public void randomCharacter() {

        //string of all characters
        //added random serial number generator
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphanumeric="123456789abcdefghijklmnopqrstuvwxyz";

        StringBuilder Alpha = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        Random random = new Random();

        // specify length of random string
        int length = 3;
        for(int i = 0; i < 1; i++) {
            int indexA = random.nextInt(alphabet.length());
            char randomCharA = alphabet.charAt(indexA);
            Alpha.append(randomCharA);
        }

        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphanumeric.length());
            char randomChar = alphanumeric.charAt(index);
            sb.append(randomChar);
        }
        for(int i = 0; i < length; i++) {
            int index1 = random.nextInt(alphanumeric.length());
            char randomChar1 = alphanumeric.charAt(index1);
            sb1.append(randomChar1);
        }
        for(int i = 0; i < length; i++) {
            int index2 = random.nextInt(alphanumeric.length());
            char randomChar2 = alphanumeric.charAt(index2);
            sb2.append(randomChar2);
        }
        String randomStringA = Alpha.toString();
        String randomString = sb.toString();
        String randomString1 = sb1.toString();
        String randomString2 = sb2.toString();
        ser.setText(randomStringA);
        ser1.setText(randomString);
        ser2.setText(randomString1);
        ser3.setText(randomString2);

    }
    @FXML
    void save() {
        //based on what file type the user chooses this will write to that file and save on local
    }

    @FXML
    void deleteall() {
        table_view.getItems().clear();
        list.removeAll();
    }

    @FXML
    void loadsaved() {
        //will load and update the tableview with the loaded list
    }

    @FXML
    void showerrormessage() {
        //everytime the user inputs a wrong input in the text box an error message will propagate and display a specific error message with what went wrong
    }

    //search method for filtering items in the array list
    private boolean searchFindsOrder(itemgettersetter order, String searchText){
        return (order.getSerialNumber().toLowerCase().contains(searchText.toLowerCase())) ||
                (order.getName().toLowerCase().contains(searchText.toLowerCase()));
    }
    private ObservableList<itemgettersetter> filterList(List<itemgettersetter> list, String searchText){
        List<itemgettersetter> filteredList = new ArrayList<>();
        for (itemgettersetter order : list){
            if(searchFindsOrder(order, searchText)) filteredList.add(order);
        }
        return FXCollections.observableList(filteredList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        serial_number.setCellValueFactory(new PropertyValueFactory<>("SerialNumber"));
        serial_number.setCellFactory(TextFieldTableCell.forTableColumn());

        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        name.setCellFactory(TextFieldTableCell.forTableColumn());


        value.setCellValueFactory(new PropertyValueFactory<>("Value"));
        value.setCellFactory(TextFieldTableCell.<itemgettersetter, Double>forTableColumn(new DoubleStringConverter() {
            @Override
            public Double fromString(String value) {
                try {
                    return super.fromString(value);
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("ERROR");
                    alert.setContentText("Please input a number!");
                    alert.showAndWait();
                    return null;
                }
            }
        }));


        serial_number.setOnEditCommit(
                (TableColumn.CellEditEvent<itemgettersetter, String> t) -> {
                    if (t.getNewValue().matches("[A-Z]-[0-9a-z]{3}-[0-9a-z]{3}-[0-9a-z]{3}")) {
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setSerialNumber(t.getNewValue());
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("ERROR");
                        alert.setContentText("Please input a valid serial number!");
                        alert.showAndWait();
                    }
                    table_view.refresh();
                }
        );


        name.setOnEditCommit(
                (TableColumn.CellEditEvent<itemgettersetter, String> t) -> {
                    if (t.getNewValue().length() < 2 || t.getNewValue().length() > 256) {

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("ERROR");
                        alert.setContentText("Please input a valid name!");
                        alert.showAndWait();

                        t.getOldValue();
                        table_view.refresh();
                    } else {
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setName(t.getNewValue());
                    }
                }
        );
        value.setOnEditCommit(
                (TableColumn.CellEditEvent<itemgettersetter, Double> t) -> {
                    if (t.getNewValue() == null) {
                        t.getRowValue().setValue(t.getOldValue());
                    } else {
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setValue(t.getNewValue());
                    }
                    table_view.refresh();
                }
        );

        //dynamic search bar for searching the name and serial number
        search_bar_text_field.textProperty().addListener((observable, oldValue, newValue) ->
                table_view.setItems(filterList(list, newValue))
        );

    }
}

