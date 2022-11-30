package View.Login;

import Connection.MySQL;
import Entities.Employee;
import Entities.LoginModel;
import Entities.User;
import View.CustomMenu.MainMenu;
import View.Menu;
import View.Login.Others.Component.PanelCover;
import View.Login.Others.Component.PanelLoginAndRegister;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author vinic
 */
public class Login extends javax.swing.JFrame {
    
    User newUser = new User();
    LoginModel userAut = new LoginModel();
    MySQL conectar = new MySQL();
    

    private MigLayout layout;
    private PanelCover cover;
    private PanelLoginAndRegister loginAndRegister;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 40;
    private  final double loginSize = 60;
    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private Component Login;

    public Login() {
        initComponents();
        init();
    }

    
    private void init(){
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        ActionListener eventRegister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              register();
            }
        };
        ActionListener eventLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        };
        
        loginAndRegister = new PanelLoginAndRegister(eventRegister, eventLogin);
        TimingTarget target = new TimingTargetAdapter(){  
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                
                if(fraction <= 0.5f){
                    size += fraction * addSize;
                } else {
                    size += addSize - fraction * addSize;
                }
                
               if (isLogin){
                   fractionCover = 1f - fraction;
                   fractionLogin = fraction;
                   if(fraction >= 0.5f){
                       cover.registerRight(fractionCover * 100);
                   } else {
                       cover.loginRight(fractionLogin * 100);
                   }
                   
               } else {
                   fractionCover = fraction;
                   fractionLogin = 1f - fraction;
                   if(fraction <= 0.5f){
                       cover.registerLeft(fraction * 100 );
                   } else {
                       cover.loginLeft((1f - fraction) * 100);
                   }
               }
               
               if(fraction >= 0.5f){
                   loginAndRegister.showRegister(isLogin);
               }
               fractionCover = Double.valueOf(df.format(fractionCover));
               fractionLogin = Double.valueOf(df.format(fractionLogin));
               layout.setComponentConstraints(cover, "width " + size +  "%, pos " + fractionCover + "al 0 n 100%");
               layout.setComponentConstraints(loginAndRegister, "width " + loginSize +  "%, pos " + fractionLogin + "al 0 n 100%");
                       
               bg.revalidate();
            }

            @Override
            public void end() {
                 isLogin =  !isLogin;
            }
            
            
        };
        
        Animator animator = new Animator (800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0); // Para animação suave 
        bg.setLayout(layout);
        bg.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        bg.add(loginAndRegister, "width " + loginSize + "%, pos 1al 0 n 100%");
        cover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!animator.isRunning()){
                    animator.start();
                }
            }
        });
    }
    
    public void register(){
        User user = loginAndRegister.getUser();
        
        this.conectar.conectaBanco();
        
        newUser.setLogin(user.getLogin());
        newUser.setPassword(user.getPassword());

        try {
            this.conectar.insertSQL("INSERT INTO user ("
                    + "login,"
                    + "password"
                + ") VALUES ("
                    + "'" + newUser.getLogin()+ "',"
                    + "'" + newUser.getPassword() + "'"
                + ");");
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Operação realizada", JOptionPane.INFORMATION_MESSAGE);
            
            
        } catch (Exception e) {
            System.out.println("Erro ao Cadastrar Usuário: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Usuário!", "Operação não realizada", JOptionPane.ERROR_MESSAGE);
        } finally {
            this.conectar.fechaBanco();
        }
        

        
        
        
        //System.out.println(user.getLogin());
        //JOptionPane.showMessageDialog(null, "Beleza ta funcionando", "Caixa de dialogo de teste", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public boolean aut () throws SQLException {
        // inicio sql
        
        LoginModel data = loginAndRegister.getDataLogin();
        
        this.conectar.conectaBanco();
        
        userAut.setLogin(data.getLogin());
        userAut.setPassword(data.getPassword());
        
        
        
        this.conectar.executarSQL(
            "SELECT * "
            + " FROM"
            + " user"
          + " WHERE"
            + " login = '" + userAut.getLogin() + "'" + " and password = '" + userAut.getPassword() + "';"
            );
            return this.conectar.getResultSet().next(); 
        
        
        // Fim sql
    }
    
    public void login() {

        try {
            boolean operation = aut();
            
            if(operation){
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);
                this.dispose();
                System.out.println("Usuario encontrado. Redirecionando para menu principal");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos. Digite novamente");
                System.out.println("Usuario nao encontrado. Tente novamente.");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1011, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
