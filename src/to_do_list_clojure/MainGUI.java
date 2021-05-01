package to_do_list_clojure;

public class MainGUI extends javax.swing.JFrame {

    public MainGUI() {
        initComponents();
    }


    private void initComponents() {

        dateScrollPane = new javax.swing.JScrollPane();
        dateList = new javax.swing.JList<>();
        entryListLabel = new javax.swing.JLabel();
        dateListLabel = new javax.swing.JLabel();
        selectDateButton = new javax.swing.JButton();
        tipsScrollPane = new javax.swing.JScrollPane();
        tipsTextPane = new javax.swing.JTextPane();
        entriesScrollPane = new javax.swing.JScrollPane();
        entriesList = new javax.swing.JList<>();
        completedButton = new javax.swing.JButton();
        toDoListTitleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("To-Do List");

        dateList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        dateScrollPane.setViewportView(dateList);

        entryListLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        entryListLabel.setText("Entries");

        dateListLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dateListLabel.setText("Date");

        selectDateButton.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        selectDateButton.setText("Select");
        selectDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDateButtonActionPerformed(evt);
            }
        });

        tipsTextPane.setEditable(false);
        tipsTextPane.setBackground(new java.awt.Color(240, 240, 240));
        tipsTextPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tipsTextPane.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tipsTextPane.setText("TIPS:");
        tipsScrollPane.setViewportView(tipsTextPane);

        entriesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        entriesScrollPane.setViewportView(entriesList);

        completedButton.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        completedButton.setText("Mark Complete");
        completedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completedButtonActionPerformed(evt);
            }
        });

        toDoListTitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        toDoListTitleLabel.setText("To-Do List");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tipsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(toDoListTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(dateScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(dateListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(23, 23, 23)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(selectDateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(156, 156, 156)
                                                .addComponent(entryListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(entriesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(completedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dateListLabel)
                                        .addComponent(entryListLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(toDoListTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(65, 65, 65)
                                                .addComponent(tipsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 97, Short.MAX_VALUE))
                                        .addComponent(entriesScrollPane)
                                        .addComponent(dateScrollPane, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(completedButton)
                                        .addComponent(selectDateButton))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void selectDateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void completedButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton completedButton;
    private javax.swing.JList<String> dateList;
    private javax.swing.JLabel dateListLabel;
    private javax.swing.JScrollPane dateScrollPane;
    private javax.swing.JList<String> entriesList;
    private javax.swing.JScrollPane entriesScrollPane;
    private javax.swing.JLabel entryListLabel;
    private javax.swing.JButton selectDateButton;
    private javax.swing.JScrollPane tipsScrollPane;
    private javax.swing.JTextPane tipsTextPane;
    private javax.swing.JLabel toDoListTitleLabel;
    // End of variables declaration
}

