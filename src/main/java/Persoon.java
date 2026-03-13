import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames; // Naam aangepast naar UML-standaard

    public Persoon(String nm, double bud) {
        this.naam = nm;
        this.budget = bud;
        this.mijnGames = new ArrayList<>();
    }

    public double getBudget() { // Toegevoegd uit UML
        return budget;
    }

    public boolean koop(Game g) {
        double prijs = g.huidigeWaarde();
        if (budget >= prijs && !mijnGames.contains(g)) {
            budget -= prijs;
            mijnGames.add(g);
            return true;
        }
        return false;
    }

    public boolean verkoop(Game g, Persoon koper) {
        if (mijnGames.contains(g) && !koper.mijnGames.contains(g) && koper.budget >= g.huidigeWaarde()) {
            this.mijnGames.remove(g);
            koper.mijnGames.add(g);
            double prijs = g.huidigeWaarde();
            koper.budget -= prijs;
            this.budget += prijs;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = String.format("%s heeft een budget van €%.2f en bezit de volgende games:", naam, budget);
        for (Game g : mijnGames) {
            s += "\n" + g.toString();
        }
        return s;
    }

    public Game zoekGameOpNaam(String naam) {
        for (Game g : mijnGames) {
            if (g.getNaam().equals(naam)) {
                return g;
            }
        }
        return null; // Niets gevonden
    }

    public ArrayList<Game> bepaalGamesNietInBezit(ArrayList<Game> teKoop) {
        ArrayList<Game> resultaat = new ArrayList<>();
        for (Game g : teKoop) {
            if (!mijnGames.contains(g)) {
                resultaat.add(g);
            }
        }
        return resultaat;
    }
}