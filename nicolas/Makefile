# Variables :
JCFLAGS = -encoding UTF-8 -implicit:none

# Règles obligatoires :
Jeu.class: Jeu.java MaFenetre.class MaMatrice.class PanelJeu.class PanelScore.class
	javac ${JCFLAGS} Jeu.java

MaMatrice.class: MaMatrice.java ObjetGrille.class MouseInteraction.class PanelJeu.class PanelScore.class
	javac ${JCFLAGS} MaMatrice.java

MaFenetre.class: MaFenetre.java 
	javac ${JCFLAGS} MaFenetre.java

PanelJeu.class: PanelJeu.java 
	javac ${JCFLAGS} PanelJeu.java

PanelScore.class: PanelScore.java 
	javac ${JCFLAGS} PanelScore.java

MouseInteraction.class: MouseInteraction.java ObjetGrille.class AlgoJeu.class PanelScore.class
	javac ${JCFLAGS} MouseInteraction.java

AlgoJeu.class: AlgoJeu.java ObjetGrille.class
	javac ${JCFLAGS} AlgoJeu.java

ObjetGrille.class: ObjetGrille.java
	javac ${JCFLAGS} ObjetGrille.java

# Règles optionnelles :
run:
	java Jeu

clean:
	rm *.class