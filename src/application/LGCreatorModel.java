package application;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class LGCreatorModel implements ILGCreatorModel{
  private BooleanProperty gameInProgressProp = new SimpleBooleanProperty();
  private IntegerProperty playerNbrProp = new SimpleIntegerProperty();
  
  public LGCreatorModel() {
    this(false, LGCreator.MINIMUM_PAR_ROLE);
  }
  public LGCreatorModel(boolean gameInProgress, int playerNbr) {
    setGameInProgress(gameInProgress);
    setPlayerNbr(playerNbr);
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
  
//----------------------------------------------------------------------------
  @Override
  public IntegerProperty playerNbrProp() {
    return playerNbrProp;
  }
  @Override
  public int getPlayerNbr() {
    return playerNbrProp.get();
  }
  @Override
  public void setPlayerNbr(int playerNbr) {
    playerNbrProp.set(playerNbr);
  }
}
