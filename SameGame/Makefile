# Variables :
JCFLAGS = -encoding UTF-8 -implicit:none

# Règles obligatoires :
# Règles du menu 
Menu.class: Menu.java  PanelScore.class Fenetre.class FenetreFin.class  MonPanelTitre.class MonPanelMap.class
	javac ${JCFLAGS} Menu.java

Fenetre.class: MonPanelTitre.class MonPanelMap.class
	javac ${JCFLAGS} Fenetre.java

FenetreFin.class: FenetreFin.java PanelScore.class PanelJeu.class Menu.class
	javac ${JCFLAGS} FenetreFin.java

MaFenetreJeu.class: MaFenetreJeu.java PanelJeu.class PanelScore.class
	javac ${JCFLAGS} MaFenetreJeu.java

TitreListener.class: TitreListener.java MonPanelTitre.class
	javac ${JCFLAGS} TitreListener.java

MonPanelTitre.class: MonPanelTitre.java TitreListener.class
	javac ${JCFLAGS} MonPanelTitre.java

MonPanelMap.class: MonPanelMap.java SourisInterractionDefinie.class SourisInterractionAleatoire.class ImageMap.class ConfigMap.class
	javac ${JCFLAGS} MonPanelMap.java

SourisInterractionDefinie.class: SourisInterractionDefinie.java ImageMap.class ConfigMap.class MaMatrice.class Fenetre.class MaFenetreJeu.class PanelJeu.class PanelScore.class
	javac ${JCFLAGS} SourisInterractionDefinie.java

SourisInterractionAleatoire.class: SourisInterractionAleatoire.java ImageMap.class ConfigMap.class MaMatrice.class Fenetre.class MaFenetreJeu.class PanelJeu.class PanelScore.class
	javac ${JCFLAGS} SourisInterractionAleatoire.java

ImageMap.class: ImageMap.java
	javac ${JCFLAGS} ImageMap.java

ConfigMap.class: ConfigMap.java
	javac ${JCFLAGS} ConfigMap.java

# Règles du Jeu
MaMatrice.class: MaMatrice.java ObjetGrille.class MouseInteraction.class PanelJeu.class PanelScore.class
	javac ${JCFLAGS} MaMatrice.java

PanelJeu.class: PanelJeu.java 
	javac ${JCFLAGS} PanelJeu.java

PanelScore.class: PanelScore.java 
	javac ${JCFLAGS} PanelScore.java

MouseInteraction.class: MouseInteraction.java ObjetGrille.class AlgoJeu.class PanelScore.class FenetreFin.class
	javac ${JCFLAGS} MouseInteraction.java

AlgoJeu.class: AlgoJeu.java ObjetGrille.class
	javac ${JCFLAGS} AlgoJeu.java

ObjetGrille.class: ObjetGrille.java
	javac ${JCFLAGS} ObjetGrille.java

# Règles optionnelles :
run:
	java Menu

clean:
	rm *.class