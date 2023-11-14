import Eventos.Ciclone;
import Eventos.Seca;
import Eventos.Terremoto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JTextArea Log;
    private JButton Finalizar;
    private JButton limpar;
    private JButton Listar;
    private App app;

    public GuiForm() {
        app = new App();
        Log.setLineWrap(true);
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
                try {
                    switch (STRtipo) {
                        case "Ciclone" -> {
                            String STRvelocidade = Velocidade.getText();
                            double velocidade = Double.parseDouble(STRvelocidade);
                            String STRprecipitacao = Precipitacao.getText();
                            double precipitacao = Double.parseDouble(STRprecipitacao);

                            Ciclone evento = new Ciclone(codigo, data, latitude, longitude, velocidade, precipitacao);
                            app.addEvento(evento);
                        }
                        case "Terremoto" -> {
                            String STRmagnitude = Magnitude.getText();
                            int magnitude = Integer.parseInt(STRmagnitude);

                            Terremoto evento = new Terremoto(codigo, data, latitude, longitude, magnitude);
                            app.addEvento(evento);
                        }
                        case "Seca" -> {
                            String STRestiagem = Estiagem.getText();
                            int estiagem = Integer.parseInt(STRestiagem);
                            Seca evento = new Seca(codigo, data, latitude, longitude, estiagem);
                            app.addEvento(evento);
                        }
                    }
                    Log.append("Evento Cadastrado \n");
                    clear();
                } catch(Exception InvalidCode){
                    JOptionPane.showMessageDialog(null, "Código Inválido");
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
        limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        Listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Log.append(app.listar());
            }
        });
        Finalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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

    public void clear(){
        Log.setText("");
        Codigo.setText("");
        Data.setText("");
        Latitude.setText("");
        Longitude.setText("");
        Velocidade.setText("");
        Precipitacao.setText("");
        Magnitude.setText("");
        Estiagem.setText("");
    }

    public JPanel getPainel(){
        return Painel;
    }
}
