package baseline;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class FXMLController implements Initializable {

    @FXML
    private MenuItem load_saved;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TextField name_text_field;

    @FXML
    private TextField price_text_field;

    @FXML
    private MenuItem save_as;

    @FXML
    private TableColumn<?, ?> serial_number;

    @FXML
    private TextField serial_number_text_field;

    @FXML
    private TableView<?> table_view;

    @FXML
    private TableColumn<?, ?> value;

    @FXML
    void addtolist(){
        //get the text from the user input and diplay it on the tableview
    }
    @FXML
    void removefromlist(){
        //user can click on an item an it will remove the item from the list
    }
    @FXML
    void searchitem(){
        //user can input a string and it will compare and search from the saved array will search for serial number and name
    }
    @FXML
    void savefile(){
        //will save file of the array list in a TSV/HTML/and JSON
    }
    @FXML
    void save(){
        //based on what file type the user chooses this will write to that file and save on local
    }
    @FXML
    void loadsaved(){
        //will load and update the tableview with the loaded list
    }
    @FXML
    void showerrormessage(){
        //everytime the user inputs a wrong input in the text box an error message will propagate and display a specific error message with what went wrong
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

