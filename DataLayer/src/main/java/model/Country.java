package model;

public class Country extends Entity {
    private int id;
    private String name;
    private String code;
    private String nationality;
    public Country() {
    }

    public Country(int id, String name, String code, String nationality) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.nationality = nationality;
    }

    //region Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    //endregion


    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
