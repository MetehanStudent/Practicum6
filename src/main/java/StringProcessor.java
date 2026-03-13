import java.util.ArrayList;

    public class StringProcessor {
        private ArrayList<OpmaakProces> processen;

        public StringProcessor() {
            this.processen = new ArrayList<>();
        }

        public void voegProcesToe(OpmaakProces proces) {
            processen.add(proces);
        }

        public String verwerk(String input) {
            String resultaat = input;
            for (OpmaakProces proces : processen) {
                // De uitvoer van het vorige proces is de invoer voor het volgende
                resultaat = proces.maakOp(resultaat);
            }
            return resultaat;
        }
    }