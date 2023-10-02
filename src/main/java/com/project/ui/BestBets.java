package com.project.ui;
import java.awt.EventQueue;

/**
 * Class for bets recommendation screen
 * @author Alexandre Paiva
 */
public class BestBets extends javax.swing.JFrame {
    static String[] betsToBeMade;

    /**
     * Finishes the parameter-passing by initializing the attribute betsToBeMade and calls UI components initialization
     * @param bestBetsByNetwork
     */
    public BestBets(String[] bestBetsByNetwork) {
        betsToBeMade = bestBetsByNetwork;
        initComponents();
    }

    /**
     * Initializes the UI components
     */
    private void initComponents() {

        btnReturn = new javax.swing.JButton();
        txtTitle = new javax.swing.JLabel();
        txtSubTitle = new javax.swing.JLabel();
        txtBet = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListBetOptions = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnReturn.setBackground(new java.awt.Color(51, 102, 255));
        btnReturn.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnReturn.setForeground(new java.awt.Color(255, 255, 255));
        btnReturn.setText("Voltar");
        btnReturn.setBorderPainted(false);
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        txtTitle.setFont(new java.awt.Font("Ubuntu Condensed", 1, 60)); // NOI18N
        txtTitle.setText("BetterBet");

        txtSubTitle.setFont(new java.awt.Font("Ubuntu", 2, 24)); // NOI18N
        txtSubTitle.setForeground(new java.awt.Color(51, 102, 255));
        txtSubTitle.setText("a melhor plataforma de apostas");

        txtBet.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtBet.setText("Melhores apostas para você:");

        jListBetOptions.setBackground(new java.awt.Color(237, 237, 237));
        jListBetOptions.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 255), 1, true));
        jListBetOptions.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jListBetOptions.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return betsToBeMade.length; }
            public String getElementAt(int i) { return betsToBeMade[i]; }
        });
        jListBetOptions.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListBetOptions.setAlignmentX(1.0F);
        jListBetOptions.setAlignmentY(1.0F);
        jScrollPane1.setViewportView(jListBetOptions);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(txtTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBet)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnReturn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSubTitle)))
                .addGap(0, 48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSubTitle)
                .addGap(38, 38, 38)
                .addComponent(txtBet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }
    
    
    /**
     * Handles return button click
     * @param evt
     */
    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {       
        this.dispose();                                   
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                InputForm form = new InputForm();
                form.setVisible(true);
            }
        });

    }                                                                  

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BestBets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BestBets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BestBets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BestBets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BestBets bets = new BestBets(betsToBeMade);
                bets.setVisible(true);
            }
        });
    }

    // Variables declaration  
    private javax.swing.JButton btnReturn;
    private javax.swing.JList<String> jListBetOptions;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txtBet;
    private javax.swing.JLabel txtSubTitle;
    private javax.swing.JLabel txtTitle;              
}
