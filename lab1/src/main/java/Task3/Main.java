package Task3;

import Task3.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> crewMembers = Arrays.asList(
                new Person("Олег", 35, Person.Role.CAPTAIN, Person.WellBeing.COMFORTLESS),
                new Person("Вася", 34, Person.Role.NAVIGATOR, Person.WellBeing.COMFORTLESS),
                new Person("Саша", 36, Person.Role.MECHANIC_DRIVER, Person.WellBeing.COMFORTLESS),
                new Person("Петя", 32, Person.Role.SIGNALMAN, Person.WellBeing.COMFORTLESS)
        );

        Spaceship spaceship = new Spaceship("Золотое Сердце", Spaceship.EngineType.PHOTON);
        Law law = new Law("Квантовой связи",
                "отношения между людьми подобны отношениям между молекулами");

        Crew crew = new Crew(crewMembers, law, spaceship);

        List<Atom> atoms = Arrays.asList(
                new Atom("Водород"),
                new Atom("Кислород"),
                new Atom("Водород")
        );
        Molecule water = new Molecule(atoms);

        System.out.println("Корабль: " + spaceship.getName());
        System.out.println(spaceship.getEngineStatus());

        System.out.println(crew.describeCrewState());

        System.out.println(law.explain());

        System.out.println(water.getStructure());
        System.out.println("Как и экипаж корабля, состоящий из " +
                crew.getMembers().size() + " человек");
    }
}