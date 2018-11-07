package memoryBank;

import app.Controlable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailStatusRegisterController implements Controlable, Initializable {

    private Stage stage;

    @FXML
    private TableView<MemoryBankViewModel> registerTable;

    private MemoryBankViewModel memoryBankViewModel;

    public DetailStatusRegisterController(MemoryBankViewModel memoryBankViewModel) {
        this.memoryBankViewModel = memoryBankViewModel;
    }

    @Override
    public void setStage(Stage stage) {

        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        registerTable.getColumns().clear();

        final String[] statusRegisterLabels = {"IRP", "RP1", "RP0", "T0", "PD", "Z", "DC", "D"};
        for (int i = 0; i < statusRegisterLabels.length; i++) {

            final int idx = i;
            TableColumn<MemoryBankViewModel, String> column = new TableColumn<>(statusRegisterLabels[i]);
            column.setCellValueFactory(m -> m.getValue().getStatusBit(7 - idx));
            column.prefWidthProperty().bind(registerTable.widthProperty().multiply(.125d));
            registerTable.getColumns().add(column);
        }

        registerTable.getItems().addAll(memoryBankViewModel);
        memoryBankViewModel.setDetailStatusRegisterController(this);
    }

    public void update() {
        registerTable.getItems().clear();
        registerTable.getItems().addAll(memoryBankViewModel);
    }
}
