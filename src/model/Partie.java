package model;

import exceptions.IllegalDeplacementException;
import exceptions.IllegalPositionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represente une Partie que deux joueurs jouent
 */
public class Partie {

    public Plateau plateau;
    public List<Joueur> listeJoueurs;

    // utiliser pour recevoir les inputs de l'utilisateur
    public Scanner scanner = new Scanner(System.in);


    public Partie(int taillePlateau) {
        if(taillePlateau < 3) { // on ne veut pas de plateau plus petit que 3
            throw new IllegalArgumentException("La taille du Plateau doit etre superieur ou egal à 3");
        }
        plateau = new Plateau(taillePlateau);

        Joueur joueur1 = new Joueur('X'); // cree le joueur 1
        Joueur joueur2 = new Joueur('O'); // cree le joueur 2

        listeJoueurs = new ArrayList<>();
        listeJoueurs.add(joueur1); // ajoute jouer 1 a la liste de jouer
        listeJoueurs.add(joueur2); // ajoute jouer 2 a la liste de jouer
    }

    /**
     * Chaque joueur a son tour pose un pion sur le plateau
     */
    public void jouer()  {

        do {   //commence a jouer
            for (Joueur joueur : listeJoueurs) { // parcourt la liste de joueurs et fait jouer chacun a son tour
                boolean error; // si erreur survient on la met a vrai(true)
                do{ //boucle si le joueur engendre une erreur, il est amener a se corriger
                    try {
                        error = false;
                        aQuiLeTour(joueur); //au joueur i de la liste
                        int[] position = deplacement(); // recoit les inputs du joueur
                        joueur.placePion(this, position[0], position[1]); // joueur 1 place son pion
                    } catch (IllegalPositionException | IllegalDeplacementException ip) {
                        error = true; // une erreur est survenu
                        System.out.println(ip.getMessage()); // afficher son message
                    }
                } while (error); // recommencer en cas d'erreur

                afficheTableauActuel();  // affiche l'etat actuel du tableau

                if(checkNul()) {// verifie un match nul
                    return; // si oui stop le jeu
                }
                if(checkVainqueur()) {// verifie une victoire
                    return;  // si oui stop le jeu
                }
            }
        } while(!matchNul() && !victoire()); //chaque joueur a effectuer un tour, repeter un notre
        // tour s'il n'y pas de gagnant ou pas de match nul
        checkVainqueur(); //verifie si la partie est terminée sur une victoire
        checkNul(); //verifie si la partie est terminée sur un match nul

    }

    /**
     * verifie et affiche si la partie est terminée sur une victoire
     * @return true si la partie est terminée sur une victoire
     *         false sinon
     */
    public boolean checkVainqueur() {
        if(victoire()) {
            System.out.println("***************VICTOIRE***************");
            System.out.println("Bravo - le " + annonceVainqueur() + " a gagné la partie.");
            System.out.println();
            System.out.println();
            afficheTableauActuel(); // affiche l'etat actuel du tableau
            System.out.println("Fin du jeu");
            scanner.close();;
            return true;
        }
        return false;
    }

    /**
     * verifie et affiche si la partie est terminée sur un match nul
     * @return true si la partie est terminée sur un match nul
     */
    public boolean checkNul() {
        if(matchNul()) {
            System.out.println("*****MATCH NUL********");
            afficheTableauActuel();
            System.out.println("Fin du jeu");
            scanner.close();;
            return true;
        }
        return  false;
    }

    /**
     * affiche l'etat actuel du tableau
     */
    public void afficheTableauActuel() {
        System.out.println("*********Tableau actuel*************\n");
        System.out.println(plateau.toString());
    }

    /**
     * Annonce lequel des deux joueurs a gagné
     * @return lequel des deux jouerus a gagné en string
     */
    public String annonceVainqueur() {
        String vainqueur = "Partie en cours";
        if(plateau.typeDePionAligne == 'X') {
            vainqueur = "Joueur 1";
        } else if(plateau.typeDePionAligne == 'O'){
            vainqueur = "Joueur 2";
        }
        return vainqueur;
    }

    /**
     * Precise quel joueur s'apprete a jouer
     * @param joueur joueur qui veut jouer actuellement
     */
    public void aQuiLeTour(Joueur joueur) {
        String joueurS = "Joueur";
        if(joueur.pionType == 'X') {
            joueurS = "Joueur 1";
        } else if(joueur.pionType == 'O') {
            joueurS = "Joueur 2";
        }
        System.out.println(""+ joueurS +" a vous ... ");
    }

