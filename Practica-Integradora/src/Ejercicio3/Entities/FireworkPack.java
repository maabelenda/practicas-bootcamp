package Ejercicio3.Entities;

import Ejercicio3.Exceptions.ErrorException;
import Ejercicio3.Utils.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FireworkPack extends Firework{

    List<Firework> fireworks;

    public FireworkPack(long id) {
        super(id);
        this.fireworks = new ArrayList<>();
    }

    public List<Firework> getFireworks() {
        return fireworks;
    }

    public void addFirework(Firework firework) throws ErrorException {
        if(Objects.isNull(firework) || this.equals(firework)) {
            throw new ErrorException(ErrorMessage.BAD_ARGUMENTS.getMessage(), ErrorMessage.BAD_ARGUMENTS.getCode());
        }
        fireworks.add(firework);
    }

    @Override
    public void exploit() {
        fireworks.forEach((f) -> f.exploit());
    }
}
