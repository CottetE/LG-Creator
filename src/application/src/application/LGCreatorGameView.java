package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LGCreatorGameView{
  
  //-------------------------------------------------------------------------
  //Conteneurs et composants du Game
  //-------------------------------------------------------------------------
  private VBox rootGame = new VBox();
  private Button menuBT = new Button("Menu");
  
  public void start(Stage primaryStage){   
    //-------------------------------------------------------------------------
    //Conteneurs et composants du Game
    //-------------------------------------------------------------------------
    rootGame.getChildren().addAll(menuBT);
    rootGame.setPadding(new Insets(20));
    rootGame.setAlignment(Pos.CENTER);
    rootGame.setSpacing(20);
    VBox.setVgrow(menuBT, Priority.ALWAYS);
    rootGame.setBorder(new Border(new BorderStroke(Color.BLACK,
                                                   BorderStrokeStyle.SOLID,
                                                   CornerRadii.EMPTY,
                                                   new BorderWidths(5),
                                                   new Insets(0)            )));
  }
  public void setRootForGameView(Stage primaryStage, LGCreatorMenuView menuView) {
    //-------------------------------------------------------------------------
    //Controleur sur le bouton menuBT
    //-------------------------------------------------------------------------
    menuBT.setOnMouseClicked(event->{
      primaryStage.setTitle("s04 LGCreator Application - Game");
      //scene.setRoot(rootMenu);
      menuView.setRootForMenuView(primaryStage.getScene());
    });
    
    primaryStage.getScene().setRoot(rootGame);
  }
}
  

