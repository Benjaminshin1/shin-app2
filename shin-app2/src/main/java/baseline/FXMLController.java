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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

