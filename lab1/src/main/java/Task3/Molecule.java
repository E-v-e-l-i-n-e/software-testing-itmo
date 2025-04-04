package Task3;

import java.util.List;

public class Molecule {
    private List<Atom> atoms;
    private Double maxTotalWeight;

    public Molecule(List<Atom> atoms, Double maxTotalWeight) {
        if (atoms == null) {
            throw new IllegalArgumentException("Список атомов не может быть null");
        }
        if (atoms.isEmpty()) {
            throw new IllegalArgumentException("Молекула не может быть без атомов");
        }

        if (maxTotalWeight == null || maxTotalWeight.isNaN() || maxTotalWeight == Double.POSITIVE_INFINITY || maxTotalWeight == Double.NEGATIVE_INFINITY) {
            throw new IllegalArgumentException("Максимальный вес молекулы не может быть пустым или равен бесконечности");
        }
        Double moleculeMass = 0.0;
        for (Atom atom : atoms) {
            if (atom == null) {
                throw new IllegalArgumentException("Атом в списке не может быть null");
            }
            moleculeMass += atom.getRelativeAtomicMass();
            if (moleculeMass > maxTotalWeight) {
                throw new IllegalArgumentException("Масса молекулы не может превышать максимальный вес");
            }
        }
        this.atoms = atoms;
    }

    public String getStructure() {
        return "Молекула состоит из " + atoms.size() + " атомов";
    }

    public List<Atom> getAtoms() {
        return atoms;
    }

    public void setAtoms(List<Atom> atoms) {
        this.atoms = atoms;
    }

    public Double getMaxTotalWeight() {
        return maxTotalWeight;
    }
}
