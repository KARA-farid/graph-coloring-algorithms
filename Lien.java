package Graphe;

public class Lien {
    private Sommet source, destination;

    public Lien(Sommet source, Sommet destination) {
        this.source = source;
        this.destination = destination;
    }

    public Sommet getSource() {
        return source;
    }

    public Sommet getDestination() {
        return destination;
    }
}
