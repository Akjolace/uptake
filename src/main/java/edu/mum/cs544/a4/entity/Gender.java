package edu.mum.cs544.a4.entity;

public enum Gender {
    MALE("Male"), FEMALE("Female"), OTHER("Other");

    private final String displayValue;

    private Gender(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
