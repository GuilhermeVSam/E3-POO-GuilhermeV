package Eventos;

public abstract class Evento {
    private String codigo;
    private String data;
    private double latitude;
    private double longitude;

    public Evento(String codigo, String data, double latitude, double longitude) {
        this.codigo = codigo;
        this.data = data;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getData() {
        return data;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return  "Codigo: " + codigo + "\n" +
                "Data: " + data + "\n" +
                "Latitude: " + latitude + "\n" +
                "Longitude: " + longitude;
    }
}