    /**
     * demande  et accepte la position que
     * joueur veut donner pour placer son pion
     * @return dans un array les positions representant
     * la ligne et la colonne ou le pion doit etre placé
     */
    public int[] deplacement() {
        int x = plateau.taille - 1;
        System.out.println("Entrer la position où vous voulez placer votre pion ... ");
        System.out.println("Ligne et colonne (De 0 à "+ x +") separer par un espace");
        System.out.flush();
        boolean error; // rebelotte, en cas d'erreur on le met a true
        int row = -1;
        int col = -1;
        do {
            try {
                error = false;
                String position = scanner.nextLine(); // attends les entrées de l'utilisateur dans un string

                String[] strings = position.split("\\s"); // decoupe le string a chaqu'espace, et conserve tous
                // les strings resultants dans l'array strings

                if(strings.length != 2) { // si on a pas exactement 2 mots(representant notre position ligne, colonne), alors il ya erreur
                    throw new IllegalPositionException("La position entrée n'est pas valide"); // alors il ya erreur
                } else {
                    row = Integer.parseInt(strings[0]); // transforme le string en nombre,
                    if(!(row >= 0 && row < plateau.taille)) { // au cas ou la ligne donnée n'est pas correcte
                        throw new IllegalPositionException("La ligne entrée n'est pas valide"); // cree une erreur
                    }
                    col = Integer.parseInt(strings[1]); // transforme le string en nombre,
                    if(!(col >= 0 && col < plateau.taille)) { // au cas ou la colonne donnée n'est pas correcte
                        throw new IllegalPositionException("La colonne entrée n'est pas valide"); // cree une erreur
                    }
                }
            } catch (Exception ip) { // arrete chaque erreur et affiche son message
                error = true; // une erreur est survenu
                System.out.println(ip.getMessage());
                System.out.println("Entrer à nouveau Ligne et colonne (De 0 à "+ x +") separer par un espace");
            }
        } while (error); // recommence en cas d'erreur
        return new int[]{row, col}; // quand tout se deroule bien renvoi les positions entrées par l'utilisateur
    }

    /**
     * teste si il y a une victoire
     * @return true si le jeu est terminé et il ya un gagnant
     */
    public boolean victoire() {
        //teste l'alignement sur les diagonales
        if(plateau.pionsAlignésDiagonalementGauche() || plateau.pionsAlignésDiagonalementDroite()) {
            return true;
        }
        //teste l'alignement sur toutes les lignes
        boolean b;
        for(int i = 0; i < plateau.taille; i++) {
            b = plateau.pionsAlignerHorizontalementSurUneLigne(i);
            if(b) { // si les memes pions sont alignés sur une ligne
                return true;
            }
        }
        boolean b1;
        for(int j = 0; j < plateau.taille; j++) {
            b1 = plateau.pionsAlignerVerticalementSurUneColonne(j);
            if(b1) {// si les memes pions sont alignés sur colonne
                return true;
            }
        }
        return false;
    }

    /**
     * teste si le jeu est terminé et personne n'a gagné
     * @return true le jeu est terminé et personne n'a gagné
     */
    public boolean matchNul() {
        if(!victoire()){ // s'il ny pas de victoire
            for (int x = 0; x < plateau.taille; x++) {
                for (int y = 0; y < plateau.taille; y++) {
                    if(plateau.tableau[x][y] == null) { // si la case ne contient aucun pion
                        return false;
                    }
                }
            }
            return true; // s'il n y a pas de victoire et que toutes les case contiennent un pion
        }
        return false; //sinon pas de match nul
    }

    /**
     * verifie si Le mouvement a effectué est  legal
     * @param row  ligne ou se trouve le pion a deplacé
     * @param col colonne ou se trouve le pion a deplacé
     * @return true si le deplacement est permis
     *         sinon il cree une exception IllegalPositionException
     *         si la ligne ou la colonne n'est pas valide
     *         et plutot IllegalDeplacementException si la case st occupé
     */
    public boolean mouvementLegal(int row, int col){
        if(row <  0 || row >= plateau.tableau.length ) { // la ligne n'est pas correct
            throw  new IllegalPositionException("La ligne  entrer n'est pas valide");
        } else if (col <  0 || col>= plateau.tableau.length ) { // la colonne n'est pas correct
            throw  new IllegalPositionException("La Colonne  entrer n'est pas valide");
        } else if(plateau.tableau[row][col] != null) { // case occupé
            throw  new IllegalDeplacementException("La Case est déja occupé");
        }
        return true; //s'il n'y a pas d'erreur(Exceptions)
    }
}
