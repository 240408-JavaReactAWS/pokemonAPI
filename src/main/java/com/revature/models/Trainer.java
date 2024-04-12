package com.revature.models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "trainers")
public class Trainer {
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private int age;

    @Column
    private String region;

    public Trainer() {
    }

    public Trainer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Trainer(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Trainer(int id, String name, int age, String region) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.region = region;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return id == trainer.id
                && Objects.equals(name, trainer.name)
                && Objects.equals(age, trainer.age)
                && Objects.equals(region, trainer.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, region);
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
