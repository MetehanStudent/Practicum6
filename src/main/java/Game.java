import java.time.LocalDate;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwPrijs;

    public Game(String nm, int rJ, double nwpr) { // Parameter namen uit UML: nm, rJ, nwpr
        this.naam = nm;
        this.releaseJaar = rJ;
        this.nieuwPrijs = nwpr;
    }

    public String getNaam() { // Toegevoegd uit UML
        return naam;
    }

    public double huidigeWaarde() {
        int huidigeJaar = LocalDate.now().getYear();
        int jarenVerlopen = huidigeJaar - releaseJaar;
        double waarde = nieuwPrijs * Math.pow(0.7, jarenVerlopen);
        return waarde;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Game) {
            Game otherGame = (Game) obj;
            return this.naam.equals(otherGame.naam) && this.releaseJaar == otherGame.releaseJaar;
        }
        return false;
    }

    @Override
    public String toString() {
        // Gebruik de komma en puntkomma precies zoals in het voorbeeld
        return String.format("%s, uitgegeven in %d; nieuwprijs: €%.2f nu voor: €%.2f",
                naam, releaseJaar, nieuwPrijs, huidigeWaarde());
    }
}