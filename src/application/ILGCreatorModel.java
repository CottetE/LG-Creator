package application;

import javafx.beans.property.BooleanProperty;

public interface ILGCreatorModel {
  
  //----------------------------------------------------------------------------
  BooleanProperty gameInProgressProp();
  boolean isGameInProgress();
  void setGameInProgress(boolean gameInProgress);
}
