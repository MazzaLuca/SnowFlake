/*
 * The MIT License
 *
 * Copyright 2019 lucamazza.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package snowpackage;

import java.awt.Color;
import java.io.File;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Luca Mazza
 * @since 1.0
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame.
     */
    public MainFrame(boolean loader, String handle) {
        initComponents();
        if(loader){
            File handleFile = new File(handle);
            trianglePanel.deSerialize(handleFile);
        }
        snowFlakePanel.tf = trianglePanel;
        strokePreviewPanel.setBackground(Color.black);
        strokePreviewPanel.repaint();
        fillPreviewPanel.setBackground(new Color(22, 152, 175));
        fillPreviewPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        snowFlakePanel = new snowpackage.SnowFlakePanel();
        jPanel1 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        fillSelector = new javax.swing.JCheckBox();
        fillPreviewPanel = new javax.swing.JPanel();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        strokeSelector = new javax.swing.JCheckBox();
        strokePreviewPanel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        resetCuts = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        savePoly = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        exportAsSVG = new javax.swing.JButton();
        exportAsPNG = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        NewFlake = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        PointSizeLabel = new javax.swing.JLabel();
        pointSize = new javax.swing.JSlider();
        jToolBar3 = new javax.swing.JToolBar();
        trianglePanel = new snowpackage.TrianglePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        snowFlakePanel.setBackground(Color.WHITE);

        javax.swing.GroupLayout snowFlakePanelLayout = new javax.swing.GroupLayout(snowFlakePanel);
        snowFlakePanel.setLayout(snowFlakePanelLayout);
        snowFlakePanelLayout.setHorizontalGroup(
            snowFlakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 865, Short.MAX_VALUE)
        );
        snowFlakePanelLayout.setVerticalGroup(
            snowFlakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );

        getContentPane().add(snowFlakePanel, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridBagLayout());
        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        jToolBar2.setRollover(true);
        jToolBar2.add(jSeparator4);

        fillSelector.setSelected(true);
        fillSelector.setFocusable(false);
        fillSelector.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fillSelector.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        fillSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillSelectorActionPerformed(evt);
            }
        });
        jToolBar2.add(fillSelector);

        fillPreviewPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fillPreviewPanel.setToolTipText("Fill");
        fillPreviewPanel.setMaximumSize(new java.awt.Dimension(10, 10));
        fillPreviewPanel.setMinimumSize(new java.awt.Dimension(10, 10));
        fillPreviewPanel.setPreferredSize(new java.awt.Dimension(10, 10));
        fillPreviewPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fillPreviewPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fillPreviewPanelLayout = new javax.swing.GroupLayout(fillPreviewPanel);
        fillPreviewPanel.setLayout(fillPreviewPanelLayout);
        fillPreviewPanelLayout.setHorizontalGroup(
            fillPreviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        fillPreviewPanelLayout.setVerticalGroup(
            fillPreviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jToolBar2.add(fillPreviewPanel);
        jToolBar2.add(jSeparator7);

        strokeSelector.setFocusable(false);
        strokeSelector.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        strokeSelector.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        strokeSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strokeSelectorActionPerformed(evt);
            }
        });
        jToolBar2.add(strokeSelector);

        strokePreviewPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        strokePreviewPanel.setToolTipText("Stroke");
        strokePreviewPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        strokePreviewPanel.setMaximumSize(new java.awt.Dimension(10, 10));
        strokePreviewPanel.setMinimumSize(new java.awt.Dimension(10, 10));
        strokePreviewPanel.setPreferredSize(new java.awt.Dimension(10, 10));
        strokePreviewPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                strokePreviewPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout strokePreviewPanelLayout = new javax.swing.GroupLayout(strokePreviewPanel);
        strokePreviewPanel.setLayout(strokePreviewPanelLayout);
        strokePreviewPanelLayout.setHorizontalGroup(
            strokePreviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        strokePreviewPanelLayout.setVerticalGroup(
            strokePreviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jToolBar2.add(strokePreviewPanel);
        jToolBar2.add(jSeparator2);

        resetCuts.setText("Reset");
        resetCuts.setToolTipText("Reset");
        resetCuts.setFocusable(false);
        resetCuts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        resetCuts.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        resetCuts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetCutsActionPerformed(evt);
            }
        });
        jToolBar2.add(resetCuts);
        jToolBar2.add(jSeparator5);

        savePoly.setText("Snapshot");
        savePoly.setToolTipText("Snapshot");
        savePoly.setFocusable(false);
        savePoly.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        savePoly.setMaximumSize(new java.awt.Dimension(70, 70));
        savePoly.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        savePoly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePolyActionPerformed(evt);
            }
        });
        jToolBar2.add(savePoly);
        jToolBar2.add(jSeparator1);

        exportAsSVG.setText("Export as SVG");
        exportAsSVG.setToolTipText("Export as SVG");
        exportAsSVG.setFocusable(false);
        exportAsSVG.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportAsSVG.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exportAsSVG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportAsSVGActionPerformed(evt);
            }
        });
        jToolBar2.add(exportAsSVG);

        exportAsPNG.setText("Export as PNG");
        exportAsPNG.setToolTipText("Export as PNG");
        exportAsPNG.setFocusable(false);
        exportAsPNG.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportAsPNG.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exportAsPNG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportAsPNGActionPerformed(evt);
            }
        });
        jToolBar2.add(exportAsPNG);
        jToolBar2.add(jSeparator6);

        NewFlake.setText("New");
        NewFlake.setToolTipText("New snowflake");
        NewFlake.setFocusable(false);
        NewFlake.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NewFlake.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        NewFlake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewFlakeActionPerformed(evt);
            }
        });
        jToolBar2.add(NewFlake);
        jToolBar2.add(jSeparator3);

        PointSizeLabel.setText("Point size");
        jToolBar2.add(PointSizeLabel);

        pointSize.setMaximum(50);
        pointSize.setMinimum(5);
        pointSize.setToolTipText("");
        pointSize.setValue(5);
        pointSize.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pointSizeStateChanged(evt);
            }
        });
        jToolBar2.add(pointSize);

        getContentPane().add(jToolBar2, java.awt.BorderLayout.PAGE_START);

        jToolBar3.setRollover(true);

        trianglePanel.setBackground(Color.WHITE);
        trianglePanel.setMaximumSize(new java.awt.Dimension(300, 500));
        trianglePanel.setMinimumSize(new java.awt.Dimension(300, 500));
        trianglePanel.setOpaque(false);
        trianglePanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                trianglePanelMouseDragged(evt);
            }
        });
        trianglePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                trianglePanelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout trianglePanelLayout = new javax.swing.GroupLayout(trianglePanel);
        trianglePanel.setLayout(trianglePanelLayout);
        trianglePanelLayout.setHorizontalGroup(
            trianglePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        trianglePanelLayout.setVerticalGroup(
            trianglePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jToolBar3.add(trianglePanel);
        trianglePanel.getAccessibleContext().setAccessibleParent(snowFlakePanel);

        getContentPane().add(jToolBar3, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Repaints the <code>JPanel</code> object snowFlakePanel when the mouse is
     * dragged on it, in order to achieve the simultaneous repainting of the two
     * panels, recreating a live preview.
     * 
     * @param evt <code>MouseListener</code> event that register the whole list
     * of mouse events
     */
    private void trianglePanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trianglePanelMouseDragged
        snowFlakePanel.repaint();
    }//GEN-LAST:event_trianglePanelMouseDragged

    /**
     * 
     * @param evt <code>JSlider</code> event that register the whole list
     * of mouse events.
     */
    private void pointSizeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pointSizeStateChanged
        trianglePanel.RAD = pointSize.getValue();
        trianglePanel.repaint();
    }//GEN-LAST:event_pointSizeStateChanged

    /**
     * 
     * @param evt <code>JButton</code> event that register the whole list
     * of mouse events.
     */
    private void resetCutsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetCutsActionPerformed
        Object[] options = { "Ok", "Cancel" };
        int response = JOptionPane.showOptionDialog(null,
             "Are you sure you want to discard all changes", "Warning",
             JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
             null, options, options[0]);
        if(JOptionPane.YES_OPTION == response){
            trianglePanel.poly.reset();
            trianglePanel.points.clear();
            trianglePanel.repaint();
            snowFlakePanel.repaint();
            trianglePanel.fillColor = new Color(22, 152, 175);
            trianglePanel.strokeColor = Color.BLACK;
            snowFlakePanel.fillColor = new Color(22, 152, 175);
            snowFlakePanel.strokeColor = Color.BLACK;
            snowFlakePanel.tf = trianglePanel;
            strokePreviewPanel.setBackground(Color.black);
            strokePreviewPanel.repaint();
            fillPreviewPanel.setBackground(new Color(22, 152, 175));
            fillPreviewPanel.repaint();
        }
        snowFlakePanel.repaint();
    }//GEN-LAST:event_resetCutsActionPerformed

    /**
     * 
     * @param evt <code>JButton</code> event that register the whole list
     * of mouse events.
     */
    private void savePolyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePolyActionPerformed
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter fnf = new FileNameExtensionFilter("Snowflake file (*.snowflake)", "snowflake");
        jfc.setFileFilter(fnf);
        jfc.showDialog(null, "Save");
        try{
            String handle = new String(jfc.getSelectedFile().toPath().toString());
            File handleFile = new File(handle);
            trianglePanel.serialize(handleFile);
        }catch(NullPointerException npe){
            System.out.println("Closed");
        }

    }//GEN-LAST:event_savePolyActionPerformed

    /**
     * 
     * @param evt <code>JButton</code> event that register the whole list
     * of mouse events.
     */
    private void NewFlakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewFlakeActionPerformed
        if(!trianglePanel.points.isEmpty()){
            Object[] options = { "Ok", "Cancel" };
            int response = JOptionPane.showOptionDialog(null,
                 "Are you sure you want to exit without saving?", "Warning",
                 JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                 null, options, options[0]);
            if(JOptionPane.YES_OPTION == response){
                OpenNew on = new OpenNew(null, false);
                this.dispose();
                on.setVisible(true);
            }
        }else{
            OpenNew on = new OpenNew(null, false);
            this.dispose();
            on.setVisible(true);
        }
        
    }//GEN-LAST:event_NewFlakeActionPerformed

    /**
     * 
     * @param evt <code>JButton</code> event that register the whole list
     * of mouse events.
     */
    private void exportAsSVGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportAsSVGActionPerformed
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter fnf = new FileNameExtensionFilter("SVG File (*.svg)", "SVG");
        jfc.setFileFilter(fnf);
        jfc.showDialog(null, "Save");
        try{
            String handle = new String(jfc.getSelectedFile().toPath().toString());
            snowFlakePanel.generateSVG(handle);
        }catch(NullPointerException npe){
        }
    }//GEN-LAST:event_exportAsSVGActionPerformed

    /**
     * 
     * @param evt <code>JButton</code> event that register the whole list
     * of mouse events.
     */
    private void exportAsPNGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportAsPNGActionPerformed
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter fnf = new FileNameExtensionFilter("PNG File (*.png)", "PNG");
        jfc.setFileFilter(fnf);
        jfc.showDialog(null, "Save");
        try{
            String handle = new String(jfc.getSelectedFile().toPath().toString());
            snowFlakePanel.generatePNG(handle, 600);
        }catch(NullPointerException npe){
        }
    }//GEN-LAST:event_exportAsPNGActionPerformed
    
    /**
     * 
     * @param evt 
     */
    private void fillPreviewPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fillPreviewPanelMouseClicked
        JColorChooser jcc = new JColorChooser();
        Color c = jcc.showDialog(null, "Select a color", Color.BLACK);
        snowFlakePanel.fillColor = c;
        snowFlakePanel.repaint();
        trianglePanel.fillColor = c;
        trianglePanel.repaint();
        fillPreviewPanel.setBackground(c);
        fillPreviewPanel.repaint();
    }//GEN-LAST:event_fillPreviewPanelMouseClicked
    
    /**
     * 
     * @param evt 
     */
    private void strokePreviewPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_strokePreviewPanelMouseClicked
        JColorChooser jcc = new JColorChooser();
        Color c = jcc.showDialog(null, "Select a color", Color.BLACK);
        snowFlakePanel.strokeColor = c;
        snowFlakePanel.repaint();
        trianglePanel.strokeColor = c;
        trianglePanel.repaint();
        strokePreviewPanel.setBackground(c);
        strokePreviewPanel.repaint();
    }//GEN-LAST:event_strokePreviewPanelMouseClicked
    
    /**
     * 
     * @param evt 
     */
    private void fillSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillSelectorActionPerformed
        snowFlakePanel.fill = !snowFlakePanel.fill;
        trianglePanel.fill = !trianglePanel.fill;
        snowFlakePanel.repaint();
        trianglePanel.repaint();
    }//GEN-LAST:event_fillSelectorActionPerformed

    private void strokeSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strokeSelectorActionPerformed
        snowFlakePanel.stroke = !snowFlakePanel.stroke;
        trianglePanel.stroke = !trianglePanel.stroke;
        snowFlakePanel.repaint();
        trianglePanel.repaint();
    }//GEN-LAST:event_strokeSelectorActionPerformed

    private void trianglePanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trianglePanelMouseReleased
        snowFlakePanel.repaint();
    }//GEN-LAST:event_trianglePanelMouseReleased

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame(false, "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NewFlake;
    private javax.swing.JLabel PointSizeLabel;
    private javax.swing.JButton exportAsPNG;
    private javax.swing.JButton exportAsSVG;
    private javax.swing.JPanel fillPreviewPanel;
    private javax.swing.JCheckBox fillSelector;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JSlider pointSize;
    private javax.swing.JButton resetCuts;
    private javax.swing.JButton savePoly;
    private snowpackage.SnowFlakePanel snowFlakePanel;
    private javax.swing.JPanel strokePreviewPanel;
    private javax.swing.JCheckBox strokeSelector;
    private snowpackage.TrianglePanel trianglePanel;
    // End of variables declaration//GEN-END:variables
}
