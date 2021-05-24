package org.launchcode.techjobs_oo;

import java.util.Objects;

public class PositionType extends JobField {

    public PositionType() {

        super();

    }

    public PositionType(String value) {

        super(value);

    }

    // TODO: Add a custom toString() method that returns the data stored in 'value'.



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionType position = (PositionType) o;
        return this.getId() == position.getId();
    }
}
