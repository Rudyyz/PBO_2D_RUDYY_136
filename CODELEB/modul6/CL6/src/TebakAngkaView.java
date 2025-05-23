import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class TebakAngkaView {

    private final VBox root;
    private final TextField inputField;
    private final Button button;
    private final Label feedbackLabel;
    private final Label attemptLabel;

    private TebakAngkaLogic logic;

    public TebakAngkaView() {
        logic = new TebakAngkaLogic();

        inputField = new TextField();
        inputField.setPromptText("Masukkan angka 1 - 100");

        button = new Button("Coba Tebak!");
        feedbackLabel = new Label();
        attemptLabel = new Label("Jumlah Percobaan: 0");

        button.setOnAction(e -> handleButtonClick());

        root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(
                new Label("Tebak Angka (1 - 100):"),
                inputField,
                button,
                feedbackLabel,
                attemptLabel
        );
    }

    private void handleButtonClick() {
        if (button.getText().equals("Main Lagi")) {
            logic = new TebakAngkaLogic();
            feedbackLabel.setText("");
            attemptLabel.setText("Jumlah Percobaan: 0");
            inputField.clear();
            button.setText("Coba Tebak!");
            return;
        }

        try {
            int guess = Integer.parseInt(inputField.getText().trim());

            if (guess < 1 || guess > 100) {
                throw new NumberFormatException("Angka di luar rentang 1 - 100");
            }

            String result = logic.cekTebakan(guess);
            feedbackLabel.setText(result);
            attemptLabel.setText("Jumlah Percobaan: " + logic.getAttempts());

            if (logic.isBenar(guess)) {
                button.setText("Main Lagi");
            }

        } catch (NumberFormatException e) {
            feedbackLabel.setText("Masukkan angka yang valid (1 - 100)!");
        }
    }

    public VBox getView() {
        return root;
    }
}
