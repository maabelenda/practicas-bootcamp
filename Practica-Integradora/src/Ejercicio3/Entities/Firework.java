package Ejercicio3.Entities;

import java.util.Objects;

public abstract class Firework {

    private long id;

    public Firework(long id) {
        this.id = id;
    }

    public abstract void exploit();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Firework firework = (Firework) o;
        return this.id == firework.id;
    }

}
