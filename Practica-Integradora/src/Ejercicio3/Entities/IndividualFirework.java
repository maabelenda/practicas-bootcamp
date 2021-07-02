package Ejercicio3.Entities;


import Ejercicio3.Entities.Interfaces.FireworkSound;

public class IndividualFirework extends Firework {

    FireworkSound fireworkSound;

    public IndividualFirework(long id, FireworkSound fireworkSound) {
        super(id);
        this.fireworkSound = fireworkSound;
    }

    @Override
    public void exploit() {
        fireworkSound.explosionSound();
    }

    public FireworkSound getFireworkSound() {
        return fireworkSound;
    }

    public void setFireworkSound(FireworkSound fireworkSound) {
        this.fireworkSound = fireworkSound;
    }
}
