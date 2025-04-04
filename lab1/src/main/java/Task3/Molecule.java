package Task3;

import java.util.List;

public class Molecule {
    private List<Atom> atoms;

    public Molecule(List<Atom> atoms) {
        if (atoms == null) {
            throw new IllegalArgumentException("Список атомов не может быть null");
        }
        if (atoms.isEmpty()) {
            throw new IllegalArgumentException("Молекула не может быть без атомов");
        }
        for (Atom atom : atoms) {
            if (atom == null) {
                throw new IllegalArgumentException("Атом в списке не может быть null");
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
}
