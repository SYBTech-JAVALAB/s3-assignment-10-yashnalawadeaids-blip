import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class ArithmeticCalculatorFX extends Application {
@Override
public void start(Stage primaryStage) {
// Labels
Label lbl1 = new Label("Number 1:");
Label lbl2 = new Label("Number 2:");
Label lblResult = new Label("Result:");
// Input fields
TextField txt1 = new TextField();
TextField txt2 = new TextField();
TextField txtResult = new TextField();
txtResult.setEditable(false);
// Buttons
Button add = new Button("+");
Button sub = new Button("-");
Button mul = new Button("*");
Button div = new Button("/");
// Event handling
add.setOnAction(e -> calculate(txt1, txt2, txtResult, "+"));
sub.setOnAction(e -> calculate(txt1, txt2, txtResult, "-"));
mul.setOnAction(e -> calculate(txt1, txt2, txtResult, "*"));
div.setOnAction(e -> calculate(txt1, txt2, txtResult, "/"));
// Layout
GridPane grid = new GridPane();
grid.setPadding(new Insets(15));
grid.setVgap(10);
grid.setHgap(10);
grid.add(lbl1, 0, 0);
grid.add(txt1, 1, 0);
grid.add(lbl2, 0, 1);
grid.add(txt2, 1, 1);
grid.add(add, 0, 2);
grid.add(sub, 1, 2);
grid.add(mul, 0, 3);
grid.add(div, 1, 3);
grid.add(lblResult, 0, 4);
grid.add(txtResult, 1, 4);
Scene scene = new Scene(grid, 300, 250);
primaryStage.setTitle("JavaFX Arithmetic Calculator");
primaryStage.setScene(scene);
primaryStage.show();
}
private void calculate(TextField t1, TextField t2, TextField result, String
op) {
try {
int num1 = Integer.parseInt(t1.getText());
int num2 = Integer.parseInt(t2.getText());
int res = 0;
switch (op) {
case "+" -> res = num1 + num2;
case "-" -> res = num1 - num2;
case "*" -> res = num1 * num2;
case "/" -> {
if (num2 == 0) {
result.setText("Cannot divide by zero");
return;
}
res = num1 / num2;
}
}
result.setText(String.valueOf(res));
} catch (NumberFormatException e) {
result.setText("Invalid Input");
}
}
public static void main(String[] args) {
Application.launch(ArithmeticCalculatorFX.class, args);
 }
}
