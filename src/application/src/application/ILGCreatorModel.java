package application;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;

public interface ILGCreatorModel {
  
  //----------------------------------------------------------------------------
  BooleanProperty gameInProgressProp();
  boolean isGameInProgress();
  void setGameInProgress(boolean gameInProgress);
  
  //----------------------------------------------------------------------------
  IntegerProperty playerNbrProp();
  int getPlayerNbr();
  void setPlayerNbr(int playerNbr);
}
