package Entities;

public class Celular implements Precedable<Celular> {

    private Persona usuario;

    private int numero;

    public Celular(Persona usuario, int numero) {
        this.usuario = usuario;
        this.numero = numero;
    }

    public Persona getUsuario() {
        return usuario;
    }

    public void setUsuario(Persona usuario) {
        this.usuario = usuario;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int precedeA(Celular celular) {
        return this.numero - celular.getNumero();
    }

    @Override
    public String toString() {
        return "Celular{" +
                "usuario=" + usuario +
                ", numero=" + numero +
                '}';
    }
}
