import javax.swing.*;

public class Janela extends JFrame {
    private GuiForm form;

    public Janela(){
        super();
        form = new GuiForm();
        this.add(form.getPainel());
        this.setTitle("Cadastro de Eventos");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
