package application;

import javafx.application.Application;

public class LGCreator { 
  //-------------------------------------------------------------------------
  //Constantes
  //-------------------------------------------------------------------------
  static final int MINIMUM_PAR_ROLE = 0;
  static final int MAXIMUM_PAR_ROLE = 50;
  static final int NOMBRE_DE_ROLES_JEU_DE_BASE = 8;
  static final int NOMBRE_DE_ROLES_NOUVELLE_LUNE = 5;
  static final int NOMBRE_DE_ROLES_LE_VILLAGE = 3;
  static final int NOMBRE_DE_ROLES_PERSONNAGES = 16;
  static final int NOMBRE_DE_ROLES_CARTES_INVENTEES = 6;
  static final int NOMBRE_DE_ROLES_TOTAL_NOUVELLE_LUNE = NOMBRE_DE_ROLES_JEU_DE_BASE 
        + NOMBRE_DE_ROLES_NOUVELLE_LUNE;
  static final int NOMBRE_DE_ROLES_TOTAL_LE_VILLAGE = NOMBRE_DE_ROLES_JEU_DE_BASE 
        + NOMBRE_DE_ROLES_NOUVELLE_LUNE 
        + NOMBRE_DE_ROLES_LE_VILLAGE;
  static final int NOMBRE_DE_ROLES_TOTAL_PERSONNAGES = NOMBRE_DE_ROLES_JEU_DE_BASE 
        + NOMBRE_DE_ROLES_NOUVELLE_LUNE 
        + NOMBRE_DE_ROLES_LE_VILLAGE
        + NOMBRE_DE_ROLES_PERSONNAGES;
  static final int NOMBRE_DE_ROLES_TOTAL = NOMBRE_DE_ROLES_JEU_DE_BASE 
        + NOMBRE_DE_ROLES_NOUVELLE_LUNE 
        + NOMBRE_DE_ROLES_LE_VILLAGE 
        + NOMBRE_DE_ROLES_PERSONNAGES
        + NOMBRE_DE_ROLES_CARTES_INVENTEES;
  public static void main(String[] args) {
    Application.launch(LGCreatorMenuView.class, args);
  }
}
