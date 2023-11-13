import Eventos.Ciclone;
import Eventos.Seca;
import Eventos.Terremoto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class GuiForm {
    private JPanel Painel;
    private JPanel Botao;
    private JPanel CenterMain;
    private JPanel InN;
    private JPanel InC;
    private JButton Cadastrar;
    private JTextField Codigo;
    private JComboBox tipoDeEventoComboBox;
    private JTextField Data;
    private JTextField Latitude;
    private JTextField Longitude;
    private JTextField Velocidade;
    private JTextField Precipitacao;
    private JTextField Estiagem;
    private JTextField Magnitude;

    public GuiForm() {
        selecionaTipo();
        Cadastrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = Codigo.getText();
                String data = Data.getText();
                String STRlatitude = Latitude.getText();
                double latitude = Double.parseDouble(STRlatitude);
                String STRlongitude = Longitude.getText();
                double longitude = Double.parseDouble(STRlongitude);
                String STRtipo = tipoDeEventoComboBox.getSelectedItem().toString();
                switch (STRtipo) {
                    case "Ciclone" -> {
                        String STRvelocidade = Velocidade.getText();
                        double velocidade = Double.parseDouble(STRvelocidade);
                        String STRprecipitacao = Precipitacao.getText();
                        double precipitacao = Double.parseDouble(STRprecipitacao);

                        Ciclone c = new Ciclone(codigo, data, latitude, longitude, velocidade, precipitacao);
                    }
                    case "Terremoto" -> {
                        String STRmagnitude = Magnitude.getText();
                        int magnitude = Integer.parseInt(STRmagnitude);

                        Terremoto t = new Terremoto(codigo, data, latitude, longitude, magnitude);
                    }
                    case "Seca" -> {
                        String STRestiagem = Estiagem.getText();
                        int estiagem = Integer.parseInt(STRestiagem);
                        Seca s = new Seca(codigo, data, latitude, longitude, estiagem);
                    }
                }
            }
        });
        tipoDeEventoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                Magnitude.setEnabled(false);
                Velocidade.setEnabled(false);
                Precipitacao.setEnabled(false);
                Estiagem.setEnabled(false);

                String tipo = comboBox.getSelectedItem().toString();
                switch (tipo) {
                    case "Ciclone" -> {
                        Velocidade.setEnabled(true);
                        Precipitacao.setEnabled(true);
                    }
                    case "Terremoto" -> Magnitude.setEnabled(true);
                    case "Seca" -> Estiagem.setEnabled(true);
                }
            }
        });
    }

    private void selecionaTipo(){
        DefaultComboBoxModel<String> tipoEvento = new DefaultComboBoxModel<>();
        tipoEvento.addElement("Tipo de Evento");
        tipoEvento.addElement("Terremoto");
        tipoEvento.addElement("Ciclone");
        tipoEvento.addElement("Seca");
        tipoDeEventoComboBox.setModel(tipoEvento);
    }

    public JPanel getPainel(){
        return Painel;
    }
}
