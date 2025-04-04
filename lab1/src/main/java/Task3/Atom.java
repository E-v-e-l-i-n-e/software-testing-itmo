package Task3;

public class Atom {
    private String substance;
    private Double relativeAtomicMass;

    public Atom(String substance, Double relativeAtomicMass) {
        if (substance == null || substance.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Вещество атома не может быть null или пустым");
        }

        if (relativeAtomicMass == null) {
            throw new IllegalArgumentException(
                    "Относительная атомная масса не может быть null");
        }
        if (relativeAtomicMass <= 0) {
            throw new IllegalArgumentException(
                    "Относительная атомная масса не может быть меньше 0");
        }

        this.substance = substance;
        this.relativeAtomicMass = relativeAtomicMass;
    }

    public Double getRelativeAtomicMass() {
        return relativeAtomicMass;
    }

    public void setRelativeAtomicMass(Double relativeAtomicMass) {
        this.relativeAtomicMass = relativeAtomicMass;
    }

    public String getSubstance() {
        return substance;
    }

    public void setSubstance(String substance) {
        this.substance = substance;
    }
}
