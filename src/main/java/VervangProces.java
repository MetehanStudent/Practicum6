public class VervangProces implements OpmaakProces {
    private String oud;
    private String nieuw;

    public VervangProces(String oud, String nieuw) {
        this.oud = oud;
        this.nieuw = nieuw;
    }

    @Override
    public String maakOp(String input) {
        if (input == null) return null;
        return input.replace(oud, nieuw);
    }
}