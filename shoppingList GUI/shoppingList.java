import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;

public class shoppingList extends Application {

  private ArrayList<String> itemsToBuy = new ArrayList<>();
  private ArrayList<String> removeItems = new ArrayList<>();
  private boolean darkMode;

  public void start(Stage gameStage){

    GridPane listScene = new GridPane();

    Text textHeading = new Text("Shopping List");
    textHeading.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 30));
    textHeading.setTranslateX(260);
    textHeading.setTranslateY(15);

    Label insertToList = new Label("Add To List");
    insertToList.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 23));
    insertToList.setTranslateX(75);
    insertToList.setTranslateY(85);

    Label itemsNeeded = new Label("Items To Buy");
    itemsNeeded.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 23));
    itemsNeeded.setTranslateX(525);
    itemsNeeded.setTranslateY(85);

    TextField newItem = new TextField();
    newItem.setPromptText("Enter New Item:");
    newItem.setMinWidth(175);
    newItem.setMaxWidth(175);
    newItem.setMinHeight(35);
    newItem.setFocusTraversable(false);
    newItem.setTranslateX(75);
    newItem.setTranslateY(125);
    newItem.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 15));

    Button addItem = new Button("Insert");
    addItem.setMinWidth(175);
    addItem.setMaxWidth(175);
    addItem.setMinHeight(35);
    addItem.setTranslateX(75);
    addItem.setTranslateY(170);
    addItem.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 15));
    addItem.setOnAction(event -> addNewItem(gameStage, String.valueOf(newItem.getText())));
    addItem.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");

    Button deleteItem = new Button("Remove");
    deleteItem.setMinWidth(175);
    deleteItem.setMaxWidth(175);
    deleteItem.setMinHeight(35);
    deleteItem.setTranslateX(525);
    deleteItem.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 15));
    deleteItem.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");
    deleteItem.setOnAction(event -> removeTheItems(gameStage));

    Button changeMode = new Button();
    changeMode.setMinWidth(120);
    changeMode.setMaxWidth(120);
    changeMode.setMinHeight(30);
    changeMode.setTranslateX(635);
    changeMode.setTranslateY(15);
    changeMode.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 13));
    changeMode.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");
    changeMode.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");
    changeMode.setOnAction(event -> { darkMode = !darkMode; start(gameStage); });

    if(darkMode){
      changeMode.setText("Dark Mode");
      listScene.setStyle("-fx-background-color: #FFF;");
      insertToList.setTextFill(Color.web("#383838"));
      itemsNeeded.setTextFill(Color.web("#383838"));
      textHeading.setFill(Color.web("#383838"));
    } else {
      changeMode.setText("Light Mode");
      listScene.setStyle("-fx-background-color: #181818;");
      textHeading.setFill(Color.WHITE);
      insertToList.setTextFill(Color.WHITE);
      itemsNeeded.setTextFill(Color.WHITE);
    }

    if(!itemsToBuy.isEmpty()){
      listScene.getChildren().add(deleteItem);
    }
    listScene.getChildren().addAll(textHeading, insertToList, newItem, addItem, itemsNeeded, changeMode);

    int x = 85;
    for(String s: itemsToBuy){
      CheckBox itemInList = new CheckBox(s.toUpperCase());
      if(darkMode){
        itemInList.setStyle("-fx-text-fill: #383838;");
      } else {
        itemInList.setStyle("-fx-text-fill: #FFF;");
      }
      itemInList.setTranslateX(525);
      itemInList.setTranslateY(x += 32.5);
      itemInList.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 15));
      itemInList.setOnAction(event -> {
        if(itemInList.isSelected()){
          removeItems.add(s);
        } else {
          for(int i = 0; i < removeItems.size(); i++){
            if(removeItems.get(i).equals(s)){
              removeItems.remove(i);
              break;
            }
          }
        }
      });
      listScene.getChildren().add(itemInList);
    }
    deleteItem.setTranslateY(x += 40);

    Scene gameScene = new Scene(listScene, 775, 500);
    gameStage.setTitle("Shopping List");
    gameStage.setScene(gameScene);
    gameStage.setResizable(false);
    gameStage.show();

  }

  public void addNewItem(Stage gameStage, String newItem){
    boolean alreadyInList = false;
    for(String s: itemsToBuy){
      if(s.equals(newItem)){
        alreadyInList = true;
      }
    }
    if(!alreadyInList && newItem.length() > 0){
      itemsToBuy.add(newItem);
    }
    start(gameStage);
  }

  public void removeTheItems(Stage gameStage){
    for(int i = 0; i < removeItems.size(); i++){
      for(int j = 0; j < itemsToBuy.size(); j++){
        if(removeItems.get(i).equals(itemsToBuy.get(j))){
          itemsToBuy.remove(j);
          break;
        }
      }
    }
    removeItems.clear();
    start(gameStage);
  }

}
