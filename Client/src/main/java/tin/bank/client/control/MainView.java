package tin.bank.client.control;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXScrollPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tin.bank.client.model.DataHandle;

import java.io.IOException;

public class MainView {

    @FXML
    private Label nameLb;
    @FXML
    private AnchorPane ac1;
    @FXML
    private MFXButton dBBtn;
    @FXML
    private MFXButton logOutBtn;
    @FXML
    private MFXButton withdrawBtn;
    @FXML
    private MFXButton transferButton;
    @FXML
    private MFXButton depositBtn;
    @FXML
    private MFXButton historyBtn;

    @FXML
    private void initialize() {
        // DataHandle.getLedger();

        System.out.println("initialized");

        DataHandle.getCustomers();
        nameLb.setText("Welcome" + " " + DataHandle.mainAccount.toString());
        // load the dashboard pane
        dBBtn.setOnAction(event -> loadPane("DashBoard", event));
        // log out button
        logOutBtn.setOnAction(event -> {
            DataHandle.resetList();
            loadPage("LogInDialog", event);
        });
        // withdraw button
        withdrawBtn.setOnAction(event -> loadPane("Withdraw", event));
        transferButton.setOnAction(event -> loadPane("Transfer", event));
        depositBtn.setOnAction(event -> loadPane("Deposit", event));
        historyBtn.setOnAction(event -> loadPane("History", event));
    }

    // load scroll pane
    private void loadSPane(String name, ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            // check if the pane is already loaded
            if (stage.getTitle().equals(name)) {
                return;
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/tin/bank/client/Pane/" + name + ".fxml"));

                MFXScrollPane newPane = loader.load();

                // Set the loaded FXML file as the content of our main right-side pane
                ac1.getChildren().setAll(newPane);

                stage.setTitle(name);
                // Reset the anchors
                AnchorPane.setBottomAnchor(newPane, 0.0);
                AnchorPane.setLeftAnchor(newPane, 0.0);
                AnchorPane.setRightAnchor(newPane, 0.0);
                AnchorPane.setTopAnchor(newPane, 0.0);
                System.out.println("Loaded " + name + " page");
                System.out.println(stage.getTitle());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method to load the pane
    public void loadPane(String name, ActionEvent event) {

        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            // check if the pane is already loaded
            if (stage.getTitle().equals(name)) {
                return;
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/tin/bank/client/Pane/" + name + ".fxml"));

                AnchorPane newPane = loader.load();

                // Set the loaded FXML file as the content of our main right-side pane
                ac1.getChildren().setAll(newPane);

                stage.setTitle(name);
                // Reset the anchors
                AnchorPane.setBottomAnchor(newPane, 0.0);
                AnchorPane.setLeftAnchor(newPane, 0.0);
                AnchorPane.setRightAnchor(newPane, 0.0);
                AnchorPane.setTopAnchor(newPane, 0.0);
                System.out.println("Loaded " + name + " page");
                System.out.println(stage.getTitle());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPage(String page, ActionEvent event) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/tin/bank/client/" + page + ".fxml"));
            Parent content = loader.load();

            Scene scene = new Scene(content);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
            stage.setX(300);
            stage.setY(200);
            stage.setTitle("Client");
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // TODO: Jan 02 2023
    // 1. Add Dashboard pane DONE
    // 2. Add Transfer pane In progress
    // 3. Add Deposit pane In progress
    // 4. Add Withdraw pane not started
    // 5. Add History pane not started
    private void loadMPane(String name, MouseEvent event) {

        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            // check if the pane is already loaded
            if (stage.getTitle().equals(name)) {
                return;
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/tin/bank/client/Pane/" + name + ".fxml"));

                AnchorPane newPane = loader.load();

                // Set the loaded FXML file as the content of our main right-side pane
                ac1.getChildren().setAll(newPane);

                stage.setTitle(name);
                // Reset the anchors
                AnchorPane.setBottomAnchor(newPane, 0.0);
                AnchorPane.setLeftAnchor(newPane, 0.0);
                AnchorPane.setRightAnchor(newPane, 0.0);
                AnchorPane.setTopAnchor(newPane, 0.0);
                System.out.println("Loaded " + name + " page");
                System.out.println(stage.getTitle());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Open profile by clicking on the name
    @FXML
    void profileBtn(MouseEvent event) {
        loadMPane("Profile", event);
    }

}
