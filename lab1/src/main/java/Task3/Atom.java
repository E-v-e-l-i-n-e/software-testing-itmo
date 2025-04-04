package Task3;

public class Atom {
    private String substance;

    public Atom(String substance) {
        if (substance == null || substance.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Вещество атома не может быть null или пустым");
        }
        this.substance = substance;
    }

    public String getSubstance() {
        return substance;
    }

    public void setSubstance(String substance) {
        this.substance = substance;
    }
}
