package BlogDB;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AppMain {

	public static void main(String[] args) {
		
		//runnable
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            JFrame f=new JFrame("Administrator's Control Panel - Blog Moderator");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
            f.getContentPane().add(new BlogUI());
            f.setPreferredSize(new Dimension(600,400));
            f.setLocationRelativeTo(null); 
         //   f.setSize(800, 380);
            f.pack();
            f.setVisible(true);
            }
		});
   }
}