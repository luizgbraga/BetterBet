package com.project.ui;

import java.io.IOException;
import java.util.HashMap;
import java.awt.EventQueue;
import com.project.data.CollectData;
import com.project.util.TimeConverter;
import com.project.data.ProcessData;
import com.project.network.Network;
import com.project.util.Matrix;

import tech.tablesaw.api.Table;

/**
 * Class for user's input
 * @author Alexandre Paiva
 */
public class InputForm extends javax.swing.JFrame {

    /**
     * Calls UI components initialization
     */
    public InputForm() {
        initComponents();
    }
     
    /**
     * Initializes the UI components
     */
    private void initComponents() {

        txtTitle = new javax.swing.JLabel();
        txtSubTitle = new javax.swing.JLabel();
        txtHomeClubName = new javax.swing.JLabel();
        cmbHomeClubName = new javax.swing.JComboBox<>();
        txtVisitorClubName = new javax.swing.JLabel();
        cmbVisitorClubName = new javax.swing.JComboBox<>();
        txtMatchTime = new javax.swing.JLabel();
        cmbMatchTime = new javax.swing.JComboBox<>();
        txtRound = new javax.swing.JLabel();
        cmbRound = new javax.swing.JComboBox<>();
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

        txtHomeClubName.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtHomeClubName.setText("Time mandante");

        cmbHomeClubName.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        cmbHomeClubName.setModel(new javax.swing.DefaultComboBoxModel<>(CollectData.getAllTeams()));
        cmbHomeClubName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtVisitorClubName.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtVisitorClubName.setText("Time visitante");

        cmbVisitorClubName.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        cmbVisitorClubName.setModel(new javax.swing.DefaultComboBoxModel<>(CollectData.getAllTeams()));

        txtMatchTime.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtMatchTime.setText("Hora");

        cmbMatchTime.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        cmbMatchTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30" }));

        txtRound.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtRound.setText("Rodada");

        cmbRound.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        cmbRound.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38" }));

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
                            .addComponent(txtHomeClubName)
                            .addComponent(cmbHomeClubName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtVisitorClubName)
                            .addComponent(cmbVisitorClubName, 0, 368, Short.MAX_VALUE)
                            .addComponent(txtMatchTime)
                            .addComponent(cmbMatchTime, 0, 368, Short.MAX_VALUE)
                            .addComponent(txtRound)
                            .addComponent(cmbRound, 0, 368, Short.MAX_VALUE)
                            .addComponent(txtArriscar)
                            .addComponent(sliderRisk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34))))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(txtSubTitle))
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(btnEnviar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSubTitle)
                .addGap(38, 38, 38)
                .addComponent(txtHomeClubName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbHomeClubName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtVisitorClubName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbVisitorClubName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMatchTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbMatchTime, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtRound)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbRound, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtArriscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderRisk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }                                                                 

    /**
     * Handles form submit
     * @param evt
     */
    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {  
        // Reads all input values into variables                                        
        String homeClubName = cmbHomeClubName.getSelectedItem().toString();
        String visitorClubName = cmbVisitorClubName.getSelectedItem().toString();
        String selectedHour = cmbMatchTime.getSelectedItem().toString();
        String selectedRound = cmbRound.getSelectedItem().toString();
        int selectedRisk = sliderRisk.getValue();

        // Converts String names into Ids
        CollectData.updateClubId();
        HashMap<String, Integer> ids = CollectData.clubId;
        int homeClubId = ids.get(homeClubName);
        int visitorClubId = ids.get(visitorClubName);

        // Formats other variables for network understanding
        double hour = TimeConverter.timeToFraction(selectedHour);
        double round = (double)Integer.parseInt(selectedRound)/38.0;
        double risk = (double)selectedRisk/150.0;
                
        // Generates sizes array
        HashMap<String, Table> tables = CollectData.generateTrainingAndTestData();
        int[] sizes = { 
            tables.get("trainingDataInput").columnCount() - 1, 
            60, 
            tables.get("trainingDataOutput").columnCount() - 1 
        };

        // Network's input formatted
        Matrix input = ProcessData.formatInputData(homeClubId, visitorClubId, hour, round);
		Network nn;

        try {
            nn = new Network(sizes, "network_params.csv");
            Matrix output = nn.feedForward(input);
            output = Matrix.round(output, risk);
            this.dispose();
            String[] parameters = ProcessData.outputToArray(output);
            EventQueue.invokeLater(new Runnable(){
                public void run(){
                    BestBets bets = new BestBets(parameters);
                    bets.setVisible(true);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Clean fields
        cmbHomeClubName.setSelectedIndex(0);
        cmbVisitorClubName.setSelectedIndex(0);
        cmbMatchTime.setSelectedIndex(0);
        cmbRound.setSelectedIndex(0);
        
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
            java.util.logging.Logger.getLogger(InputForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        // Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputForm().setVisible(true);
            }
        });
    }

    // Variables declaration                    
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox<String> cmbHomeClubName;
    private javax.swing.JComboBox<String> cmbMatchTime;
    private javax.swing.JComboBox<String> cmbVisitorClubName;
    private javax.swing.JComboBox<String> cmbRound;
    private javax.swing.JSlider sliderRisk;
    private javax.swing.JLabel txtArriscar;
    private javax.swing.JLabel txtRound;
    private javax.swing.JLabel txtHomeClubName;
    private javax.swing.JLabel txtMatchTime;
    private javax.swing.JLabel txtSubTitle;
    private javax.swing.JLabel txtTitle;
    private javax.swing.JLabel txtVisitorClubName;                 
}
