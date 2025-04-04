import Task3.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Task3Test {

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
            new Atom("Водород", 2.0),
            new Atom("Кислород", 16.0),
            new Atom("Водород", 2.0)
    );

    Molecule water = new Molecule(atoms, 100.0);

    @Test
    @DisplayName("testSpaceshipCreation")
    void testSpaceshipCreation() {
        assertEquals("Золотое Сердце", spaceship.getName());
        assertEquals(Spaceship.EngineType.PHOTON, spaceship.getType());
        assertEquals(spaceship.getEngineStatus(), "Двигатель фотоновый. ");
    }

    @Test
    @DisplayName("testSpaceshipCreationWrong")
    void testSpaceshipCreationWrong() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Spaceship("     ", Spaceship.EngineType.PHOTON),
                "Название корабля не может быть пустым"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new Spaceship("Золотое Сердце", null),
                "Тип двигателя не может быть null"
        );
    }

    @Test
    @DisplayName("atomTest")
    void atomCreation() {
        Atom atom = new Atom("Водород", 2.0);
        assertEquals("Водород", atom.getSubstance());
        assertThrows(IllegalArgumentException.class,
                () -> new Atom(null, 2.0),
                "Вещество атома не может быть null");

        assertThrows(IllegalArgumentException.class,
                () -> new Atom("", 2.0),
                "Вещество атома не может быть пустым");
        assertThrows(IllegalArgumentException.class,
                () -> new Atom("   ", 2.0),
                "Вещество атома не может быть пустым");
    }



    @Test
    @DisplayName("moleculeTest")
    void moleculeCreation() {
        assertEquals(3, water.getAtoms().size());
        assertThrows(IllegalArgumentException.class,
                () -> new Molecule(null, 2.0),
                "Список атомов не может быть null");

        assertThrows(IllegalArgumentException.class,
                () -> new Molecule(Collections.emptyList(), 100.0),
                "Молекула не может быть без атомов");

        List<Atom> atoms = Arrays.asList(
                new Atom("Водород", 2.0),
                null,
                new Atom("Кислород", 16.0));

        assertThrows(IllegalArgumentException.class,
                () -> new Molecule(atoms, 100.0),
                "Атом в списке не может быть null");


        List<Atom> atom = Arrays.asList(
                new Atom("Углерод", 32.0),
                new Atom("Кислород", 16.0)
        );
        Molecule molecule = new Molecule(atom, 100.0);
        assertEquals("Молекула состоит из 2 атомов", molecule.getStructure());

        List<Atom> exactWeightAtoms = new ArrayList<>();
        exactWeightAtoms.add(new Atom("Fe", 100.0));

        assertDoesNotThrow(() -> new Molecule(exactWeightAtoms, 100.0));

        exactWeightAtoms.add(new Atom("Fe", 10.0));
        assertThrows(IllegalArgumentException.class,
                () -> new Molecule(exactWeightAtoms, 100.0),
                "Масса молекулы не может превышать максимальный вес");

        List<Atom> slightlyHeavyAtoms = List.of(new Atom("Fe", 100.01));
        assertThrows(IllegalArgumentException.class,
                () -> new Molecule(slightlyHeavyAtoms, 100.0),
                "Масса молекулы не может превышать максимальный вес");

        assertThrows(IllegalArgumentException.class,
                () -> new Molecule(atoms, null),
                "Максимальный вес молекулы не может быть пустым или равен бесконечности");

        assertThrows(IllegalArgumentException.class,
                () -> new Molecule(atoms, Double.POSITIVE_INFINITY),
                "Максимальный вес молекулы не может быть пустям или или равен бесконечности");
    }



    @Test
    @DisplayName("lawTest")
    void lawCreation() {
        assertEquals("Квантовой связи", law.getName());
        assertEquals("отношения между людьми подобны отношениям между молекулами", law.getDescription());
        assertEquals("Закон Квантовой связи: отношения между людьми подобны отношениям между молекулами", law.explain());

        assertThrows(IllegalArgumentException.class,
                () -> new Law(null, "Описание"),
                "Название закона не может быть null");

        assertThrows(IllegalArgumentException.class,
                () -> new Law("", "Описание"),
                "Название закона не может быть пустым");

        assertThrows(IllegalArgumentException.class,
                () -> new Law("Физика", null),
                "Описание закона не может быть null");
    }


    @Test
    @DisplayName("personTest")
    void personTest() {
        Person person = new Person("Иван", 30, Person.Role.CAPTAIN, Person.WellBeing.COSY);

        assertEquals("Иван", person.getName());
        assertEquals(30, person.getAge());
        assertEquals(Person.Role.CAPTAIN, person.getRole());
        assertEquals(Person.WellBeing.COSY, person.getWellBeing());

        assertThrows(IllegalArgumentException.class,
                () -> new Person(null, 30, Person.Role.CAPTAIN, Person.WellBeing.COSY),
                "Имя не может быть null");

        assertThrows(IllegalArgumentException.class,
                () -> new Person("", 30, Person.Role.CAPTAIN, Person.WellBeing.COSY),
                "Имя не может быть пустым");

        assertThrows(IllegalArgumentException.class,
                () -> new Person("    ", 30, Person.Role.CAPTAIN, Person.WellBeing.COSY),
                "Имя не может состоять из пробелов");

        assertThrows(IllegalArgumentException.class,
                () -> new Person("Иван", -5, Person.Role.CAPTAIN, Person.WellBeing.COSY),
                "Возраст не может быть меньше 18");
        assertThrows(IllegalArgumentException.class,
                () -> new Person("Иван", 500, Person.Role.CAPTAIN, Person.WellBeing.COSY),
                "Возраст не может быть больше 110");

        assertThrows(NullPointerException.class,
                () -> new Person("Иван", 25, null, Person.WellBeing.COSY),
                "Роль не может быть null");

        assertThrows(NullPointerException.class,
                () -> new Person("Иван", 25, Person.Role.CAPTAIN, null),
                "Состояние не может быть null");
    }




    @Test
    @DisplayName("crewTest")
    void crewTest() {
        Crew crew = new Crew(crewMembers, law, spaceship);
        assertEquals(4, crew.getMembers().size());
        assertEquals("Квантовой связи", crew.getRelationshipLaw().getName());
        assertEquals("Золотое Сердце", crew.getSpaceship().getName());

        assertEquals("На корабле Золотое Сердце экипаж из 4 человек. Неуютно чувствуют себя: 4. ",
                crew.describeCrewState());

        assertThrows(IllegalArgumentException.class,
                () -> new Crew(null, law, spaceship),
                "Список членов экипажа не может быть null");

        assertThrows(IllegalArgumentException.class,
                () -> new Crew(List.of(), law, spaceship),
                "Экипаж не может быть пустым");

        assertThrows(IllegalArgumentException.class,
                () -> new Crew(crewMembers, null, spaceship),
                "Закон не может быть null");

        assertThrows(IllegalArgumentException.class,
                () -> new Crew(crewMembers, law, null),
                "Корабль не может быть null");
    }
}

