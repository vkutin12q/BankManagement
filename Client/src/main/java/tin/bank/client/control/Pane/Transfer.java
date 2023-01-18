package tin.bank.client.control.Pane;

import java.util.LinkedList;

import io.github.palexdev.materialfx.controls.MFXButton;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import tin.bank.client.model.Account;
import tin.bank.client.model.DataHandle;

public class Transfer {

    private LinkedList<Account> accounts = DataHandle.accounts;
    @FXML
    private ComboBox<Account> accountBox;

    @FXML
    private MFXTextField amountTextfield;

    @FXML
    private MFXButton currentBtn;

    @FXML
    private MFXButton okBtn;

    @FXML
    private void initialize() {
        // Set the current account balance
        currentBtn.setText(DataHandle.mainAccount.getBalance().toString());
        // Add all accounts name to the ComboBox
        accountBox.getItems().addAll(accounts);
        okBtn.setOnAction(this::handleTransfer);
    }

    // FIXME: Later or improve server structure then improve this method
    // @FXML
    // NOTE: I will improve this method later
    // TODO: Jan 07 2023
    private void handleTransfer(ActionEvent event) {
        // Get the selected account from the ComboBox
        // Account selectedAccount = accountBox.getSelectionModel().getSelectedItem();

        // Continue with the rest of the transfer process...
        // Get the amount from the textfield
        // TODO: Add regex
        Double amount = Double.parseDouble(amountTextfield.getText());
        if (amount <= 0) {
            amountTextfield.setText("Transfer failed");

        } else {
            DataHandle.transferMoney(DataHandle.mainAccount.getId(), accountBox.getValue().getId(), amount);
            DataHandle.getMainAccount(DataHandle.mainAccount.getUsername());
            currentBtn.setText(DataHandle.mainAccount.getBalance().toString());
        }
    }
}
