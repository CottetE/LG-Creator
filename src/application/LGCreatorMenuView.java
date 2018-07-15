package application;

import java.util.Set;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class LGCreatorMenuView extends Application{
  private LGCreatorModel model;
  Scene scene;
  
  private int index;
  LGCreatorGameView gameView;
  Stage primaryStage;
  private LGCreatorMouseEventController mouseEventController;
  
  //-------------------------------------------------------------------------
  //Conteneurs et composants du Menu
  //-------------------------------------------------------------------------
  private VBox rootMenu = new VBox();
  private Label title = new Label("LGCreator");
  private HBox menuHB = new HBox();
  
  private VBox leftMenuVB = new VBox();
  private VBox rightMenuVB = new VBox();
  
  private HBox playerNbrHB = new HBox();
  private Label playerNbrLbl = new Label("Nombre de joueurs : ");
  private Label playerNbr = new Label("");
  
  private VBox variantesVB = new VBox();
  private Label variantesLbl = new Label("Variantes de jeu : ");
  private RadioButton varianteStdRB = new RadioButton("Variante standard");
  private RadioButton varianteFWRB = new RadioButton("Variante Far West");
  private ToggleGroup varianteGrp = new ToggleGroup();
  
  private VBox extensionsVB = new VBox();
  private Label extensionsLbl = new Label("Extensions : ");
  CheckBox jeuDeBaseCB = new CheckBox("Jeu de base");
  CheckBox nouvelleLuneCB = new CheckBox("Nouvelle Lune");
  private VBox nouvelleLuneVB = new VBox();
  RadioButton nouvelleLuneRB1 = new RadioButton("Avec événements");
  RadioButton nouvelleLuneRB2 = new RadioButton("Sans événements");
  private ToggleGroup nouvelleLuneGrp = new ToggleGroup();
  CheckBox leVillageCB = new CheckBox("Le Village");
  private VBox leVillageVB = new VBox();
  RadioButton leVillageRB1 = new RadioButton("Avec bâtiments");
  RadioButton leVillageRB2 = new RadioButton("Sans bâtiments");
  private ToggleGroup leVillageGrp = new ToggleGroup();
  CheckBox personnagesCB = new CheckBox("Personnages");
  CheckBox cartesInventeesCB = new CheckBox("Cartes inventées");
  
  private VBox buttonVB = new VBox();
  Button nouvellePartieBT = new Button("Lancer une \nnouvelle partie");
  Button reprendrePartieBT = new Button("Reprendre la \npartie en cours");
  
  private ScrollPane rolesSP = new ScrollPane();
  GridPane rolesGrid = new GridPane();
  VBox[] rolesVBArray = new VBox[LGCreator.NOMBRE_DE_ROLES_TOTAL];
  private Label[] rolesLblArray = {new Label("Chasseur"),
                                   new Label("Cupidon"),
                                   new Label("Petite Fille"),
                                   new Label("Simple Loup-Garou"),
                                   new Label("Simple Villageois"),
                                   new Label("Sorcière"),
                                   new Label("Voleur"),
                                   new Label("Voyante"),
                                   
                                   new Label("Ancien"),
                                   new Label("Bouc Émissaire"),
                                   new Label("Idiot du Village"),
                                   new Label("Joueur de Flûte"),
                                   new Label("Salvateur"),
                                   
                                   new Label("Corbeau"),
                                   new Label("Loup-Garou Blanc"),
                                   new Label("Pyromane"),
                                   
                                   new Label("Abominable Sectaire"),
                                   new Label("Ange"),
                                   new Label("Chevalier à l'Épée Rouillée"),
                                   new Label("Chien-Loup"),
                                   new Label("Comédien"),
                                   new Label("Enfant Sauvage"),
                                   new Label("Frère"),
                                   new Label("Gitane (Sans Philtre)"),
                                   new Label("Grand-Méchant-Loup"),
                                   new Label("Infect Père des Loups"),
                                   new Label("Juge Bègue"),
                                   new Label("Montreur d'Ours"),
                                   new Label("Renard"),
                                   new Label("Servante Dévouée"),
                                   new Label("Soeur"),
                                   new Label("Villageois-Villageois"),
                                   
                                   new Label("Démon"),
                                   new Label("Druide"),
                                   new Label("Maître des Émotions"),
                                   new Label("Rôdeur"),
                                   new Label("Sirène"),
                                   new Label("Wendigo")};
  private Image[] rolesImgArray = {new Image(getClass().getResourceAsStream("/application/resources/jeu_de_base/chasseur.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/jeu_de_base/cupidon.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/jeu_de_base/petite_fille.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/jeu_de_base/simple_loup_garou.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/jeu_de_base/simple_villageois.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/jeu_de_base/sorciere.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/jeu_de_base/voleur.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/jeu_de_base/voyante.png")),

                                   new Image(getClass().getResourceAsStream("/application/resources/nouvelle_lune/ancien.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/nouvelle_lune/bouc_emissaire.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/nouvelle_lune/idiot_du_village.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/nouvelle_lune/joueur_de_flute.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/nouvelle_lune/salvateur.png")),
                                   
                                   new Image(getClass().getResourceAsStream("/application/resources/le_village/corbeau.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/le_village/loup_garou_blanc.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/le_village/pyromane.png")),
                                   
                                   new Image(getClass().getResourceAsStream("/application/resources/personnages/abominable_sectaire.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/personnages/ange.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/personnages/chevalier_a_l_epee_rouillee.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/personnages/chien_loup.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/personnages/comedien.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/personnages/enfant_sauvage.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/personnages/frere.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/personnages/gitane.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/personnages/grand_mechant_loup.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/personnages/infect_pere_des_loups.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/personnages/juge_begue.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/personnages/montreur_d_ours.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/personnages/renard.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/personnages/servante_devouee.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/personnages/soeur.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/personnages/villageois_villageois.png")),
                                   
                                   new Image(getClass().getResourceAsStream("/application/resources/cartes_inventees/demon.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/cartes_inventees/druide.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/cartes_inventees/maitre_des_emotions.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/cartes_inventees/rodeur.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/cartes_inventees/sirene.png")),
                                   new Image(getClass().getResourceAsStream("/application/resources/cartes_inventees/wendigo.png"))};
  private ImageView[] rolesIVArray = new ImageView[LGCreator.NOMBRE_DE_ROLES_TOTAL];

  Label[] rolesNbrLblArray = new Label[LGCreator.NOMBRE_DE_ROLES_TOTAL];
  
  private Image[] fonds = {new Image(getClass().getResourceAsStream("/application/resources/autres/fond_arriere.png")),
                           new Image(getClass().getResourceAsStream("/application/resources/autres/fond_arriere2.png")),
                           new Image(getClass().getResourceAsStream("/application/resources/autres/fond_arriere3.png"))};

  public String fontParametre = "-fx-font-size: 14pt;\r\n" + 
                                "    -fx-font-family: \"Courier New\";\r\n" + 
                                "    -fx-text-fill: rgb(255, 255, 255);\r\n";
  
  public String fontParametre2 = "-fx-font-size: 14pt;\r\n" + 
                                 "    -fx-font-family: \"Courier New\";\r\n" + 
                                 "    -fx-text-fill: rgb(0, 0, 0);\r\n";
  //-------------------------------------------------------------------------
  //init()
  //-------------------------------------------------------------------------
  @Override
  public void init() {
    for(int i=0;i<LGCreator.NOMBRE_DE_ROLES_TOTAL;i++) {
      rolesVBArray[i] = new VBox();
      rolesIVArray[i] = new ImageView(rolesImgArray[i]);
      rolesIVArray[i].setId("" + i);
      rolesNbrLblArray[i] = new Label("0");
      rolesNbrLblArray[i].setStyle(fontParametre);
      rolesVBArray[i].getChildren().addAll(rolesLblArray[i],rolesIVArray[i],rolesNbrLblArray[i]);
      rolesVBArray[i].setAlignment(Pos.CENTER);
      rolesVBArray[i].setStyle("-fx-border-width: 5 5 5 5; -fx-border-color: black;");
      rolesIVArray[i].setFitHeight(200);
      rolesIVArray[i].setFitWidth(200);
    }
  }

  //-------------------------------------------------------------------------
  //start()
  //-------------------------------------------------------------------------
  @Override
  public void start(Stage primaryStage) throws Exception {
    model = new LGCreatorModel();
    gameView = new LGCreatorGameView();
    this.primaryStage = primaryStage;
    mouseEventController = new LGCreatorMouseEventController(this,model);
    gameView.start(primaryStage);
    
    BackgroundImage fond_arriere1 = new BackgroundImage(fonds[0],
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
          BackgroundSize.DEFAULT);
    
    BackgroundImage fond_arriere2 = new BackgroundImage(fonds[2],
        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
          BackgroundSize.DEFAULT);
    
    BackgroundImage fond_arriere3 = new BackgroundImage(fonds[1],
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
          BackgroundSize.DEFAULT);
    
    //-------------------------------------------------------------------------
    //Conteneurs et composants du Menu
    //-------------------------------------------------------------------------
    rootMenu.getChildren().addAll(title,menuHB);
    rootMenu.setPadding(new Insets(20));
    rootMenu.setAlignment(Pos.CENTER);
    rootMenu.setSpacing(20);
    VBox.setVgrow(menuHB, Priority.ALWAYS);
    rootMenu.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY,
        new BorderWidths(5),
        new Insets(0)            )));
    rootMenu.setBackground(new Background(fond_arriere1));
    
    title.setFont(Font.font ("Verdana", FontWeight.BOLD, 70));
    title.setTextFill(Color.NAVAJOWHITE);
    
    menuHB.getChildren().addAll(leftMenuVB,rightMenuVB);
    menuHB.setAlignment(Pos.CENTER);
    HBox.setHgrow(rightMenuVB, Priority.ALWAYS);
    menuHB.setSpacing(10);
    menuHB.setBackground(new Background(fond_arriere1));
    
    leftMenuVB.getChildren().addAll(variantesVB,extensionsVB,buttonVB);
    leftMenuVB.setPadding(new Insets(10,0,10,0));
    leftMenuVB.setAlignment(Pos.TOP_CENTER);
    leftMenuVB.setSpacing(10);
    leftMenuVB.setMinWidth(350);
    leftMenuVB.setMaxWidth(350);
    leftMenuVB.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY,
        new BorderWidths(5),
        new Insets(0)            )));
    leftMenuVB.setBackground(new Background(fond_arriere2));
    
    variantesVB.getChildren().addAll(variantesLbl,varianteStdRB,varianteFWRB);
    variantesVB.setPadding(new Insets(10));
    variantesVB.setAlignment(Pos.CENTER);
    variantesVB.setSpacing(10);
    variantesVB.setStyle("-fx-border-width: 5 0 5 0; -fx-border-color: black;");
    
    variantesLbl.setMinWidth(250);
    variantesLbl.setMaxWidth(250);
    variantesLbl.setStyle(fontParametre);
    
    varianteStdRB.setMinWidth(250);
    varianteStdRB.setMaxWidth(250);
    varianteStdRB.setSelected(true);
    varianteStdRB.setToggleGroup(varianteGrp);
    varianteStdRB.setStyle(fontParametre);
    
    varianteFWRB.setMinWidth(250);
    varianteFWRB.setMaxWidth(250);
    varianteFWRB.setDisable(true);
    varianteFWRB.setToggleGroup(varianteGrp);
    varianteFWRB.setStyle(fontParametre);
    
    extensionsVB.getChildren().addAll(extensionsLbl,jeuDeBaseCB,nouvelleLuneCB,nouvelleLuneVB,leVillageCB,leVillageVB,personnagesCB,cartesInventeesCB);
    extensionsVB.setPadding(new Insets(10));
    extensionsVB.setAlignment(Pos.CENTER);
    extensionsVB.setSpacing(10);
    extensionsVB.setStyle("-fx-border-width: 5 0 5 0; -fx-border-color: black;");
    
    extensionsLbl.setMinWidth(150);
    extensionsLbl.setMaxWidth(150);
    extensionsLbl.setStyle(fontParametre);
    
    jeuDeBaseCB.setMinWidth(250);
    jeuDeBaseCB.setMaxWidth(250);
    jeuDeBaseCB.setStyle(fontParametre);
    
    nouvelleLuneCB.setMinWidth(250);
    nouvelleLuneCB.setMaxWidth(250);
    nouvelleLuneCB.setStyle(fontParametre);
    
    nouvelleLuneVB.getChildren().addAll(nouvelleLuneRB1,nouvelleLuneRB2);
    nouvelleLuneVB.setAlignment(Pos.CENTER_RIGHT);
    nouvelleLuneVB.setSpacing(10);
    nouvelleLuneVB.setMinWidth(240);
    nouvelleLuneVB.setMaxWidth(240);
    
    nouvelleLuneRB1.setMinWidth(220);
    nouvelleLuneRB1.setMaxWidth(220);
    nouvelleLuneRB1.setToggleGroup(nouvelleLuneGrp);
    nouvelleLuneRB1.setDisable(true);
    nouvelleLuneRB1.setStyle(fontParametre);
    
    nouvelleLuneRB2.setMinWidth(220);
    nouvelleLuneRB2.setMaxWidth(220);
    nouvelleLuneRB2.setToggleGroup(nouvelleLuneGrp);
    nouvelleLuneRB2.setDisable(true);
    nouvelleLuneRB2.setStyle(fontParametre);
    
    leVillageCB.setMinWidth(250);
    leVillageCB.setMaxWidth(250);
    leVillageCB.setStyle(fontParametre);
    
    leVillageVB.getChildren().addAll(leVillageRB1,leVillageRB2);
    leVillageVB.setAlignment(Pos.CENTER_RIGHT);
    leVillageVB.setSpacing(10);
    leVillageVB.setMinWidth(240);
    leVillageVB.setMaxWidth(240);
    
    leVillageRB1.setMinWidth(220);
    leVillageRB1.setMaxWidth(220);
    leVillageRB1.setToggleGroup(leVillageGrp);
    leVillageRB1.setDisable(true);
    leVillageRB1.setStyle(fontParametre);
    
    leVillageRB2.setMinWidth(220);
    leVillageRB2.setMaxWidth(220);
    leVillageRB2.setToggleGroup(leVillageGrp);
    leVillageRB2.setDisable(true);
    leVillageRB2.setStyle(fontParametre);
    
    personnagesCB.setMinWidth(250);
    personnagesCB.setMaxWidth(250);
    personnagesCB.setStyle(fontParametre);
    
    cartesInventeesCB.setMinWidth(250);
    cartesInventeesCB.setMaxWidth(250);
    cartesInventeesCB.setStyle(fontParametre);
    
    buttonVB.getChildren().addAll(nouvellePartieBT,reprendrePartieBT);
    buttonVB.setPadding(new Insets(10));
    buttonVB.setAlignment(Pos.CENTER);
    buttonVB.setSpacing(10);
    buttonVB.setStyle("-fx-border-width: 5 0 5 0; -fx-border-color: black;");
    
    nouvellePartieBT.setMinWidth(210);
    nouvellePartieBT.setMaxWidth(210);
    nouvellePartieBT.setPadding(new Insets(5));
    nouvellePartieBT.setTextAlignment(TextAlignment.CENTER);
    nouvellePartieBT.setStyle(fontParametre);
    nouvellePartieBT.setBackground(new Background(fond_arriere1));
    
    reprendrePartieBT.setMinWidth(210);
    reprendrePartieBT.setMaxWidth(210);
    reprendrePartieBT.setPadding(new Insets(5));
    reprendrePartieBT.setDisable(true);
    reprendrePartieBT.setTextAlignment(TextAlignment.CENTER);
    reprendrePartieBT.setStyle(fontParametre);
    reprendrePartieBT.setBackground(new Background(fond_arriere1));
    
    rightMenuVB.getChildren().addAll(playerNbrHB,rolesSP);
    rightMenuVB.setPadding(new Insets(20));
    rightMenuVB.setAlignment(Pos.CENTER);
    rightMenuVB.setSpacing(20);
    VBox.setVgrow(rolesSP, Priority.ALWAYS);
    rightMenuVB.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY,
        new BorderWidths(5),
        new Insets(0)            )));
    rightMenuVB.setBackground(new Background(fond_arriere3));
    
    playerNbrHB.getChildren().addAll(playerNbrLbl,playerNbr);
    playerNbrHB.setAlignment(Pos.CENTER);
    playerNbrHB.setMinWidth(290);
    playerNbrHB.setMaxWidth(290);
    playerNbrHB.setPadding(new Insets(10));
    playerNbrHB.setBackground(new Background(fond_arriere2));
    playerNbrHB.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY,
        new BorderWidths(5),
        new Insets(0)            )));
    
    playerNbrLbl.setMinWidth(225);
    playerNbrLbl.setMaxWidth(225);
    playerNbrLbl.setStyle(fontParametre);
    
    playerNbr.setMinWidth(35);
    playerNbr.setMaxWidth(35);
    playerNbr.setStyle(fontParametre);
    
    for(Label l : rolesLblArray) {
      l.setStyle(fontParametre);
    }
    
    rolesSP.setContent(rolesGrid);
    rolesSP.setFitToWidth(true);
    rolesSP.setBackground(new Background(fond_arriere2));
    rolesSP.setStyle("-fx-background: rgb(96,77,72);");
    rolesSP.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY,
        new BorderWidths(5),
        new Insets(0)            )));
    
    rolesGrid.setAlignment(Pos.CENTER);
    
    primaryStage.setTitle("application LGCreator Application - Menu");
    scene = new Scene(rootMenu);
    primaryStage.setScene(scene);
    primaryStage.setMaximized(true);
    primaryStage.show();
    
    //-------------------------------------------------------------------------
    //Inititalisations du Menu
    //-------------------------------------------------------------------------
    double rolesSBwidth=0.0;
    Set<Node> nodes = rolesSP.lookupAll(".scroll-bar");
    for (final Node node : nodes) {
        if (node instanceof ScrollBar) {
            ScrollBar sb = (ScrollBar) node;
            rolesSBwidth = sb.getWidth();
        }
    }
    int gap = (int)((rolesGrid.getWidth()-rolesSBwidth-6*(rolesIVArray[0].getFitWidth()+10))/5);
    rolesGrid.setHgap(gap);
    rolesGrid.setVgap(gap);
    
    //-------------------------------------------------------------------------
    //Bindings du Menu
    //-------------------------------------------------------------------------
    playerNbr.textProperty().bind(model.playerNbrProp().asString());
    nouvelleLuneRB1.disableProperty().bind(nouvelleLuneCB.selectedProperty().not());
    nouvelleLuneRB2.disableProperty().bind(nouvelleLuneCB.selectedProperty().not());  
    leVillageRB1.disableProperty().bind(leVillageCB.selectedProperty().not());
    leVillageRB2.disableProperty().bind(leVillageCB.selectedProperty().not());
    reprendrePartieBT.disableProperty().bind(model.gameInProgressProp().not());
    
    //-------------------------------------------------------------------------
    //Controleurs sur les mouseEvent
    //-------------------------------------------------------------------------
    jeuDeBaseCB.setOnMouseClicked(mouseEventController);
    nouvelleLuneCB.setOnMouseClicked(mouseEventController);
    leVillageCB.setOnMouseClicked(mouseEventController);
    personnagesCB.setOnMouseClicked(mouseEventController);
    cartesInventeesCB.setOnMouseClicked(mouseEventController);
    nouvellePartieBT.setOnMouseClicked(mouseEventController);
    reprendrePartieBT.setOnMouseClicked(mouseEventController);
    for(index=0;index<LGCreator.NOMBRE_DE_ROLES_TOTAL;index++) {
      rolesIVArray[index].setOnMouseClicked(mouseEventController);
      rolesIVArray[index].setOnMouseEntered(mouseEventController);
      rolesIVArray[index].setOnMouseExited(mouseEventController);
    }
  }
  
  public void setRootForMenuView(Scene scene) {
    scene.setRoot(rootMenu);
  }
}
