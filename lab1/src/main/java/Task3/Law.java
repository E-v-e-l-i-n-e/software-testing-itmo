package Task3;

public class Law {
    private String name;
    private String description;

    public Law(String name, String description) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название закона не может быть null или пустым");
        }
        if (description == null) {
            throw new IllegalArgumentException("Описание закона не может быть null");
        }
        this.name = name;
        this.description = description;
    }

    public String explain() {
        return "Закон " + name + ": " + description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
