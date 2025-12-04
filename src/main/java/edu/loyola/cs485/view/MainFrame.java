package edu.loyola.cs485.view;

import javax.swing.*;

public class MainFrame extends JFrame{
    public MainFrame() {
        super("Soccer Leagues");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        createMenuBar();
    }

    public void createMenuBar() {
        JMenuBar menuBar = new JMenuBar(); // A Frame can only have one menubar

        JMenu mnuFile = new JMenu("File"); // Each JMenu is th top menu option
        //Each menu will have many MenuItems
        JMenuItem mniClient = new JMenuItem("League CRUD");
        mniClient.addActionListener(e -> {
            //Code called when clicking on this menuitem
            createClientCrudDialog();
        });
        mnuFile.add(mniClient);
        mnuFile.addSeparator();

        JMenuItem mniExit = new JMenuItem("Exit");
        mniExit.addActionListener(e ->{
            System.exit(0);
        });
        mnuFile.add(mniExit);

        menuBar.add(mnuFile);
        this.setJMenuBar(menuBar);
    }

    public void createLeagueCrudDialog(){
        LeagueCrudDialog dialog = new LeagueCrudDialog();
        dialog.pack();
        dialog.setVisible(true);
    }
}
