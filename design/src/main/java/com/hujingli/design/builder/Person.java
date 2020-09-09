package com.hujingli.design.builder;

public class Person {

    private String name;

    private int age;

    private Integer height;

    private Integer weight;

    private String sex;

    private Location loc;

    private Person() {

    }

    public static class PersonBuilder{

        Person person = new Person();

        PersonBuilder basic(String name, int age, String sex) {
            person.setName(name);
            person.setAge(age);
            person.setSex(sex);
            return this;
        }

        PersonBuilder height(Integer height) {
            person.setHeight(height);
            return this;
        }

        PersonBuilder width(Integer weight) {
            person.setWeight(weight);
            return this;
        }

        PersonBuilder loc(Location location) {
            person.setLoc(location);
            return this;
        }

        Person build() {
            return person;
        }

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

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", sex='" + sex + '\'' +
                ", loc=" + loc +
                '}';
    }
}

class Location{
    String address;

    String street;

    public Location(String address, String street) {
        this.address = address;
        this.street = street;
    }
}
