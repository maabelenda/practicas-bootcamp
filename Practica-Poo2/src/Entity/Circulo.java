package Entity;

public class Circulo extends FiguraGeometrica {

    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(this.radio,2);
    }

    @Override
    public String toString() {
        return "Circulo: { area: " + this.area() + ", radio: " + this.radio + " }";
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
}