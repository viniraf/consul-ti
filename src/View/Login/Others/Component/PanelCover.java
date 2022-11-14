
package View.Login.Others.Component;

import View.Login.Others.CustomSwing.ButtonOutLine;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author vinic
 */
public class PanelCover extends javax.swing.JPanel {

    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private ActionListener event;
    private MigLayout layout;
    private JLabel title;
    private JLabel description;
    private JLabel description1;
    private JLabel exit;
    private ButtonOutLine buttonExit;
    private ButtonOutLine button;
    private boolean isLogin;
    

    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]25[]10[]25[]push");
        setLayout(layout);
        init();
    }
    
    private void init() {
        //exit = new JLabel("Sair do sistema");
        //exit.setIcon(new ImageIcon(getClass().getResource("/Resources/icons/close.png")));
        //exit.setForeground(new Color(245, 245, 245));
        //exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //add(exit);
        buttonExit = new ButtonOutLine();
        buttonExit.setBackground(new Color (255, 255, 255));
        buttonExit.setForeground(new Color(255, 255, 255));
        buttonExit.setText("SAIR DO SISTEMA");
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                System.exit(0);
            }
        });
        
        add(buttonExit, "w 60%, h 40");
        title = new JLabel("Bem vindo de volta!");
        title.setFont(new Font ("sansserif", 1, 30));
        title.setForeground(new Color(245, 245, 245));
        add(title);
        
    
        description = new JLabel("Se você já possui uma conta");
        description.setForeground(new Color(245, 245, 245));
        add(description);
        description1 = new JLabel("Clique para ir para a página de login");
        description1.setForeground(new Color(245, 245, 245));
        add(description1);
        button = new ButtonOutLine();
        button.setBackground(new Color (255, 255, 255));
        button.setForeground(new Color(255, 255, 255));
        button.setText("PÁGINA LOGIN");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event.actionPerformed(e);
            }
        });
        add(button, "w 60%, h 40");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gra = new GradientPaint(0, 0, new Color (69, 183, 233), 0, getHeight(), new Color(27, 148, 201) );
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g); 
    }
    
    public void addEvent(ActionListener event){
        this.event = event;
    }
    
    public void registerLeft(double value){
        value = Double.valueOf(df.format(value));
        login(false);
        layout.setComponentConstraints(title, "pad 0 -" + value + "% 0 0");
        layout.setComponentConstraints(description, "pad 0 -" + value + "% 0 0");
        layout.setComponentConstraints(description1, "pad 0 -" + value + "% 0 0");
    }
    
    public void registerRight(double value){
        value = Double.valueOf(df.format(value));
        login(false);
        layout.setComponentConstraints(title, "pad 0 -" + value + "% 0 0");
        layout.setComponentConstraints(description, "pad 0 -" + value + "% 0 0");
        layout.setComponentConstraints(description1, "pad 0 -" + value + "% 0 0");
    }
    
    public void loginLeft(double value){
        value = Double.valueOf(df.format(value));
        login(true);
        layout.setComponentConstraints(title, "pad 0 " + value + "% 0 " + value + "%");
        layout.setComponentConstraints(description, "pad 0 " + value + "% 0 " + value + "%");
        layout.setComponentConstraints(description1, "pad 0 " + value + "% 0 " + value + "%");
        
    }
    
    public void loginRight(double value){
        value = Double.valueOf(df.format(value));
        login(true);
        layout.setComponentConstraints(title, "pad 0 " + value + "% 0 " + value + "%");
        layout.setComponentConstraints(description, "pad 0 " + value + "% 0 " + value + "%");
        layout.setComponentConstraints(description1, "pad 0 " + value + "% 0 " + value + "%");
    }
    
    
    public void login(boolean login){   
        if (this.isLogin != login){
            if(login){
                title.setText("Seja bem vindo!");
                description.setText("Se você não possui uma conta");
                description1.setText("Clique para ir para a págna de cadastro");
                button.setText("Página de cadastro");
            } else {
                title.setText("Bem vindo de volta!");
                description.setText("Se você já possui uma conta");
                description1.setText("Clique para ir para a página de login");
                button.setText("Página de login");
            }
            this.isLogin = login;
        }
    }

    
    

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
