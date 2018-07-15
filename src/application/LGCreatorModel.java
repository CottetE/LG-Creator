package application;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class LGCreatorModel implements ILGCreatorModel{
  private BooleanProperty gameInProgressProp = new SimpleBooleanProperty();
  
  public LGCreatorModel() {
    this(false);
  }
  public LGCreatorModel(boolean gameInProgress) {
    setGameInProgress(gameInProgress);
  }
  
  //----------------------------------------------------------------------------
  @Override
  public BooleanProperty gameInProgressProp() {
    return gameInProgressProp;
  }
  @Override
  public boolean isGameInProgress() {
    return gameInProgressProp.get();
  }
  @Override
  public void setGameInProgress(boolean gameInProgress) {
    gameInProgressProp.set(gameInProgress);
  }
}
