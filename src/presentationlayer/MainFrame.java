package presentationlayer;

import domainlayer.ShapeType;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;

/**
 * @author John Kimpton
 *
 */
public class MainFrame extends javax.swing.JFrame {
    
    /**
     * Creates new MainFrame
     */
    public MainFrame() {
        setLocation(400,400);
        initComponents();
        
    }
    
    /**
     * Get selected item from dropdownlist
     * 
     * @return selected item
     */
    public ShapeType getSelectedShapeDropdownValue() {
        return (ShapeType) cbShapes.getSelectedItem();
    }
    
    /**
     * listener for add button
     * 
     * @param listenerForAddButton 
     */
    public void addbtnAddListener(ActionListener listenerForAddButton) {
        btnAddShape.addActionListener(listenerForAddButton);
    }
    
    /**
     * listener for listcollection
     * 
     * @param listenerForListSC 
     */
    public void addListShapeCollectionListener(ListSelectionListener listenerForListSC) {
        listShapeCollection.addListSelectionListener(listenerForListSC);
    }
    
    /**
     * listener for listcollection
     * 
     * @param listenerForListTable 
     */
    public void addListTableCollectionListener(ListSelectionListener listenerForListTable) {
        listDatabaseTables.addListSelectionListener(listenerForListTable);
    }
    
    /**
     * listener for deletecollectionbutton
     * 
     * @param listenerForDeleteCollectionButton 
     */
    public void addbtnDeleteCollectionListener(ActionListener listenerForDeleteCollectionButton) {
        btnDeleteCollection.addActionListener(listenerForDeleteCollectionButton);
    }
    
    /**
     * listener for deleteshapebutton
     * 
     * @param listenerForDeleteButton 
     */
    public void addbtnDeleteShapeListener(ActionListener listenerForDeleteButton) {
        btnDeleteShape.addActionListener(listenerForDeleteButton);
    }
    
    public void addbtnReadDatabase(ActionListener listenerForReadDatabase) {
        btnLoadDB.addActionListener(listenerForReadDatabase);
    }
    
    public void addbtnSaveToDatabase(ActionListener listenerForSaveToDatabase) {
        btnSaveDB.addActionListener(listenerForSaveToDatabase);
    }
    
    public void addbtnDeleteTable(ActionListener listenerForDeleteTable) {
        btnDeleteDB.addActionListener(listenerForDeleteTable);
    }
    
    public void addbtnSaveFile(ActionListener listenerForSaveFile) {
        btnSaveFile.addActionListener(listenerForSaveFile);
    }
    
    public void addbtnReadFile(ActionListener listenerForReadFile) {
        btnLoadFile.addActionListener(listenerForReadFile);
    }
    
    /** 
     * Get selected index of shapelist
     * 
     * @return index
     */
    public int getSelectedListIndex() {
        return listShapeCollection.getSelectedIndex();
    }
    
    /** 
     * Get selected index of tablelist
     * 
     * @return index
     */
    public int getSelectedTableListIndex() {
        return listDatabaseTables.getSelectedIndex();
    }
    
    /**
     * Refill list
     * 
     * @param items 
     */
    @SuppressWarnings("unchecked") // Causes a compile error: unchecked insert on the adding of objects
    public void refillList(Object[] items) {
        listShapeCollection.removeAll(); //clear list
        DefaultListModel dlm = new DefaultListModel();

        for (Object item : items) {
            dlm.addElement(item);
        }
        if (items.length == 0) //if collection has no items
        {
            dlm.addElement("No items");
            txtShape.setText("-");
            txtLength.setText("-");
            txtWidth.setText("-");
            txtHeight.setText("-");
            txtRadius.setText("-");
            txtVolume.setText("-");
        }
        listShapeCollection.setModel(dlm);
    }
    
    @SuppressWarnings("unchecked")
    public void refillTableList(Object[] items) {
        listDatabaseTables.removeAll();
        DefaultListModel dlm = new DefaultListModel();
        
        for(Object item : items) {
            dlm.addElement(item);
        }
        
        if(items.length == 0) {
            dlm.addElement("No tables");
        }
        
        listDatabaseTables.setModel(dlm);
    }
    
    /** 
     * Set total volume of all shapes
     * 
     * @param totalvolume 
     */
    public void setTotalVolume(double totalvolume) {
        DecimalFormat df = new DecimalFormat("#0.00"); //set decimal format
        txtTotalVolume.setText(df.format(totalvolume));
    }
    
    /**
     * Set type of shape
     * 
     * @param type 
     */
    public void setShape(ShapeType type) {
        txtShape.setText(type.toString());
    }
    
    /**
     * Set length of shape
     * 
     * @param length 
     */
    public void setLength(int length) {
        String value = (length == 0) ? "-" : Integer.toString(length);
        txtLength.setText(value);
    }
    
