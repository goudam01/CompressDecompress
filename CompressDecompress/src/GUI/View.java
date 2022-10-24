/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import Project.Compress;
import Project.Decompress;
import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author goudam
 */
public class View extends JFrame implements  ActionListener{
    JButton compressButton;
    JButton decompressButton;
    JButton selectButton;
    File file;
    JLabel displayField1;
    JLabel displayField2;
    JLabel displayField3;
    ImageIcon image1;
    ImageIcon image2;
    ImageIcon image3;
    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(600,500);
        
        selectButton = new JButton("Upload");
        selectButton.addActionListener(this);
        selectButton.setBounds(245, 250, 120, 60);
   
        
        compressButton=new JButton("Compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(150, 380, 150, 50);
        
        decompressButton=new JButton("Decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(310, 380, 150, 50);
        
        this.add(compressButton);
        this.add(decompressButton);
        this.add(selectButton);
        
        
        //this.getContentPane().setBackground(Color.red);
        image1 = new ImageIcon(getClass().getResource("5.png"));
        displayField1 = new JLabel(image1);
        displayField1.setBounds(255,50,100,100);
                
        image3 = new ImageIcon(getClass().getResource("6.png"));
        displayField3 = new JLabel(image3);
        displayField3.setBounds(390,229,100,100);
        displayField3.setVisible(false);
        
        image2 = new ImageIcon(getClass().getResource("2.jpg"));
        displayField2 = new JLabel(image2);
        displayField2.setBounds(0,0,800,600);
        
        this.add(displayField1);
        this.add(displayField3);
        this.add(displayField2);
        
        
       
      }
     @Override
     public void actionPerformed(ActionEvent e){
        if(e.getSource() == selectButton){
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(this);
            if(response == JFileChooser.APPROVE_OPTION){
                displayField3.setVisible(true);
                file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
        }
        if(e.getSource() == compressButton){
            if(file==null){
                JOptionPane.showMessageDialog(null, "Uploaded a file for compression");
                return;
            }
            try{
                  Compress.method(file);
                  JOptionPane.showMessageDialog(null, "compression Successful");
                  displayField3.setVisible(false);
                  file = null;
                }
            catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                    }
        }
            
        if(e.getSource() == decompressButton){
                if(file == null){
                    JOptionPane.showMessageDialog(null, "Uploaded a file for decompression");
                    return;
                }
                try{
                    Decompress.method(file);
                    JOptionPane.showMessageDialog(null, "decompression Successful");
                    displayField3.setVisible(false);
                    file=null;
                    }
                    catch(Exception excp){
                        JOptionPane.showMessageDialog(null, excp.toString());
                     }
                 }
             }
    
    public static void main(String[] args) {
            View frame=new View();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
    }

    
    

  
}
