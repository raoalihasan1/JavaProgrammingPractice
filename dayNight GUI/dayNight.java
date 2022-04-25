import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class dayNight extends Application {

  private boolean darkMode;
  private int initialRadius = 30;
  private int initialInsetRect = -30;
  private int initialInsetCirc = 5;
  private double initialInsetCirc2 = 275;
  private int initialHeight = 100;

  public void start(Stage gameStage) {

    Rectangle rect = new Rectangle();
    rect.setWidth(355);
    rect.setHeight(initialHeight);
    rect.setFill(Color.web("#7EC850"));

    Rectangle square = new Rectangle();
    square.setWidth(170);
    square.setHeight(170);
    square.setFill(Color.web("#FFF"));

    Polygon triangle = new Polygon();
    triangle.getPoints().addAll(85.0, 0.0, 0.0, 85.0, 170.0, 85.0);
    triangle.setFill(Color.web("#FF7F7F"));

    Circle circ = new Circle();
    circ.setRadius(initialRadius);
    circ.setFill(Color.web("#F9D71C"));

    VBox vBox = new VBox();
    vBox.setStyle("-fx-background-color: #87CEEB;");
    vBox.getChildren().addAll(circ, triangle, square, rect);
    vBox.setAlignment(Pos.CENTER);

    vBox.setMargin(rect, new Insets(0, 0, initialInsetRect, 0));
    vBox.setMargin(circ, new Insets(0, 0, initialInsetCirc, initialInsetCirc2));

    square.setOnMouseClicked(e -> {
      if(darkMode){
        rect.setFill(Color.web("#7EC850"));
        triangle.setFill(Color.web("#FF7F7F"));
        circ.setFill(Color.web("#F9D71C"));
        vBox.setStyle("-fx-background-color: #87CEEB;");
        darkMode = !darkMode;
      } else {
        rect.setFill(Color.web("#378805"));
        vBox.setStyle("-fx-background-color: #000;");
        triangle.setFill(Color.web("#E3242B"));
        circ.setFill(Color.web("#FFF"));
        darkMode = !darkMode;
      }
    });

    Scene gameScene = new Scene(vBox, 355, 405);

    gameScene.setOnKeyPressed(e -> {
      if(e.getCode() == KeyCode.EQUALS){
        circ.setRadius(initialRadius++);
        rect.setHeight(initialHeight--);
        vBox.setMargin(circ, new Insets(0, 0, initialInsetCirc--, initialInsetCirc2--));
        vBox.setMargin(rect, new Insets(0, 0, initialInsetRect--, 0));
      } else if(e.getCode() == KeyCode.MINUS){
        rect.setHeight(initialHeight++);
        circ.setRadius(initialRadius--);
        vBox.setMargin(circ, new Insets(0, 0, initialInsetCirc++, initialInsetCirc2++));
        vBox.setMargin(rect, new Insets(0, 0, initialInsetRect++, 0));
      }
    });

    gameStage.setScene(gameScene);
    gameStage.setTitle("Day And Night");
    gameStage.show();

  }

}
