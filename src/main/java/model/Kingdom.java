package model;

public enum Kingdom {
    LAND("LAND", "PANDA"),
    WATER("WATER", "OCTOPUS"),
    ICE("ICE", "MAMMOTH"),
    AIR("AIR","OWL"),
    FIRE("FIRE","DRAGON");

    private String name;
    private String animal;

    Kingdom(String name, String animal) {
        this.name = name;
        this.animal = animal;
    }

    public String getAnimal() {
        return this.animal;
    }

    public String getName() {
        return this.name;
    }
}
