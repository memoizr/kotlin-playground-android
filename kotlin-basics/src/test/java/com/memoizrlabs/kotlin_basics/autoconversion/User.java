package com.memoizrlabs.kotlin_basics.autoconversion;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public final class User {

    @NotNull
    private final String firstName;
    @NotNull
    private final String lastName;
    @NotNull
    private final String middleName;
    private final int age;
    private final int height;
    private final int weight;
    @Nullable
    private final User father;
    @Nullable
    private final User mother;
    @NotNull
    private final List<User> siblings = new ArrayList<>();

    public User(
            @NotNull String firstName,
            @NotNull String lastName,
            @NotNull String middleName,
            int age,
            int height,
            int weight,
            @Nullable User father,
            @Nullable User mother,
            @NotNull List<User> siblings) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.father = father;
        this.mother = mother;
        this.siblings.addAll(siblings);
    }

    @NotNull
    public User withFirstName(@NotNull String firstName) {
        return new User(firstName,
                lastName,
                middleName,
                age,
                height,
                weight,
                father,
                mother,
                siblings);
    }

    @NotNull
    public User withLastName(@NotNull String lastName) {
        return new User(firstName,
                lastName,
                middleName,
                age,
                height,
                weight,
                father,
                mother,
                siblings);
    }

    @NotNull
    public User withMiddleName(@NotNull String middleName) {
        return new User(firstName,
                lastName,
                middleName,
                age,
                height,
                weight,
                father,
                mother,
                siblings);
    }

    @NotNull
    public User withAge(int age) {
        return new User(firstName,
                lastName,
                middleName,
                age,
                weight,
                height,
                father,
                mother,
                siblings);
    }

    @NotNull
    public User withHeight(int height) {
        return new User(firstName,
                lastName,
                middleName,
                age,
                weight,
                height,
                father,
                mother,
                siblings);
    }

    @NotNull
    public User withWeight(int weight) {
        return new User(firstName,
                lastName,
                middleName,
                age,
                height,
                weight,
                father,
                mother,
                siblings);
    }

    @NotNull
    public User withFather(@NotNull User father) {
        return new User(firstName,
                lastName,
                middleName,
                age,
                height,
                weight,
                father,
                mother,
                siblings);
    }

    @NotNull
    public User withMother(@NotNull User mother) {
        return new User(firstName,
                lastName,
                middleName,
                age,
                height,
                weight,
                father,
                mother,
                siblings);
    }

    @NotNull
    public User withSiblings(@NotNull List<User> sibilings) {
        return new User(firstName,
                lastName,
                middleName,
                age,
                height,
                weight,
                father,
                mother,
                sibilings);
    }

    @NotNull
    public String getFirstName() {
        return firstName;
    }

    @NotNull
    public String getLastName() {
        return lastName;
    }

    @NotNull
    public String getMiddleName() {
        return middleName;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    @Nullable
    public User getFather() {
        return father;
    }

    @Nullable
    public User getMother() {
        return mother;
    }

    @NotNull
    public List<User> getSiblings() {
        List<User> safeCopy = new ArrayList<>();
        safeCopy.addAll(siblings);
        return siblings;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", father=" + father +
                ", mother=" + mother +
                ", weight=" + height +
                ", siblings=" + siblings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;

        if (getAge() != user.getAge()) {
            return false;
        }
        if (getHeight() != user.getHeight()) {
            return false;
        }
        if (getWeight() != user.getWeight()) {
            return false;
        }
        if (getFirstName() != null ? !getFirstName().equals(user.getFirstName()) : user.getFirstName() != null) {
            return false;
        }
        if (getLastName() != null ? !getLastName().equals(user.getLastName()) : user.getLastName() != null) {
            return false;
        }
        if (getMiddleName() != null ? !getMiddleName().equals(user.getMiddleName()) : user.getFirstName() != null) {
            return false;
        }
        if (getFather() != null ? !getFather().equals(user.getFather()) : user.getFather() != null) {
            return false;
        }
        if (getMother() != null ? !getMother().equals(user.getMother()) : user.getMother() != null) {
            return false;
        }
        if (getSiblings() != null ? !getSiblings().equals(user.getSiblings()) : user.getSiblings() != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getMiddleName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getMiddleName() != null ? getMiddleName().hashCode() : 0);
        result = 31 * result + getAge();
        result = 31 * result + getHeight();
        result = 31 * result + getWeight();
        result = 31 * result + (getFather() != null ? getFather().hashCode() : 0);
        result = 31 * result + (getMother() != null ? getMother().hashCode() : 0);
        result = 31 * result + (getSiblings() != null ? getSiblings().hashCode() : 0);
        return result;
    }
}
