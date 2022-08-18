package model;

import java.sql.Date;
import java.util.List;

public class User extends Entity {
    private int id;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String profileDescription;
    private String address;
    private Date birthDate;
    private Country birthplace;
    private Country nationality;
    private List<UserSkill> skills;

    public User(int id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }
    public User(String name, String surname, String email,
                String phone, String password){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
    public User(int id, String password, String name, String surname, String email,
                String phone, String profileDescription, String address,
                Date birthDate, Country birthplace, Country nationality) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.profileDescription = profileDescription;
        this.address = address;
        this.birthDate = birthDate;
        this.birthplace = birthplace;
        this.nationality = nationality;
        this.password = password;
    }

    public User() {

    }

    //region Getters and Setters
    public String getPassword(){ return password;}
    public void setPassword(String password){ this.password = password;}
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Country getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(Country birthplace) {
        this.birthplace = birthplace;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public List<UserSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<UserSkill> skills) {
        this.skills = skills;
    }
    //endregion


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", profileDescription='" + profileDescription + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", birthplace=" + birthplace +
                ", nationality=" + nationality +
                ", skills=" + skills +
                '}';
    }
}
