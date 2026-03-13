public class HoofdletterProces implements OpmaakProces {
    public HoofdletterProces() { }

    @Override
    public String maakOp(String input) {
        if (input == null) return null;
        return input.toUpperCase();
    }
}