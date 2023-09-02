package com.project.ui;

public class InputForm extends javax.swing.JFrame {

    public InputForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        txtTitle = new javax.swing.JLabel();
        txtSubTitle = new javax.swing.JLabel();
        txtMandante = new javax.swing.JLabel();
        cmbTimeMandante = new javax.swing.JComboBox<>();
        TxtVisitante = new javax.swing.JLabel();
        cmbTimeVisitante = new javax.swing.JComboBox<>();
        txtHora = new javax.swing.JLabel();
        cmbHora = new javax.swing.JComboBox<>();
        txtArriscar = new javax.swing.JLabel();
        sliderRisk = new javax.swing.JSlider();
        btnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));

        txtTitle.setFont(new java.awt.Font("Ubuntu Condensed", 1, 60)); // NOI18N
        txtTitle.setText("BetterBet");

        txtSubTitle.setFont(new java.awt.Font("Ubuntu", 2, 24)); // NOI18N
        txtSubTitle.setForeground(new java.awt.Color(51, 102, 255));
        txtSubTitle.setText("a melhor plataforma de apostas");

        txtMandante.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtMandante.setText("Time mandante");

        cmbTimeMandante.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        cmbTimeMandante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "America-RN", "Athletico-PR", "Atletico-MG", "Avai", "Bahia", "Botafogo-RJ", "Brasiliense", "Corinthians", "Coritiba", "Criciuma", "Cruzeiro", "Figueirense", "Flamengo", "Fluminense", "Fortaleza", "Goias", "Gremio", "Guarani", "Internacional", "Ipatinga", "Juventude", "Nautico", "Palmeiras", "Parana", "Paysandu", "Ponte Preta", "Portuguesa", "Santa Cruz", "Santos", "Sao Caetano", "Sao Paulo", "Sport", "Vasco", "Vitoria" }));
        cmbTimeMandante.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbTimeMandante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTimeMandanteActionPerformed(evt);
            }
        });

        TxtVisitante.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        TxtVisitante.setText("Time visitante");

        cmbTimeVisitante.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        cmbTimeVisitante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "America-RN", "Athletico-PR", "Atletico-MG", "Avai", "Bahia", "Botafogo-RJ", "Brasiliense", "Corinthians", "Coritiba", "Criciuma", "Cruzeiro", "Figueirense", "Flamengo", "Fluminense", "Fortaleza", "Goias", "Gremio", "Guarani", "Internacional", "Ipatinga", "Juventude", "Nautico", "Palmeiras", "Parana", "Paysandu", "Ponte Preta", "Portuguesa", "Santa Cruz", "Santos", "Sao Caetano", "Sao Paulo", "Sport", "Vasco", "Vitoria" }));
        cmbTimeVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTimeVisitanteActionPerformed(evt);
            }
        });

        txtHora.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtHora.setText("Hora");

        cmbHora.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        cmbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30" }));
        cmbHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHoraActionPerformed(evt);
            }
        });

        txtArriscar.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtArriscar.setText("Arriscar");

        sliderRisk.setForeground(new java.awt.Color(51, 102, 255));
        sliderRisk.setValue(85);

        btnEnviar.setBackground(new java.awt.Color(51, 102, 255));
        btnEnviar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setText("Enviar");
        btnEnviar.setBorderPainted(false);
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtTitle)
                        .addGap(109, 109, 109))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMandante)
                            .addComponent(cmbTimeMandante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtVisitante)
                            .addComponent(cmbTimeVisitante, 0, 368, Short.MAX_VALUE)
                            .addComponent(txtHora)
                            .addComponent(cmbHora, 0, 368, Short.MAX_VALUE)
                            .addComponent(txtArriscar)
                            .addComponent(sliderRisk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34))))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(txtSubTitle))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEnviar)
                .addGap(169, 169, 169))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSubTitle)
                .addGap(38, 38, 38)
                .addComponent(txtMandante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTimeMandante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtVisitante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTimeVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtArriscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderRisk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void cmbTimeMandanteActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        String timeMandanteSelecionado = cmbTimeMandante.getSelectedItem().toString();
    }                                               

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        // Limpar os campos
        
    }                                         

    private void cmbTimeVisitanteActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void cmbHoraActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InputForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel TxtVisitante;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox<String> cmbHora;
    private javax.swing.JComboBox<String> cmbTimeMandante;
    private javax.swing.JComboBox<String> cmbTimeVisitante;
    private javax.swing.JSlider sliderRisk;
    private javax.swing.JLabel txtArriscar;
    private javax.swing.JLabel txtHora;
    private javax.swing.JLabel txtMandante;
    private javax.swing.JLabel txtSubTitle;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration                   
}
