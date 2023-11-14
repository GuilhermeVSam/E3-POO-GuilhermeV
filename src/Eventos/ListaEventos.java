package Eventos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaEventos {
    class sortName implements Comparator<Evento> {
        public int compare(Evento a, Evento b) {
            return a.getCodigo().compareTo(b.getCodigo());
        }
    }
    private ArrayList<Evento> eventos;

    public ListaEventos(){
        eventos = new ArrayList<>();
    }

    public boolean addEvento(Evento evento) {
        for (Evento e : eventos) {
            if (e.getCodigo().equals(evento.getCodigo())) {
                return false;
            }
        }
        eventos.add(evento);
        Collections.sort(eventos, new sortName());
        return true;
    }

    @Override
    public String toString() {
        String evento = "";
        for (Evento e: eventos) {
            evento += e + "\n";
        }
        return evento;
    }
}
