public class CensuurProces implements OpmaakProces {
    private String teCensureren;

    public CensuurProces(String woord) {
        this.teCensureren = woord;
    }

    @Override
    public String maakOp(String input) {
        // Maak een string van sterretjes die even lang is als het woord
        String sterretjes = "*".repeat(teCensureren.length());
        return input.replace(teCensureren, sterretjes);
    }
}