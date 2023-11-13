import javax.swing.*;

public class Janela extends JFrame {
    private GuiForm form;

    public Janela(){
        super();
        form = new GuiForm();
        this.add(form.getPainel());
        this.setSize(256, 512);
        this.setTitle("Janela");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
