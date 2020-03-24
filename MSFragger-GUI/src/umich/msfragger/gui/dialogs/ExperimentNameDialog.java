/*
 * Copyright 2018 Dmitry Avtonomov.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package umich.msfragger.gui.dialogs;

import com.github.chhh.utils.StringUtils;
import com.github.chhh.utils.swing.DocumentFilters;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Dmitry Avtonomov
 */
public class ExperimentNameDialog extends javax.swing.JDialog {
  private static final Logger log = LoggerFactory.getLogger(ExperimentNameDialog.class);
    private final List<String> files;
    private boolean isOk;

    /**
     * Creates new form ExperimentNameDialog
     */
    public ExperimentNameDialog(java.awt.Frame parent, boolean modal, List<String> files, String defaultExp, Integer defaultRep) {
        super(parent, modal);
        this.files = files;
        this.isOk = false;
        initComponents();
        initMore(defaultExp, defaultRep);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(parent);
        this.setTitle("Experiment");
    }

    public ExperimentNameDialog(java.awt.Frame parent, boolean modal, List<String> files) {
        this(parent, modal, files, null, null);
    }

    private void initMore(String defaultExp, Integer defaultRep) {
        if (!StringUtils.isNullOrWhitespace(defaultExp)) {
            textExperimentName.setText(defaultExp);
        }
        if (defaultRep != null) {
            textReplicateNumber.setText(defaultRep.toString());
        }
    }

    public List<String> getFiles() {
        return files;
    }

    public boolean isOk() {
        return isOk;
    }

    public String getExperimentName() {
        return textExperimentName.getText().trim();
    }

    public Integer getReplicateNumber() {
      String text = textReplicateNumber.getText();
      if (StringUtils.isNullOrWhitespace(text)) {
        return null;
      }
      try {
        return Integer.parseInt(text);
      } catch (Exception e) {
        log.error("Could not parse replicate number", e);
        return null;
      }
    }

    private ListModel createModel() {
        DefaultListModel<String> m = new DefaultListModel<>();
        for (String file : files) {
            m.addElement(file);
        }
        return m;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    textExperimentName = new javax.swing.JTextField();
    btnCance = new javax.swing.JButton();
    btnAssign = new javax.swing.JButton();
    scrollFiles = new javax.swing.JScrollPane();
    listFiles = new javax.swing.JList<>();
    jLabel2 = new javax.swing.JLabel();
    textReplicateNumber = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setLocationByPlatform(true);
    setModal(true);
    setPreferredSize(new java.awt.Dimension(500, 300));

    jLabel1.setText("Experiment name:");

    btnCance.setText("Cancel");
    btnCance.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCanceActionPerformed(evt);
      }
    });

    btnAssign.setText("Assign");
    btnAssign.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAssignActionPerformed(evt);
      }
    });

    listFiles.setModel(createModel());
    listFiles.setFocusable(false);
    listFiles.setOpaque(false);
    scrollFiles.setViewportView(listFiles);

    jLabel2.setText("To files:");

    textReplicateNumber.setDocument(DocumentFilters.getDigitsOnlyFilter());

    jLabel3.setText("Replicate number:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(scrollFiles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jLabel1)
              .addComponent(jLabel3))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(textReplicateNumber, javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(textExperimentName)))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAssign)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnCance)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(textExperimentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(textReplicateNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel2)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(btnCance)
            .addComponent(btnAssign)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(scrollFiles, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        isOk = true;
        dispose();
    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnCanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanceActionPerformed
        dispose();
    }//GEN-LAST:event_btnCanceActionPerformed

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
            java.util.logging.Logger.getLogger(ExperimentNameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExperimentNameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExperimentNameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExperimentNameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ExperimentNameDialog dialog = new ExperimentNameDialog(new javax.swing.JFrame(), true, Collections.emptyList());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAssign;
  private javax.swing.JButton btnCance;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JList<String> listFiles;
  private javax.swing.JScrollPane scrollFiles;
  private javax.swing.JTextField textExperimentName;
  private javax.swing.JTextField textReplicateNumber;
  // End of variables declaration//GEN-END:variables
}
