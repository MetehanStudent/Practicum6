public class UitgeverijApp {
    public static void main(String[] args) {
        StringProcessor processor = new StringProcessor();

        // Voeg de standaard processen toe
        processor.voegProcesToe(new VervangProces("hij", "hij/zij"));
        processor.voegProcesToe(new HoofdletterProces());

        // Voeg je EIGEN proces toe (bijv. censureer het woord 'STAGE')
        processor.voegProcesToe(new CensuurProces("STAGE"));

        String inputString = "Een student loopt meestal in het derde jaar stage. Dan moet hij zelf een stageplek vinden.";
        String result = processor.verwerk(inputString);

        System.out.println(result);
    }
}