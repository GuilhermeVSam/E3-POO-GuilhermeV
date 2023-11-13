import Eventos.*;

public class App {
    private ListaEventos listaEventos;

    public App(){
        listaEventos = new ListaEventos();
    }

    public void addEvento(Evento e) throws Exception {
        Exception InvalidCode = new Exception("Código Inválido");
        if(!listaEventos.addEvento(e)) throw InvalidCode;
    }

    public String listar(){
        return listaEventos.toString();
    }
}
