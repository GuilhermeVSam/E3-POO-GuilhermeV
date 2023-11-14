package Eventos;

public class Terremoto extends Evento{
    private double magnitude;

    public Terremoto(String codigo, String data, double latitude, double longitude, double magnitude) throws Exception {
        super(codigo, data, latitude, longitude);
        if(magnitude >= 1 && magnitude <= 7) {
            this.magnitude = magnitude;
        } else{
            throw new Exception();
        }
    }

    public double getMagnitude() {
        return magnitude;
    }

    @Override
    public String toString() {
        return "=========================== \n" +
        "Terremoto: \n" + super.toString() + "\n" +
        "Magnitude: " + magnitude;
    }
}
