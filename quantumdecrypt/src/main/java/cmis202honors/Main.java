package cmis202honors;

import java.util.Map;
import java.util.HashMap;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Main extends Application {

    static protected String[] encryptionTypes = {"RSA"}; // RSA for now because I know nothing else.
    static protected Integer[] qubitTypes = {1, 2, 4};

    static protected Map<String, Integer> encryptionTypesMap = new HashMap<>();

    public void start(Stage primaryStage) {
        
        // Begin nodes

        FlowPane fullPane = new FlowPane(Orientation.HORIZONTAL);
        fullPane.setAlignment(Pos.CENTER);
        fullPane.setPadding(new Insets(15));
        // fullPane.setHgap(-100); // I actually had no idea this would work.

        FlowPane outputPane = new FlowPane(Orientation.HORIZONTAL);
        outputPane.setAlignment(Pos.CENTER);
        // outputPane.setHgap(-250);

        FlowPane optionsPane = new FlowPane(Orientation.VERTICAL);
        optionsPane.setAlignment(Pos.CENTER);
        // optionsPane.setHgap(-250);

        FlowPane encryptionPane = new FlowPane(Orientation.HORIZONTAL);
        encryptionPane.setAlignment(Pos.CENTER);
            
        FlowPane qubitsPane = new FlowPane(Orientation.HORIZONTAL);
        qubitsPane.setAlignment(Pos.CENTER);

        // Nodes
        Label title = new Label("Let's get cracking!");
        title.setAlignment(Pos.CENTER);

        Label encryptionLabel = new Label("Choose an encryption scheme:");
        Button encryptionButton = new Button("[CLICK TO CHOOSE]");
        ListView<String> encryptionView = new ListView<>(FXCollections.observableArrayList(encryptionTypes));
        encryptionView.setMaxHeight(48.0); // 24 is the length in pixels of each bar. Only shows two bars at a time.
        encryptionView.setMinHeight(24.0);
        encryptionView.setVisible(false);

        Label qubitsLabel = new Label("Choose the number of qubits to work with:");
        Button qubitsButton = new Button("[CLICK TO CHOOSE]");
        ListView<Integer> qubitsView = new ListView<>(FXCollections.observableArrayList(qubitTypes));
        qubitsView.setMaxHeight(48.0);
        qubitsView.setMinHeight(24.0);
        qubitsView.setVisible(false);

        Button calculateButton = new Button("Calculate");
        calculateButton.setAlignment(Pos.CENTER);

        Label output = new Label("WIP"); // Will be changed later to show output
        output.setAlignment(Pos.CENTER);
        output.setVisible(false);

        // End nodes

        // Begin event handlers

        // visible = not visible (logically negates the boolean value)
        encryptionButton.setOnAction(_ -> encryptionView.setVisible(!encryptionView.visibleProperty().getValue()));
        qubitsButton.setOnAction(_ -> qubitsView.setVisible(!qubitsView.visibleProperty().getValue()));

        // Changes button text to the selection, seems like a nice QOL.
        encryptionView.getSelectionModel().selectedItemProperty().addListener(_ -> {
            encryptionButton.setText(encryptionView.getSelectionModel().getSelectedItem());
        });
        qubitsView.getSelectionModel().selectedItemProperty().addListener(_ -> {
            qubitsButton.setText("" + qubitsView.getSelectionModel().getSelectedItem());
        });

        // calculation
        calculateButton.setOnAction(_ -> {
            output.setVisible(!output.visibleProperty().getValue());
        });
        
        // End event handlers

        encryptionPane.getChildren().addAll(encryptionLabel, encryptionButton, encryptionView);
        qubitsPane.getChildren().addAll(qubitsLabel, qubitsButton, qubitsView);
        optionsPane.getChildren().addAll(encryptionPane, qubitsPane);
        outputPane.getChildren().addAll(calculateButton, output);
        fullPane.getChildren().addAll(title, optionsPane, outputPane);

        Scene scene = new Scene(fullPane);
        primaryStage.setTitle("Quantum Decryptor"); // Wow, very sci-fi.
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
