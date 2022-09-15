package com.intellias.lesson16;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public final class Address {
    private String street;
    private String number;

    public Address(String street, String number) {
        this.street = street;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        return number != null ? number.equals(address.number) : address.number == null;
    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}
