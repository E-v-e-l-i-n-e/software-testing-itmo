package Task3;

public class Spaceship {

    String name;
    EngineType type;

    public enum EngineType {
        PHOTON,
        PETROL,
        DIESEL
    }

    public Spaceship(String name, EngineType type) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название корабля не может быть пустым");
        }
        if (type == null) {
            throw new IllegalArgumentException("Тип двигателя не может быть null");
        }
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EngineType getType() {
        return type;
    }

    public void setType(EngineType type) {
        this.type = type;
    }

    public String getEngineStatus() {
        String engineType;
        if (this.type == EngineType.PHOTON) {
            engineType = "фотоновый";
        } else if (this.type == EngineType.DIESEL) {
            engineType = "дизельный";
        } else {
            engineType = "бензиновый";
        }
        return "Двигатель " + engineType + ". ";
    }
}
