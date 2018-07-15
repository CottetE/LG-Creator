package application;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class LGCreatorMouseEventController implements EventHandler<MouseEvent>{
  private LGCreatorMenuView view;
  private LGCreatorModel model;
  private CheckBox cb;
  private Button bt;
  private ImageView iv;
    
  public LGCreatorMouseEventController(LGCreatorMenuView view, LGCreatorModel model) {
    this.view = view;
    this.model = model;
  }
  @Override
  public void handle(MouseEvent event) {
    //-------------------------------------------------------------------------
    //Controleurs sur les checkBoxs
    //-------------------------------------------------------------------------
    if(event.getSource() instanceof CheckBox){
      cb = (CheckBox)(event.getSource());
      if(cb.equals(view.jeuDeBaseCB)) {
        emptyGrid();
        fillGrid();
      }
      if(cb.equals(view.nouvelleLuneCB)) {
        emptyGrid();
        fillGrid();
        if(cb.isSelected()) {
          view.nouvelleLuneRB1.setSelected(true);
        }
        else{
          view.nouvelleLuneRB1.setSelected(false);
          view.nouvelleLuneRB2.setSelected(false);
        }
      }
      if(cb.equals(view.leVillageCB)) {
        emptyGrid();
        fillGrid();
        if(cb.isSelected()) {
          view.leVillageRB1.setSelected(true);
        }
        else{
          view.leVillageRB1.setSelected(false);
          view.leVillageRB2.setSelected(false);
        }
      }
      if(cb.equals(view.personnagesCB)) {
        emptyGrid();
        fillGrid();
      }
      if(cb.equals(view.cartesInventeesCB)) {
        emptyGrid();
        fillGrid();
      }
    }
    //-------------------------------------------------------------------------
    //Controleurs sur les Buttons
    //-------------------------------------------------------------------------
    if(event.getSource() instanceof Button){
      bt = (Button)(event.getSource());
      if(bt.equals(view.nouvellePartieBT)) {
        view.gameView.setRootForGameView(view.primaryStage,view);
        model.setGameInProgress(true);
      }
      if(bt.equals(view.reprendrePartieBT)) {
        view.gameView.setRootForGameView(view.primaryStage,view);
      }
    }
    //-------------------------------------------------------------------------
    //Controleurs sur les images
    //-------------------------------------------------------------------------
    if(event.getSource() instanceof ImageView){
      iv = (ImageView)(event.getSource());
      Label lbl = view.rolesNbrLblArray[Integer.valueOf(iv.getId())];
      if (event.getButton() == MouseButton.SECONDARY) {
        if(!lbl.getText().equals("" + LGCreator.MINIMUM_PAR_ROLE)) {
          lbl.setText(String.valueOf(Integer.valueOf(lbl.getText())-1));
          model.setPlayerNbr(model.getPlayerNbr()-1);
        }
      }
      if (event.getButton() == MouseButton.PRIMARY) {
        if(!lbl.getText().equals("" + LGCreator.MAXIMUM_PAR_ROLE)) {
          lbl.setText(String.valueOf(Integer.valueOf(lbl.getText())+1));
          model.setPlayerNbr(model.getPlayerNbr()+1);
        }
      }
      if (MouseEvent.MOUSE_ENTERED == event.getEventType()) {
        view.scene.setCursor(Cursor.HAND);
      }
      if (MouseEvent.MOUSE_EXITED == event.getEventType()) {
        view.scene.setCursor(Cursor.DEFAULT);
      }
    }
  }
  
  /**
   * Vide la grille
   */
  private void emptyGrid() {
    for(int i=0;i<LGCreator.NOMBRE_DE_ROLES_TOTAL;i++) {
      if(!view.rolesGrid.getChildren().isEmpty()) {
        view.rolesGrid.getChildren().remove(0);
      }
    }
  }
  
  /**
   * Remplit la grille dans l'ordre des extensions selon les cases à cocher.
   */
  private void fillGrid() {
    int gridIndex = 0;
    for(int i=0;i<LGCreator.NOMBRE_DE_ROLES_TOTAL;i++) {
      if(view.jeuDeBaseCB.isSelected() && i<LGCreator.NOMBRE_DE_ROLES_JEU_DE_BASE) {
        view.rolesGrid.add(view.rolesVBArray[i],gridIndex%6,gridIndex/6,1,1);
        gridIndex++;
      }
      if(view.nouvelleLuneCB.isSelected() && i>=LGCreator.NOMBRE_DE_ROLES_JEU_DE_BASE && i<LGCreator.NOMBRE_DE_ROLES_TOTAL_NOUVELLE_LUNE) {
        view.rolesGrid.add(view.rolesVBArray[i],gridIndex%6,gridIndex/6,1,1);
        gridIndex++;
      }
      if(view.leVillageCB.isSelected() && i>=LGCreator.NOMBRE_DE_ROLES_TOTAL_NOUVELLE_LUNE && i<LGCreator.NOMBRE_DE_ROLES_TOTAL_LE_VILLAGE) {
        view.rolesGrid.add(view.rolesVBArray[i],gridIndex%6,gridIndex/6,1,1);
        gridIndex++;
      }
      if(view.personnagesCB.isSelected() && i>=LGCreator.NOMBRE_DE_ROLES_TOTAL_LE_VILLAGE && i<LGCreator.NOMBRE_DE_ROLES_TOTAL_PERSONNAGES) {
        view.rolesGrid.add(view.rolesVBArray[i],gridIndex%6,gridIndex/6,1,1);
        gridIndex++;
      }
      if(view.cartesInventeesCB.isSelected() && i>=LGCreator.NOMBRE_DE_ROLES_TOTAL_PERSONNAGES && i<LGCreator.NOMBRE_DE_ROLES_TOTAL) {
        view.rolesGrid.add(view.rolesVBArray[i],gridIndex%6,gridIndex/6,1,1);
        gridIndex++;
      }
    }
  }
}