    /**
     * Set width of shape
     * 
     * @param width 
     */
    public void setWidth(int width) {
        String value = (width == 0) ? "-" : Integer.toString(width);
        txtWidth.setText(value);
    }
    
    /**
     * Set height ofshape
     * 
     * @param height 
     */
    public void setHeight(int height) {
        String value = (height == 0) ? "-" : Integer.toString(height);
        txtHeight.setText(value);
    }
    
    /**
     * Set radius of shape
     * 
     * @param radius 
     */
    public void setRadius(int radius) {
        String value = (radius == 0) ? "-" : Integer.toString(radius);
        txtRadius.setText(value);
    }
    
    /**
     * Set volume of shape
     * 
     * @param volume 
     */
    public void setVolume(double volume) {
        DecimalFormat df = new DecimalFormat("#0.00"); //set decimal format
        String value = (volume == 0.0) ? "-" : df.format(volume);
        txtVolume.setText(value);
    }
    
    public void setTableName(String tablename) {
        txtTableName.setText(tablename);
    }
    
    public String getTableName() {
        return txtTableName.getText();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        lblLength1 = new javax.swing.JLabel();
        txtLength1 = new javax.swing.JTextField();
        pnlCollection = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listShapeCollection = new javax.swing.JList();
        lblTotalVolume = new javax.swing.JLabel();
        txtTotalVolume = new javax.swing.JTextField();
        btnDeleteCollection = new javax.swing.JButton();
        pnlShapeInfo = new javax.swing.JPanel();
        lblShape = new javax.swing.JLabel();
        txtShape = new javax.swing.JTextField();
        lblHeight = new javax.swing.JLabel();
        txtHeight = new javax.swing.JTextField();
        lblLength = new javax.swing.JLabel();
        txtLength = new javax.swing.JTextField();
        lblWidth = new javax.swing.JLabel();
        txtWidth = new javax.swing.JTextField();
        lblRadius = new javax.swing.JLabel();
        txtRadius = new javax.swing.JTextField();
        lblVolume = new javax.swing.JLabel();
        txtVolume = new javax.swing.JTextField();
        btnDeleteShape = new javax.swing.JButton();
        pnlImpExp = new javax.swing.JPanel();
        btnLoadFile = new javax.swing.JButton();
        btnSaveFile = new javax.swing.JButton();
        pnlAddShape = new javax.swing.JPanel();
        btnAddShape = new javax.swing.JButton();
        cbShapes = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        btnLoadDB = new javax.swing.JButton();
        btnSaveDB = new javax.swing.JButton();
        btnDeleteDB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblTableName = new javax.swing.JLabel();
        txtTableName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listDatabaseTables = new javax.swing.JList();

        jTextField1.setText("jTextField1");

        lblLength1.setText("Lengte:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vorm Analyse Tool");
        setLocation(new java.awt.Point(400, 300));

        pnlCollection.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Collection", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jScrollPane1.setViewportView(listShapeCollection);

        lblTotalVolume.setText("Total volume:");

        txtTotalVolume.setEditable(false);

        btnDeleteCollection.setText("Delete collection");

        org.jdesktop.layout.GroupLayout pnlCollectionLayout = new org.jdesktop.layout.GroupLayout(pnlCollection);
        pnlCollection.setLayout(pnlCollectionLayout);
        pnlCollectionLayout.setHorizontalGroup(
            pnlCollectionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlCollectionLayout.createSequentialGroup()
                .add(pnlCollectionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnDeleteCollection, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(pnlCollectionLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(pnlCollectionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane1)
                            .add(pnlCollectionLayout.createSequentialGroup()
                                .add(lblTotalVolume)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(txtTotalVolume)))))
                .addContainerGap())
        );
        pnlCollectionLayout.setVerticalGroup(
            pnlCollectionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlCollectionLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnlCollectionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblTotalVolume)
                    .add(txtTotalVolume, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(btnDeleteCollection)
                .addContainerGap())
        );

        pnlShapeInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Shape data", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        lblShape.setText("Shape:");

        txtShape.setEditable(false);

        lblHeight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeight.setText("Heigth:");

        txtHeight.setEditable(false);

        lblLength.setText("Length:");

        txtLength.setEditable(false);

        lblWidth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWidth.setText("Width:");

        txtWidth.setEditable(false);

        lblRadius.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRadius.setText("Radius:");

        txtRadius.setEditable(false);

        lblVolume.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVolume.setText("Volume:");

        txtVolume.setEditable(false);

        btnDeleteShape.setText("Delete");

        org.jdesktop.layout.GroupLayout pnlShapeInfoLayout = new org.jdesktop.layout.GroupLayout(pnlShapeInfo);
        pnlShapeInfo.setLayout(pnlShapeInfoLayout);
        pnlShapeInfoLayout.setHorizontalGroup(
            pnlShapeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlShapeInfoLayout.createSequentialGroup()
                .addContainerGap()
                .add(pnlShapeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnDeleteShape, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(pnlShapeInfoLayout.createSequentialGroup()
                        .add(pnlShapeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblShape)
                            .add(lblRadius)
                            .add(lblLength)
                            .add(lblWidth)
                            .add(lblHeight)
                            .add(lblVolume))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(pnlShapeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtRadius, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtHeight)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtShape)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtLength)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtWidth)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtVolume))))
                .addContainerGap())
        );
        pnlShapeInfoLayout.setVerticalGroup(
            pnlShapeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlShapeInfoLayout.createSequentialGroup()
                .addContainerGap()
                .add(pnlShapeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblShape)
                    .add(txtShape, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnlShapeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblLength, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtLength, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(pnlShapeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblWidth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtWidth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnlShapeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblHeight, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtHeight, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnlShapeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblRadius, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtRadius, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnlShapeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblVolume, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtVolume, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(btnDeleteShape)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlImpExp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "File", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        btnLoadFile.setText("Load file");

        btnSaveFile.setText("Save as");

        org.jdesktop.layout.GroupLayout pnlImpExpLayout = new org.jdesktop.layout.GroupLayout(pnlImpExp);
        pnlImpExp.setLayout(pnlImpExpLayout);
        pnlImpExpLayout.setHorizontalGroup(
            pnlImpExpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlImpExpLayout.createSequentialGroup()
                .addContainerGap()
                .add(pnlImpExpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnLoadFile, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btnSaveFile, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlImpExpLayout.setVerticalGroup(
            pnlImpExpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlImpExpLayout.createSequentialGroup()
                .addContainerGap()
                .add(btnLoadFile)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(btnSaveFile)
                .addContainerGap())
        );

        pnlAddShape.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add shape", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        btnAddShape.setText("Add");

        cbShapes.setModel(new DefaultComboBoxModel(ShapeType.values()));

        org.jdesktop.layout.GroupLayout pnlAddShapeLayout = new org.jdesktop.layout.GroupLayout(pnlAddShape);
        pnlAddShape.setLayout(pnlAddShapeLayout);
        pnlAddShapeLayout.setHorizontalGroup(
            pnlAddShapeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlAddShapeLayout.createSequentialGroup()
                .addContainerGap()
                .add(pnlAddShapeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnAddShape, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(cbShapes, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlAddShapeLayout.setVerticalGroup(
            pnlAddShapeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlAddShapeLayout.createSequentialGroup()
                .addContainerGap()
                .add(cbShapes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(12, 12, 12)
                .add(btnAddShape)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Database", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        btnLoadDB.setText("Load table");

        btnSaveDB.setText("Save table as");

        btnDeleteDB.setText("Delete table");

        jLabel1.setText("Save data into MySQL Database.");

        lblTableName.setText("Table name:");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnSaveDB, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btnLoadDB, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, btnDeleteDB, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(lblTableName)
                        .add(18, 18, 18)
                        .add(txtTableName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 195, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(56, 56, 56))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel1)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblTableName)
                    .add(txtTableName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(btnLoadDB)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnSaveDB)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnDeleteDB)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Database tables", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jScrollPane2.setViewportView(listDatabaseTables);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 217, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(pnlImpExp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(pnlCollection, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(pnlShapeInfo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(pnlAddShape, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(pnlShapeInfo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(pnlCollection, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(pnlAddShape, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(pnlImpExp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddShape;
    private javax.swing.JButton btnDeleteCollection;
    private javax.swing.JButton btnDeleteDB;
    private javax.swing.JButton btnDeleteShape;
    private javax.swing.JButton btnLoadDB;
    private javax.swing.JButton btnLoadFile;
    private javax.swing.JButton btnSaveDB;
    private javax.swing.JButton btnSaveFile;
    private javax.swing.JComboBox cbShapes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblHeight;
    private javax.swing.JLabel lblLength;
    private javax.swing.JLabel lblLength1;
    private javax.swing.JLabel lblRadius;
    private javax.swing.JLabel lblShape;
    private javax.swing.JLabel lblTableName;
    private javax.swing.JLabel lblTotalVolume;
    private javax.swing.JLabel lblVolume;
    private javax.swing.JLabel lblWidth;
    private javax.swing.JList listDatabaseTables;
    private javax.swing.JList listShapeCollection;
    private javax.swing.JPanel pnlAddShape;
    private javax.swing.JPanel pnlCollection;
    private javax.swing.JPanel pnlImpExp;
    private javax.swing.JPanel pnlShapeInfo;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtLength;
    private javax.swing.JTextField txtLength1;
    private javax.swing.JTextField txtRadius;
    private javax.swing.JTextField txtShape;
    private javax.swing.JTextField txtTableName;
    private javax.swing.JTextField txtTotalVolume;
    private javax.swing.JTextField txtVolume;
    private javax.swing.JTextField txtWidth;
    // End of variables declaration//GEN-END:variables
}
