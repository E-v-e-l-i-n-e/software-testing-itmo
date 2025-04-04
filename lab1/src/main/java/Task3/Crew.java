package Task3;

import java.util.List;

public class Crew {
    private List<Person> members;
    private Law relationshipLaw;
    private Spaceship spaceship;

    public Crew(List<Person> members, Law relationshipLaw, Spaceship spaceship) {
        if (members == null) {
            throw new IllegalArgumentException("Список членов экипажа не может быть null");
        }
        if (members.isEmpty()) {
            throw new IllegalArgumentException("Экипаж не может быть пустым");
        }
        if (relationshipLaw == null) {
            throw new IllegalArgumentException("Закон не может быть null");
        }
        if (spaceship == null) {
            throw new IllegalArgumentException("Корабль не может быть null");
        }
        this.members = members;
        this.relationshipLaw = relationshipLaw;
        this.spaceship = spaceship;
    }

    public String describeCrewState() {
        long uncomfortableCount = members.stream()
                .filter(p -> p.getWellBeing() == Person.WellBeing.COMFORTLESS)
                .count();
        return "На корабле " + spaceship.getName() + " экипаж из " + members.size() +
                " человек. Неуютно чувствуют себя: " + uncomfortableCount + ". ";
    }

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }

    public Law getRelationshipLaw() {
        return relationshipLaw;
    }

    public void setRelationshipLaw(Law relationshipLaw) {
        this.relationshipLaw = relationshipLaw;
    }

    public Spaceship getSpaceship() {
        return spaceship;
    }

    public void setSpaceship(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

}
