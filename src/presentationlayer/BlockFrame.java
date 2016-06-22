/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import java.awt.event.ActionListener;

/**
 *
 * @author jnmkimpton
 */
public class BlockFrame extends javax.swing.JFrame {

    private MainFrame mainframe;
    
    /*
     * New BlockFrame
     */
    public BlockFrame(MainFrame mainframe) {
        setLocation(400,400);
        initComponents();
        this.mainframe = mainframe;
    }
    /**
     * Length
     * 
     * @return length
     */
    public int getLengthValue()
    {
        return Integer.parseInt(txtLength.getText());
    }
    
    /**
     * Width 
     * 
     * @return width
     */
    public int getWidthValue()
    {
        return Integer.parseInt(txtWidth.getText());
    }
    
    /**
     * Height
     * 
     * @return height
     */
    public int getHeightValue()
    {
        return Integer.parseInt(txtHeigth.getText());
    }
    
    public void setEmptyValue()
    {
        txtLength.setText(null);
        txtWidth.setText(null);
        txtHeigth.setText(null);
    }
    
    /**
     * Cancelbutton actionlistener
     * 
     * @param listenerForCancelButton 
     */
    public void addbtnCancelListener(ActionListener listenerForCancelButton) {
        btnCancel.addActionListener(listenerForCancelButton);
    }
    
    /** 
     * Addbutton actionlistener
     * 
     * @param listenerForAddButton 
     */
    public void addbtnAddShapeListener(ActionListener listenerForAddButton) {
        btnAdd.addActionListener(listenerForAddButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblLength = new javax.swing.JLabel();
        lblWidth = new javax.swing.JLabel();
        lblHeigth = new javax.swing.JLabel();
        txtLength = new javax.swing.JTextField();
        txtWidth = new javax.swing.JTextField();
        txtHeigth = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Block");

        btnAdd.setText("Add");
        btnAdd.setName("Block"); // NOI18N

        btnCancel.setText("Cancel");

        lblLength.setText("Length:");

        lblWidth.setText("Width:");

        lblHeigth.setText("Heigth:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLength)
                                .addGap(18, 18, 18)
                                .addComponent(txtLength))
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblWidth)
                            .addComponent(lblHeigth))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(txtWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtHeigth)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLength)
                    .addComponent(txtLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWidth)
                    .addComponent(txtWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHeigth)
                    .addComponent(txtHeigth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel lblHeigth;
    private javax.swing.JLabel lblLength;
    private javax.swing.JLabel lblWidth;
    private javax.swing.JTextField txtHeigth;
    private javax.swing.JTextField txtLength;
    private javax.swing.JTextField txtWidth;
    // End of variables declaration//GEN-END:variables
}