# Variables :
JCFLAGS = -encoding UTF-8 -implicit:none

# Règles obligatoires :
Jeu.class: Jeu.java MaFenetre.class MaMatrice.class
	javac ${JCFLAGS} Jeu.java

MaMatrice.class: MaMatrice.java ObjetGrille.class MouseOver.class MaFenetre.class 
	javac ${JCFLAGS} MaMatrice.java

MaFenetre.class: MaFenetre.java 
	javac ${JCFLAGS} MaFenetre.java

MouseOver.class: MouseOver.java ObjetGrille.class AlgoVoisin.class
	javac ${JCFLAGS} MouseOver.java

ObjetGrille.class: ObjetGrille.java
	javac ${JCFLAGS} ObjetGrille.java

AlgoVoisin.class: AlgoVoisin.java
	javac ${JCFLAGS} AlgoVoisin.java
	
# Règles optionnelles :
run:
	java Jeu

clean:
	rm *.class