package Task3;

public class Person {
    String name;
    int age;
    Role role;
    WellBeing wellBeing;

    public Person(String name, int age, Role role, WellBeing wellBeing) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть null или пустым");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (age > 110) {
            throw new IllegalArgumentException("Возраст не может быть больше 110");
        }
        if (role == null) {
            throw new NullPointerException("Роль не может быть null");
        }
        if (wellBeing == null) {
            throw new NullPointerException("Состояние не может быть null");
        }
            this.name = name;
        this.age = age;
        this.role = role;
        this.wellBeing = wellBeing;
    }

    public enum WellBeing {
        COSY,
        COMFORTLESS
    }

    public enum Role {
        CAPTAIN,
        NAVIGATOR,
        MECHANIC_DRIVER,
        SIGNALMAN
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public WellBeing getWellBeing() {
        return wellBeing;
    }

    public void setWellBeing(WellBeing wellBeing) {
        this.wellBeing = wellBeing;
    }
}
