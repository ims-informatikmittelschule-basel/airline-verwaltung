public class Crew extends FlugPersonen {

    public Crew(String funktion) {
        this.rolle = funktion;
    }

    @Override
    public String getRolle() {
        return this.rolle;
    }

}
